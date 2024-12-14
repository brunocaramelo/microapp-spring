package com.microapp.microapp.service;

import com.microapp.microapp.enitites.CategoryEntity;
import com.microapp.microapp.enitites.DateEntity;
import com.microapp.microapp.services.CategoryService;
import com.microapp.microapp.services.DateService;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class DateServiceTest {


    @Autowired
    private DateService localService;

    private final  String fielToAnalize = "categoryDescription";

    LocalDate valueToAnalizeList = LocalDate.of(2008, 1, 1);

    LocalDate valueToAnalizeOne = LocalDate.of(2008, 1, 4);




    @Test
    @Order(1)
    public void testGetAllItems() throws Exception {

        List<DateEntity> referenceValueList = localService.getAll(0,10);
        LocalDate referenceFirstLine =  referenceValueList.get(0).getCalendarDate();

        assertEquals(referenceFirstLine, valueToAnalizeList);

    }

    @Test
    @Order(2)
    public void testGetOneItem() throws Exception {

        Optional<DateEntity> referenceOneLine = localService.getById(4);
        LocalDate referenceValue =  referenceOneLine.map(DateEntity::getCalendarDate)
                                                         .orElse(LocalDate.of(2008, 1, 4));

        assertEquals(referenceValue, valueToAnalizeOne);

    }

    protected <T> MockMvc createMockMvc(T controller) {
        return MockMvcBuilders
                .standaloneSetup(controller)
                .build();
    }
}
