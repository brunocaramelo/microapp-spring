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

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class PromotionServiceTest {


    @Autowired
    private EventService localService;

    private final  String fielToAnalize = "categoryDescription";

    @Test
    @Order(1)
    public void testGetAllItems() throws Exception {

        List<EventEntity> referenceValueList = localService.findAvailable(LocalDate.of(2008, 01, 25),
                Optional.ofNullable(9),
                Optional.ofNullable("Commerce City"),
                0,
                10);

        String referenceValue = (String) referenceValueList.get(0).getEventName();

        assertEquals("Gwen Stefani", referenceValue);

    }


}
