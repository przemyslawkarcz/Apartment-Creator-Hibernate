package com.example.apartment_creator.Repositories.Premises;

import com.example.apartment_creator.Entities.Premises.BedRoom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Repository
@Transactional
public class BedRoomRepository {

    @Autowired
    EntityManager entityManager;

    public BedRoom findBedRoomById(Integer someBedRoomId){

        return entityManager.find(BedRoom.class, someBedRoomId);

    }

    public void deleteBedRoomById(Integer someBedRoomId){

        BedRoom bedRoomToDelete = findBedRoomById(someBedRoomId);
        entityManager.remove(bedRoomToDelete);

    }

    public BedRoom changeNameOfExistingBedRoomById(Integer someExistingBedRoomId, String newBedRoomName){

        BedRoom existingBedRoomWithCertainId = findBedRoomById(someExistingBedRoomId);
        existingBedRoomWithCertainId.setBedRoomName(newBedRoomName);

        return entityManager.merge(existingBedRoomWithCertainId);

    }

    public BedRoom addNewBedRoom (String someBedRoomName){

        BedRoom newBedRoom = new BedRoom(someBedRoomName);
        entityManager.persist(newBedRoom);
        return newBedRoom;

    }

    public void addSpecificNumberOfBedrooms (String someBedRoomName, Integer numberOfBedRooms){

        for (int i = 0; i < numberOfBedRooms; i++) {

            addNewBedRoom(someBedRoomName + ": " + (i + 1));

        }

    }

}
