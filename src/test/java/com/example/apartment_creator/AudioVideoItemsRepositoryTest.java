package com.example.apartment_creator;

import com.example.apartment_creator.Entities.Equipment.AudioVideoItems;
import com.example.apartment_creator.Entities.Premises.BathRoom;
import com.example.apartment_creator.Entities.Premises.BedRoom;
import com.example.apartment_creator.Entities.Premises.Kitchen;
import com.example.apartment_creator.Entities.Premises.LivingRoom;
import com.example.apartment_creator.Repositories.Equipment.AudioVideoItemsRepository;
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
public class AudioVideoItemsRepositoryTest {

    @Autowired
    AudioVideoItemsRepository audioVideoItemsRepository;

    @Test
    public void findAudioVideoItemById(){

        AudioVideoItems audioVideoItemById = audioVideoItemsRepository.findAudioVideoItemById(19);
        assertEquals("Living room stereo system", audioVideoItemById.getAudioVideoItemName());

    }

    @Test
    @DirtiesContext
    public void addNewAudioVideoItem(){

        AudioVideoItems audioVideoItem = audioVideoItemsRepository.addNewAudioVideoItem("Some name");
        assertEquals("Some name", audioVideoItem.getAudioVideoItemName());

    }

    @Test
    @DirtiesContext
    public void deleteAudioVideoItemById(){

        AudioVideoItems audioVideoItem = audioVideoItemsRepository.addNewAudioVideoItem("Some new name");
        Integer gotId = audioVideoItem.getId();

        audioVideoItemsRepository.deleteAudioVideoItemById(gotId);
        assertNull(audioVideoItemsRepository.findAudioVideoItemById(gotId));
    }

    @Test
    @DirtiesContext
    public void changeNameOfExistingAudioVideoItemById(){

        //Old name of an item with id=19: 'Living room stereo system'
        AudioVideoItems audioVideoItemById = audioVideoItemsRepository.findAudioVideoItemById(19);
        audioVideoItemById.setAudioVideoItemName("New name");
        assertEquals("New name", audioVideoItemById.getAudioVideoItemName());

    }

    @Test
    @DirtiesContext
    public void findLivingRoomById(){

        LivingRoom livingRoomById = audioVideoItemsRepository.findLivingRoomById(1);
        assertEquals("Living room", livingRoomById.getRoomName());

    }

    @Test
    @DirtiesContext
    public void findKitchenById(){

        Kitchen kitchenById = audioVideoItemsRepository.findKitchenById(2);
        assertEquals("Kitchen", kitchenById.getKitchenName());

    }

    @Test
    @DirtiesContext
    public void findBedRoomById(){

        BedRoom bedRoomById = audioVideoItemsRepository.findBedRoomById(5);
        assertEquals("Bedroom: 3", bedRoomById.getBedRoomName());

    }

    @Test
    @DirtiesContext
    public void findBathRoomById(){

        BathRoom bathRoomById = audioVideoItemsRepository.findBathRoomById(6);
        assertEquals("Bathroom", bathRoomById.getBathRoomName());

    }

    @Test
    @DirtiesContext
    public void addNewAudioVideoItemToLivingRoom(){

        audioVideoItemsRepository.addNewAudioVideoItemToLivingRoom(1, "New AV item in living room");

        LivingRoom livingRoomById = audioVideoItemsRepository.findLivingRoomById(1);
        String audioVideoItemName = livingRoomById.getAudioVideoItems().getAudioVideoItemName();

        assertEquals("New AV item in living room", audioVideoItemName);

    }

    @Test
    @DirtiesContext
    public void addNewAudioVideoItemToKitchen(){

        audioVideoItemsRepository.addNewAudioVideoItemToKitchen(2, "New AV item in kitchen");

        Kitchen kitchenById = audioVideoItemsRepository.findKitchenById(2);
        String audioVideoItemName = kitchenById.getAudioVideoItems().getAudioVideoItemName();

        assertEquals("New AV item in kitchen", audioVideoItemName);

    }

    @Test
    @DirtiesContext
    public void addNewAudioVideoItemToBedRoom(){

        audioVideoItemsRepository.addNewAudioVideoItemToBedRoom(4, "New AV item in bedroom");

        BedRoom bedRoomById = audioVideoItemsRepository.findBedRoomById(4);
        String audioVideoItemName = bedRoomById.getAudioVideoItems().getAudioVideoItemName();

        assertEquals("New AV item in bedroom", audioVideoItemName);

    }

    @Test
    @DirtiesContext
    public void addNewAudioVideoItemToBathRoom(){

        audioVideoItemsRepository.addNewAudioVideoItemToBathRoom(6, "New AV item in bathroom");

        BathRoom bathRoomById = audioVideoItemsRepository.findBathRoomById(6);
        String audioVideoItemName = bathRoomById.getAudioVideoItems().getAudioVideoItemName();

        assertEquals("New AV item in bathroom", audioVideoItemName);

    }

}


