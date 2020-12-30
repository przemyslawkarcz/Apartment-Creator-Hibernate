package com.example.apartment_creator;

import com.example.apartment_creator.Entities.Equipment.DecorativeAccessories;
import com.example.apartment_creator.Entities.Premises.BathRoom;
import com.example.apartment_creator.Entities.Premises.BedRoom;
import com.example.apartment_creator.Entities.Premises.Kitchen;
import com.example.apartment_creator.Entities.Premises.LivingRoom;
import com.example.apartment_creator.Repositories.Equipment.DecorativeAccessoriesRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.List;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApartmentCreatorApplication.class)
public class DecorativeAccessoriesRepositoryTest {

    @Autowired
    DecorativeAccessoriesRepository decorativeAccessoriesRepository;

    @Test
    public void findDecorativeAccessoriesById(){

        DecorativeAccessories decorativeAccessoriesById = decorativeAccessoriesRepository.findDecorativeAccessoriesById(25);
        assertEquals("Barbados landscape photo no.1", decorativeAccessoriesById.getDecorativeAccessoriesName());

    }

    @Test
    @DirtiesContext
    public void addNewDecorativeAccessories(){

        DecorativeAccessories decorativeAccessories = decorativeAccessoriesRepository.addNewDecorativeAccessories("Some name");
        assertEquals("Some name", decorativeAccessories.getDecorativeAccessoriesName());

    }

    @Test
    @DirtiesContext
    public void deleteDecorativeAccessoriesById(){


        DecorativeAccessories decorativeAccessories = decorativeAccessoriesRepository.addNewDecorativeAccessories("Some new name");
        Integer gotId = decorativeAccessories.getId();

        decorativeAccessoriesRepository.deleteDecorativeAccessoriesById(gotId);
        assertNull(decorativeAccessoriesRepository.findDecorativeAccessoriesById(gotId));

    }

    @Test
    @DirtiesContext
    public void changeNameOfExistingDecorativeAccessoriesById(){

        //Old name of an item with id=28: 'Abu Dhabi picture'
        DecorativeAccessories decorativeAccessoriesById = decorativeAccessoriesRepository.findDecorativeAccessoriesById(28);
        decorativeAccessoriesById.setDecorativeAccessoriesName("New name");
        assertEquals("New name", decorativeAccessoriesById.getDecorativeAccessoriesName());

    }

    @Test
    @DirtiesContext
    public void findLivingRoomById(){

        LivingRoom livingRoomById = decorativeAccessoriesRepository.findLivingRoomById(1);
        assertEquals("Living room", livingRoomById.getRoomName());

    }

    @Test
    @DirtiesContext
    public void findKitchenById(){

        Kitchen kitchenById = decorativeAccessoriesRepository.findKitchenById(2);
        assertEquals("Kitchen", kitchenById.getKitchenName());

    }

    @Test
    @DirtiesContext
    public void findBedRoomById(){

        BedRoom bedRoomById = decorativeAccessoriesRepository.findBedRoomById(5);
        assertEquals("Bedroom: 3", bedRoomById.getBedRoomName());

    }

    @Test
    @DirtiesContext
    public void findBathRoomById(){

        BathRoom bathRoomById = decorativeAccessoriesRepository.findBathRoomById(6);
        assertEquals("Bathroom", bathRoomById.getBathRoomName());

    }

    @Test
    @DirtiesContext
    public void addNewDecorativeAccessoriesItemToLivingRoom() {

        decorativeAccessoriesRepository.addNewDecorativeAccessoriesItemToLivingRoom(1, "New deco item in living room");

        LivingRoom livingRoomById = decorativeAccessoriesRepository.findLivingRoomById(1);
        List<DecorativeAccessories> decorativeAccessories = livingRoomById.getDecorativeAccessories();

        for (DecorativeAccessories next : decorativeAccessories){

            System.out.print("ID: " + next.getId() + ", Name: "+ next.getDecorativeAccessoriesName() + " | ");

            assertEquals("New deco item in living room", next.getLivingRoom().getDecorativeAccessories().get(1).getDecorativeAccessoriesName());
        }

    }

    @Test
    @DirtiesContext
    public void addNewDecorativeAccessoriesItemToKitchen(){

        decorativeAccessoriesRepository.addNewDecorativeAccessoriesItemToKitchen(2, "New deco item in kitchen");

        Kitchen kitchenById = decorativeAccessoriesRepository.findKitchenById(2);
        List<DecorativeAccessories> decorativeAccessories = kitchenById.getDecorativeAccessories();

        for (DecorativeAccessories next: decorativeAccessories){

            System.out.println("ID: " + next.getId() + ", Name: " + next.getDecorativeAccessoriesName());

            assertEquals("New deco item in kitchen", next.getKitchen().getDecorativeAccessories().get(1).getDecorativeAccessoriesName());

        }

    }

    @Test
    @DirtiesContext
    public void addNewDecorativeAccessoriesItemToBedRoom(){

        decorativeAccessoriesRepository.addNewDecorativeAccessoriesItemToBedRoom(4, "New deco item in bedroom");

        BedRoom bedRoomById = decorativeAccessoriesRepository.findBedRoomById(4);
        List<DecorativeAccessories> decorativeAccessories = bedRoomById.getDecorativeAccessories();

        for (DecorativeAccessories next : decorativeAccessories){

            System.out.println("ID: " + next.getId() + ", Name: " + next.getDecorativeAccessoriesName());

            assertEquals("New deco item in bedroom", next.getBedRoom().getDecorativeAccessories().get(1).getDecorativeAccessoriesName());

        }

    }

    @Test
    @DirtiesContext
    public void addNewDecorativeAccessoriesItemToBathRoom(){

        decorativeAccessoriesRepository.addNewDecorativeAccessoriesItemToBathRoom(6, "New deco item in bathroom");

        BathRoom bathRoomById = decorativeAccessoriesRepository.findBathRoomById(6);
        List<DecorativeAccessories> decorativeAccessories = bathRoomById.getDecorativeAccessories();

        for (DecorativeAccessories next : decorativeAccessories){

            System.out.println("ID: " + next.getId() + ", Name: " + next.getDecorativeAccessoriesName());

            assertEquals("New deco item in bathroom", next.getBathRoom().getDecorativeAccessories().get(2).getDecorativeAccessoriesName());
        }

    }

}
