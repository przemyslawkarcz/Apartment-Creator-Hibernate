package com.example.apartment_creator;

import com.example.apartment_creator.Entities.Premises.BathRoom;
import com.example.apartment_creator.Repositories.Premises.BathRoomRepository;
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
public class BathRoomRepositoryTest {

    @Autowired
    BathRoomRepository bathRoomRepository;

    @Test
    public void findBathRoomById (){

        BathRoom bathRoomById = bathRoomRepository.findBathRoomById(6);
        assertEquals("Bathroom", bathRoomById.getBathRoomName());

    }

    @Test
    @DirtiesContext
    public void deleteBathRoomById (){

        BathRoom newBathRoom = bathRoomRepository.addNewBathRoom("Some new bathroom");
        Integer gotId = newBathRoom.getId();

        bathRoomRepository.deleteBathRoomById(gotId);
        assertNull(bathRoomRepository.findBathRoomById(gotId));

    }

    @Test
    @DirtiesContext
    public void changeNameOfExistingBathRoomById (){

        //Old name of a bathroom with id=6: 'Bathroom'
        BathRoom bathRoomById = bathRoomRepository.findBathRoomById(6);
        bathRoomById.setBathRoomName("New name of bathroom");

        assertEquals("New name of bathroom", bathRoomById.getBathRoomName());

    }

    @Test
    @DirtiesContext
    public void addNewBathRoom (){

        BathRoom newBathRoom = bathRoomRepository.addNewBathRoom("New bathroom");
        assertEquals("New bathroom", newBathRoom.getBathRoomName());

    }

}
