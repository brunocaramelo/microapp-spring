package com.microapp.microapp.api;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.microapp.microapp.controllers.CategoryController;
import com.microapp.microapp.controllers.PromotionController;
import com.microapp.microapp.services.CategoryService;
import com.microapp.microapp.services.EventService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class PromotionApiTest {


    @Autowired
    private EventService localService;
    @Autowired
    private PromotionController localController;

    private MockMvc mockMvc;


    private final  String urlAllItem = "/api/promotions/available?contextDate=2008-01-25";

    private final  String fielToAnalize = "eventName";

    @BeforeEach
    void setUp() {
        mockMvc = createMockMvc(localController);
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

        assertEquals("DJ Shadow and Cut Chemist", referenceFirstLine);

    }

    @Test
    @Order(2)
    public void testGetAllFilters() throws Exception {

        MvcResult result = mockMvc.perform(get(urlAllItem+"&categoryId=9&city=Commerce City"))
                .andExpect(status().isOk())
                .andReturn();

        String responseBody = result.getResponse().getContentAsString();

        ObjectMapper objectMapper = new ObjectMapper();
        List<Map<String, Object>> userList = objectMapper.readValue(responseBody, new TypeReference<List<Map<String, Object>>>(){});

        String referenceFirstLine = (String) userList.get(0).get(fielToAnalize);

        assertEquals("Gwen Stefani", referenceFirstLine);

    }



    protected <T> MockMvc createMockMvc(T controller) {
        return MockMvcBuilders
                .standaloneSetup(controller)
                .build();
    }
}
