package com.microapp.microapp.service;

import com.microapp.microapp.enitites.CategoryEntity;
import com.microapp.microapp.enitites.UserEntity;
import com.microapp.microapp.services.CategoryService;
import com.microapp.microapp.services.UserService;
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
public class UserServiceTest {


    @Autowired
    private UserService localService;

    private final  String fielToAnalize = "categoryDescription";

    private final  String valueToAnalizeList = "JSG99FHE";

    private final  String valueToAnalizeOne = "XDZ38RDD";



    @Test
    @Order(1)
    public void testGetAllItems() throws Exception {

        List<UserEntity> referenceValueList = localService.getAll(0,10);
        String referenceValue = (String) referenceValueList.get(0).getUsername();

        assertEquals(valueToAnalizeList, referenceValue);

    }

    @Test
    @Order(2)
    public void testGetOneItem() throws Exception {

        Optional<UserEntity> referenceOneLine = localService.getById(4);
        String referenceValue = (String) referenceOneLine.map(UserEntity::getUsername)
                                                         .orElse("Default Value");

        assertEquals(valueToAnalizeOne, referenceValue);

    }

    protected <T> MockMvc createMockMvc(T controller) {
        return MockMvcBuilders
                .standaloneSetup(controller)
                .build();
    }
}
