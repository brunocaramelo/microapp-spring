package com.microapp.microapp.service;

import com.microapp.microapp.enitites.CategoryEntity;
import com.microapp.microapp.enitites.ListingEntity;
import com.microapp.microapp.services.CategoryService;
import com.microapp.microapp.services.ListingService;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class ListingServiceTest {


    @Autowired
    private ListingService localService;

    private final  String fielToAnalize = "categoryDescription";

    private final Integer valueToAnalizeList = 10;

    private final Integer valueToAnalizeOne = 8;


    @Test
    @Order(1)
    public void testGetAllItems() throws Exception {

        List<ListingEntity> referenceValueList = localService.getAll(0,10);
        Integer referenceValue = (Integer) referenceValueList.get(0).getNumberOfTickets();

        assertEquals(valueToAnalizeList, referenceValue);

    }

    @Test
    @Order(2)
    public void testGetOneItem() throws Exception {

        Optional<ListingEntity> referenceOneLine = localService.getById(4);
        Integer referenceValue = (Integer) referenceOneLine.map(ListingEntity::getNumberOfTickets)
                                                         .orElse(10);

        assertEquals(valueToAnalizeOne, referenceValue);

    }

    protected <T> MockMvc createMockMvc(T controller) {
        return MockMvcBuilders
                .standaloneSetup(controller)
                .build();
    }
}
