package com.example.apartment_creator;

import com.example.apartment_creator.Entities.Premises.LivingRoom;
import com.example.apartment_creator.Repositories.Premises.LivingRoomRepository;
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
public class LivingRoomRepositoryTest {

    @Autowired
    LivingRoomRepository livingRoomRepository;

    @Test
    public void findLivingRoomById (){

        LivingRoom livingRoomById = livingRoomRepository.findLivingRoomById(1);
        assertEquals("Living room", livingRoomById.getRoomName());

    }

    @Test
    @DirtiesContext
    public void deleteLivingRoomById (){

        LivingRoom newLivingRoom = livingRoomRepository.addNewLivingRoom("Some new living room");
        Integer gotId = newLivingRoom.getId();

        livingRoomRepository.deleteLivingRoomById(gotId);
        assertNull(livingRoomRepository.findLivingRoomById(gotId));

    }

    @Test
    @DirtiesContext
    public void changeNameOfExistingLivingRoomById (){

        //Old name of a living room with id=1: 'Living room'
        LivingRoom livingRoomById = livingRoomRepository.findLivingRoomById(1);
        livingRoomById.setRoomName("New name of living room");

        assertEquals("New name of living room", livingRoomById.getRoomName());

    }

    @Test
    @DirtiesContext
    public void addNewLivingRoom (){

        LivingRoom newLivingRoom = livingRoomRepository.addNewLivingRoom("New living room");
        assertEquals("New living room", newLivingRoom.getRoomName());

    }

}
