package com.example.apartment_creator;

import com.example.apartment_creator.Entities.Premises.BedRoom;
import com.example.apartment_creator.Repositories.Premises.BedRoomRepository;
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
public class BedRoomRepositoryTest {

    @Autowired
    BedRoomRepository bedRoomRepository;

    @Test
    public void findBedRoomById (){

        BedRoom bedRoomById = bedRoomRepository.findBedRoomById(4);
        assertEquals("Bedroom: 2", bedRoomById.getBedRoomName());

    }

    @Test
    @DirtiesContext
    public void deleteBedRoomById (){

        BedRoom newBedRoom = bedRoomRepository.addNewBedRoom("Some new bedroom");
        Integer gotId = newBedRoom.getId();

        bedRoomRepository.deleteBedRoomById(gotId);
        assertNull(bedRoomRepository.findBedRoomById(gotId));

    }

    @Test
    @DirtiesContext
    public void changeNameOfExistingBedRoomById (){

        //Old name of a bedroom with id=4: 'Bedroom: 2'
        BedRoom bedRoomById = bedRoomRepository.findBedRoomById(4);
        bedRoomById.setBedRoomName("New name of bedroom");

        assertEquals("New name of bedroom", bedRoomById.getBedRoomName());

    }

    @Test
    @DirtiesContext
    public void addNewBedRoom (){

        BedRoom newBedRoom = bedRoomRepository.addNewBedRoom("New bedroom");
        assertEquals("New bedroom", newBedRoom.getBedRoomName());

    }

    @Test
    @DirtiesContext
    public void addSpecificNumberOfBedrooms (){

        bedRoomRepository.addSpecificNumberOfBedrooms("New names", 3);

        BedRoom bedRoomById30 = bedRoomRepository.findBedRoomById(30);
        BedRoom bedRoomById31 = bedRoomRepository.findBedRoomById(31);
        BedRoom bedRoomById32 = bedRoomRepository.findBedRoomById(32);

        assertEquals("New names: 1", bedRoomById30.getBedRoomName());
        assertEquals("New names: 2", bedRoomById31.getBedRoomName());
        assertEquals("New names: 3", bedRoomById32.getBedRoomName());

    }

}
