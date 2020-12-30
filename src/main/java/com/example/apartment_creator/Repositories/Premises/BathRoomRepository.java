package com.example.apartment_creator.Repositories.Premises;

import com.example.apartment_creator.Entities.Premises.BathRoom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Repository
@Transactional
public class BathRoomRepository {

    @Autowired
    EntityManager entityManager;

    public BathRoom findBathRoomById(Integer someBathRoomId){

        return entityManager.find(BathRoom.class, someBathRoomId);

    }

    public void deleteBathRoomById(Integer someBathRoomId){

        BathRoom bathRoomToDelete = findBathRoomById(someBathRoomId);
        entityManager.remove(bathRoomToDelete);

    }

    public BathRoom changeNameOfExistingBathRoomById(Integer someExistingBathRoomId, String newBathRoomName){

        BathRoom existingBathRoomWithCertainId = findBathRoomById(someExistingBathRoomId);
        existingBathRoomWithCertainId.setBathRoomName(newBathRoomName);

        return entityManager.merge(existingBathRoomWithCertainId);

    }

    public BathRoom addNewBathRoom(String someBathRoomName){

        BathRoom newBathRoom = new BathRoom(someBathRoomName);
        entityManager.persist(newBathRoom);
        return newBathRoom;

    }

}
