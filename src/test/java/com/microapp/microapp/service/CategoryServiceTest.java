package com.microapp.microapp.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.microapp.microapp.enitites.CategoryEntity;
import com.microapp.microapp.services.CategoryService;
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
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class CategoryServiceTest {


    @Autowired
    private CategoryService localService;

    private final  String fielToAnalize = "categoryDescription";

    private final  String valueToAnalizeList = "Major League Baseball";

    private final  String valueToAnalizeOne = "National Basketball Association";


    @Test
    @Order(1)
    public void testGetAllItems() throws Exception {

        List<CategoryEntity> referenceValueList = localService.getAll(0,10);
        String referenceValue = (String) referenceValueList.get(0).getCategoryDescription();

        assertEquals(valueToAnalizeList, referenceValue);

    }

    @Test
    @Order(2)
    public void testGetOneItem() throws Exception {

        Optional<CategoryEntity> referenceOneLine = localService.getById(4);
        String referenceValue = (String) referenceOneLine.map(CategoryEntity::getCategoryDescription)
                                                         .orElse("Default Value");

        assertEquals(valueToAnalizeOne, referenceValue);

    }

    protected <T> MockMvc createMockMvc(T controller) {
        return MockMvcBuilders
                .standaloneSetup(controller)
                .build();
    }
}
