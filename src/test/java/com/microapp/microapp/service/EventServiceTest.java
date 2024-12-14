package com.microapp.microapp.service;

import com.microapp.microapp.enitites.CategoryEntity;
import com.microapp.microapp.enitites.EventEntity;
import com.microapp.microapp.services.CategoryService;
import com.microapp.microapp.services.EventService;
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
public class EventServiceTest {


    @Autowired
    private EventService localService;

    private final  String fielToAnalize = "categoryDescription";

    private final  String valueToAnalizeList = "Gotterdammerung";

    private final  String valueToAnalizeOne = "La Cenerentola (Cinderella)";


    @Test
    @Order(1)
    public void testGetAllItems() throws Exception {

        List<EventEntity> referenceValueList = localService.getAll(0,10);
        String referenceValue = (String) referenceValueList.get(0).getEventName();

        assertEquals(valueToAnalizeList, referenceValue);

    }

    @Test
    @Order(2)
    public void testGetOneItem() throws Exception {

        Optional<EventEntity> referenceOneLine = localService.getById(4);
        String referenceValue = (String) referenceOneLine.map(EventEntity::getEventName)
                                                         .orElse("Default Value");

        assertEquals(valueToAnalizeOne, referenceValue);

    }

    protected <T> MockMvc createMockMvc(T controller) {
        return MockMvcBuilders
                .standaloneSetup(controller)
                .build();
    }
}
