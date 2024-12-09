package com.microapp.microapp.api;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.microapp.microapp.controllers.CategoryController;
import com.microapp.microapp.controllers.DateController;
import com.microapp.microapp.services.CategoryService;
import com.microapp.microapp.services.DateService;
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

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class DateApiTest {


    @Autowired
    private DateService localService;
    @Autowired
    private DateController localController;

    private MockMvc mockMvc;


    private final  String urlAllItem = "/api/dates/?page=0&pageSize=10";

    private final  String urlOneItem = "/api/dates/1830";

    private final  String fielToAnalize = "calendarDate";

    ArrayList<Integer> valueToAnalizeList = new ArrayList<>(Arrays.asList(2008, 1, 1));

    ArrayList<Integer> valueToAnalizeOne = new ArrayList<>(Arrays.asList(2008, 1, 4));



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

        ArrayList<Object> referenceFirstLine = (ArrayList<Object>) userList.get(0).get(fielToAnalize);

        assertEquals(referenceFirstLine.get(0), valueToAnalizeList.get(0));
        assertEquals(referenceFirstLine.get(1), valueToAnalizeList.get(1));
        assertEquals(referenceFirstLine.get(2), valueToAnalizeList.get(2));

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

        ArrayList<Object> referenceOneLine = (ArrayList<Object>) userList.get(fielToAnalize);

        assertEquals(referenceOneLine.get(0), valueToAnalizeOne.get(0));
        assertEquals(referenceOneLine.get(1), valueToAnalizeOne.get(1));
        assertEquals(referenceOneLine.get(2), valueToAnalizeOne.get(2));


    }

    protected <T> MockMvc createMockMvc(T controller) {
        return MockMvcBuilders
                .standaloneSetup(controller)
                .build();
    }
}
