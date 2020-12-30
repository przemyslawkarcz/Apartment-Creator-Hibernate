package com.example.apartment_creator;

import com.example.apartment_creator.Entities.Premises.Kitchen;
import com.example.apartment_creator.Repositories.Premises.KitchenRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApartmentCreatorApplication.class)
public class KitchenRepositoryTest {

    @Autowired
    KitchenRepository kitchenRepository;

    @Test
    public void findKitchenById (){

        Kitchen kitchenById = kitchenRepository.findKitchenById(2);
        assertEquals("Kitchen", kitchenById.getKitchenName());

    }

    @Test
    @DirtiesContext
    public void deleteKitchenById (){

        Kitchen newKitchen = kitchenRepository.addNewKitchen("Some new kitchen");
        Integer gotId = newKitchen.getId();

        kitchenRepository.deleteKitchenById(gotId);
        assertNull(kitchenRepository.findKitchenById(gotId));

    }

    @Test
    @DirtiesContext
    public void changeNameOfExistingKitchenById (){

        //Old name of a kitchen with id=2: 'Kitchen'
        Kitchen kitchenById = kitchenRepository.findKitchenById(2);
        kitchenById.setKitchenName("New name of kitchen");

        assertEquals("New name of kitchen", kitchenById.getKitchenName());

    }

    @Test
    @DirtiesContext
    public void addNewKitchen (){

        Kitchen newKitchen = kitchenRepository.addNewKitchen("New kitchen");
        assertEquals("New kitchen", newKitchen.getKitchenName());

    }

}
