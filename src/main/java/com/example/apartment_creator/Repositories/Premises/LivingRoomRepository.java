package com.example.apartment_creator.Repositories.Premises;

import com.example.apartment_creator.Entities.Premises.LivingRoom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Repository
@Transactional
public class LivingRoomRepository {

    @Autowired
    EntityManager entityManager;

    public LivingRoom findLivingRoomById(Integer someLivingRoomId){

        return entityManager.find(LivingRoom.class, someLivingRoomId);

    }

    public void deleteLivingRoomById(Integer someLivingRoomId){

        LivingRoom livingRoomToDelete = findLivingRoomById(someLivingRoomId);
        entityManager.remove(livingRoomToDelete);

    }

    public LivingRoom changeNameOfExistingLivingRoomById(Integer someExistingLivingRoomId, String newLivingRoomName){

        LivingRoom existingLivingRoomWithCertainId = findLivingRoomById(someExistingLivingRoomId);
        existingLivingRoomWithCertainId.setRoomName(newLivingRoomName);

        return entityManager.merge(existingLivingRoomWithCertainId);

    }

    public LivingRoom addNewLivingRoom(String someLivingRoomName){

        LivingRoom someNewLivingRoom = new LivingRoom(someLivingRoomName);
        entityManager.persist(someNewLivingRoom);
        return someNewLivingRoom;

    }

}
