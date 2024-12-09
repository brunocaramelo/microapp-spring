package com.microapp.microapp.api;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.microapp.microapp.controllers.UserController;
import com.microapp.microapp.enitites.UserEntity;
import com.microapp.microapp.services.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class UserApiTest {


    @Autowired
    private UserService userService;
    @Autowired
    private UserController userController;

    private MockMvc mockMvc;


    private final  String urlAllItem = "/api/users/?page=0&pageSize=10";

    private final  String urlOneItem = "/api/users/4";

    private final  String fielToAnalize = "username";

    private final  String valueToAnalizeList = "JSG99FHE";

    private final  String valueToAnalizeOne = "XDZ38RDD";


    @BeforeEach
    void setUp() {
        mockMvc = createMockMvc(userController);
    }

    @Test
    @Order(1)
    public void testGetAllItems() throws Exception {

        MvcResult result = mockMvc.perform(get(urlAllItem))
                .andExpect(status().isOk())
                .andReturn();

        String responseBody = result.getResponse().getContentAsString();

        ObjectMapper objectMapper = new ObjectMapper();
        List<Map<String, Object>> userList = objectMapper.readValue(responseBody, new TypeReference<List<Map<String, Object>>>(){});

        String referenceFirstLine = (String) userList.get(0).get(fielToAnalize);

        assertEquals(valueToAnalizeList, referenceFirstLine);

    }

    @Test
    @Order(2)
    public void testGetOneItem() throws Exception {

        MvcResult result = mockMvc.perform(get(urlOneItem))
                .andExpect(status().isOk())
                .andReturn();

       String responseBodyData = result.getResponse().getContentAsString();

        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> userList = objectMapper.readValue(responseBodyData, new TypeReference<Map<String, Object>>(){});

       String referenceOneLine = (String) userList.get(fielToAnalize);

        assertEquals(valueToAnalizeOne, referenceOneLine);

    }

    protected <T> MockMvc createMockMvc(T controller) {
        return MockMvcBuilders
                .standaloneSetup(controller)
                .build();
    }
}
