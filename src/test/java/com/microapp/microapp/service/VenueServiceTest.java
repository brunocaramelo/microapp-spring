package com.microapp.microapp.service;

import com.microapp.microapp.enitites.CategoryEntity;
import com.microapp.microapp.enitites.VenueEntity;
import com.microapp.microapp.services.CategoryService;
import com.microapp.microapp.services.VenueService;
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
public class VenueServiceTest {


    @Autowired
    private VenueService localService;

    private final  String fielToAnalize = "categoryDescription";

    private final  String valueToAnalizeList = "Toyota Park";

    private final  String valueToAnalizeOne = "CommunityAmerica Ballpark";


    @Test
    @Order(1)
    public void testGetAllItems() throws Exception {

        List<VenueEntity> referenceValueList = localService.getAll(0,10);
        String referenceValue = (String) referenceValueList.get(0).getVenueName();

        assertEquals(valueToAnalizeList, referenceValue);

    }

    @Test
    @Order(2)
    public void testGetOneItem() throws Exception {

        Optional<VenueEntity> referenceOneLine = localService.getById(4);
        String referenceValue = (String) referenceOneLine.map(VenueEntity::getVenueName)
                                                         .orElse("Default Value");

        assertEquals(valueToAnalizeOne, referenceValue);

    }

    protected <T> MockMvc createMockMvc(T controller) {
        return MockMvcBuilders
                .standaloneSetup(controller)
                .build();
    }
}
