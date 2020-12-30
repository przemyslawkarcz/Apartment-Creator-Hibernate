package com.example.apartment_creator;

import com.example.apartment_creator.Entities.Equipment.LightingAccessories;
import com.example.apartment_creator.Entities.Premises.BathRoom;
import com.example.apartment_creator.Entities.Premises.BedRoom;
import com.example.apartment_creator.Entities.Premises.Kitchen;
import com.example.apartment_creator.Entities.Premises.LivingRoom;
import com.example.apartment_creator.Repositories.Equipment.LightingAccessoriesRepository;
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
public class LightingAccessoriesRepositoryTest {

    @Autowired
    LightingAccessoriesRepository lightingAccessoriesRepository;

    @Test
    public void findLightingAccessoryById (){

        LightingAccessories lightingAccessoryById = lightingAccessoriesRepository.findLightingAccessoryById(18);
        assertEquals("Ceiling lighting and wall lamps", lightingAccessoryById.getLightingAccessoryName());

    }

    @Test
    @DirtiesContext
    public void addNewLightingAccessory (){

        LightingAccessories lightingAccessories = lightingAccessoriesRepository.addNewLightingAccessory("Some name");
        assertEquals("Some name", lightingAccessories.getLightingAccessoryName());

    }

    @Test
    @DirtiesContext
    public void deleteLightingAccessoryById (){

        LightingAccessories lightingAccessories = lightingAccessoriesRepository.addNewLightingAccessory("Some new name");
        Integer gotId = lightingAccessories.getId();

        lightingAccessoriesRepository.deleteLightingAccessoryById(gotId);
        assertNull(lightingAccessoriesRepository.findLightingAccessoryById(gotId));

    }

    @Test
    @DirtiesContext
    public void changeNameOfExistingLightingAccessoryById (){

        //Old name of an item with id=18: 'Ceiling lighting and wall lamps'
        LightingAccessories lightingAccessoryById = lightingAccessoriesRepository.findLightingAccessoryById(18);
        lightingAccessoryById.setLightingAccessoryName("New name");
        assertEquals("New name", lightingAccessoryById.getLightingAccessoryName());

    }

    @Test
    @DirtiesContext
    public void findLivingRoomById (){

        LivingRoom livingRoomById = lightingAccessoriesRepository.findLivingRoomById(1);
        assertEquals("Living room", livingRoomById.getRoomName());

    }

    @Test
    @DirtiesContext
    public void findKitchenById (){

        Kitchen kitchenById = lightingAccessoriesRepository.findKitchenById(2);
        assertEquals("Kitchen", kitchenById.getKitchenName());

    }

    @Test
    @DirtiesContext
    public void findBedRoomById (){

        BedRoom bedRoomById = lightingAccessoriesRepository.findBedRoomById(3);
        assertEquals("Bedroom: 1", bedRoomById.getBedRoomName());

    }

    @Test
    @DirtiesContext
    public void findBathRoomById (){

        BathRoom bathRoomById = lightingAccessoriesRepository.findBathRoomById(6);
        assertEquals("Bathroom", bathRoomById.getBathRoomName());

    }

    @Test
    @DirtiesContext
    public void addNewLightingAccessoryToLivingRoom (){

        lightingAccessoriesRepository.addNewLightingAccessoryToLivingRoom(1, "New lighting item in living room");

        LivingRoom livingRoomById = lightingAccessoriesRepository.findLivingRoomById(1);
        String lightingAccessoryName = livingRoomById.getLightingAccessories().getLightingAccessoryName();

        assertEquals("New lighting item in living room", lightingAccessoryName);

    }

    @Test
    @DirtiesContext
    public void addNewLightingAccessoryToKitchen (){

        lightingAccessoriesRepository.addNewLightingAccessoryToKitchen(2, "New lighting item in kitchen");

        Kitchen kitchenById = lightingAccessoriesRepository.findKitchenById(2);
        String lightingAccessoryName = kitchenById.getLightingAccessories().getLightingAccessoryName();

        assertEquals("New lighting item in kitchen", lightingAccessoryName);

    }

    @Test
    @DirtiesContext
    public void addNewLightingAccessoryToBedRoom (){

        lightingAccessoriesRepository.addNewLightingAccessoryToBedRoom(5, "New lighting item in bedroom");

        BedRoom bedRoomById = lightingAccessoriesRepository.findBedRoomById(5);
        String lightingAccessoryName = bedRoomById.getLightingAccessories().getLightingAccessoryName();

        assertEquals("New lighting item in bedroom", lightingAccessoryName);

    }

    @Test
    @DirtiesContext
    public void addNewLightingAccessoryToBathRoom (){

        lightingAccessoriesRepository.addNewLightingAccessoryToBathRoom(6, "New lighting item in bathroom");

        BathRoom bathRoomById = lightingAccessoriesRepository.findBathRoomById(6);
        String lightingAccessoryName = bathRoomById.getLightingAccessories().getLightingAccessoryName();

        assertEquals("New lighting item in bathroom", lightingAccessoryName);

    }

}
