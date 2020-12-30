package com.example.apartment_creator;

import com.example.apartment_creator.Entities.Equipment.Furniture;
import com.example.apartment_creator.Entities.Premises.BathRoom;
import com.example.apartment_creator.Entities.Premises.BedRoom;
import com.example.apartment_creator.Entities.Premises.Kitchen;
import com.example.apartment_creator.Entities.Premises.LivingRoom;
import com.example.apartment_creator.Repositories.Equipment.FurnitureRepository;
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
public class FurnitureRepositoryTest {

    @Autowired
    FurnitureRepository furnitureRepository;

    @Test
    public void findFurnitureById (){

        Furniture furnitureById = furnitureRepository.findFurnitureById(7);
        assertEquals("TV panel", furnitureById.getFurnitureName());

    }

    @Test
    @DirtiesContext
    public void addNewFurniture (){

        Furniture furniture = furnitureRepository.addNewFurniture("Some name");
        assertEquals("Some name", furniture.getFurnitureName());

    }

    @Test
    @DirtiesContext
    public void deleteFurnitureById (){

        Furniture furniture = furnitureRepository.addNewFurniture("Some new name");
        Integer gotId = furniture.getId();

        furnitureRepository.deleteFurnitureById(gotId);
        assertNull(furnitureRepository.findFurnitureById(gotId));

    }

    @Test
    @DirtiesContext
    public void changeNameOfExistingFurnitureById (){

        //Old name of an item with id=7: 'TV panel'
        Furniture furnitureById = furnitureRepository.findFurnitureById(7);
        furnitureById.setFurnitureName("New name");
        assertEquals("New name", furnitureById.getFurnitureName());

    }

    @Test
    @DirtiesContext
    public void findLivingRoomById (){

        LivingRoom livingRoomById = furnitureRepository.findLivingRoomById(1);
        assertEquals("Living room", livingRoomById.getRoomName());

    }

    @Test
    @DirtiesContext
    public void findKitchenById (){

        Kitchen kitchenById = furnitureRepository.findKitchenById(2);
        assertEquals("Kitchen", kitchenById.getKitchenName());

    }

    @Test
    @DirtiesContext
    public void findBedRoomById (){

        BedRoom bedRoomById = furnitureRepository.findBedRoomById(3);
        assertEquals("Bedroom: 1", bedRoomById.getBedRoomName());

    }

    @Test
    @DirtiesContext
    public void findBathRoomById (){

        BathRoom bathRoomById = furnitureRepository.findBathRoomById(6);
        assertEquals("Bathroom", bathRoomById.getBathRoomName());

    }

    @Test
    @DirtiesContext
    public void addNewFurnitureToLivingRoom (){

        furnitureRepository.addNewFurnitureToLivingRoom(1, "New furniture in living room");

        LivingRoom livingRoomById = furnitureRepository.findLivingRoomById(1);
        String furnitureName = livingRoomById.getFurniture().getFurnitureName();

        assertEquals("New furniture in living room", furnitureName);

    }

    @Test
    @DirtiesContext
    public void addNewFurnitureToKitchen (){

        furnitureRepository.addNewFurnitureToKitchen(2, "New furniture in kitchen");

        Kitchen kitchenById = furnitureRepository.findKitchenById(2);
        String furnitureName = kitchenById.getFurniture().getFurnitureName();

        assertEquals("New furniture in kitchen", furnitureName);

    }

    @Test
    @DirtiesContext
    public void addNewFurnitureToBedRoom (){

        furnitureRepository.addNewFurnitureToBedRoom(3, "New furniture in bedroom");

        BedRoom bedRoomById = furnitureRepository.findBedRoomById(3);
        String furnitureName = bedRoomById.getFurniture().getFurnitureName();

        assertEquals("New furniture in bedroom", furnitureName);

    }

    @Test
    @DirtiesContext
    public void addNewFurnitureToBathRoom (){

        furnitureRepository.addNewFurnitureToBathRoom(6, "New furniture in bathroom");

        BathRoom bathRoomById = furnitureRepository.findBathRoomById(6);
        String furnitureName = bathRoomById.getFurniture().getFurnitureName();

        assertEquals("New furniture in bathroom", furnitureName);

    }

}
