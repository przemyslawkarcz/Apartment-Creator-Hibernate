package com.example.apartment_creator.Repositories.Equipment;

import com.example.apartment_creator.Entities.Equipment.DecorativeAccessories;
import com.example.apartment_creator.Entities.Premises.BathRoom;
import com.example.apartment_creator.Entities.Premises.BedRoom;
import com.example.apartment_creator.Entities.Premises.Kitchen;
import com.example.apartment_creator.Entities.Premises.LivingRoom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Repository
@Transactional
public class DecorativeAccessoriesRepository {

    @Autowired
    EntityManager entityManager;

    public DecorativeAccessories findDecorativeAccessoriesById(Integer someId){

        return entityManager.find(DecorativeAccessories.class, someId);

    }

    public DecorativeAccessories addNewDecorativeAccessories(String someNewDecorativeAccessories){

        DecorativeAccessories newDecorativeAccessories = new DecorativeAccessories(someNewDecorativeAccessories);
        entityManager.persist(newDecorativeAccessories);
        return newDecorativeAccessories;

    }

    public void deleteDecorativeAccessoriesById(Integer someDecorativeAccessoriesId){

        DecorativeAccessories decorativeAccessoriesToDelete = findDecorativeAccessoriesById(someDecorativeAccessoriesId);
        entityManager.remove(decorativeAccessoriesToDelete);

    }

    public DecorativeAccessories changeNameOfExistingDecorativeAccessoriesById(Integer someExistingDecorativeAccessoriesItemId, String newDecorativeAccessoriesItemName){

        DecorativeAccessories existingDecorativeAccessoriesItemWithCertainId = findDecorativeAccessoriesById(someExistingDecorativeAccessoriesItemId);
        existingDecorativeAccessoriesItemWithCertainId.setDecorativeAccessoriesName(newDecorativeAccessoriesItemName);

        return entityManager.merge(existingDecorativeAccessoriesItemWithCertainId);
    }

    public LivingRoom findLivingRoomById(Integer someId){

        return entityManager.find(LivingRoom.class, someId);

    }

    public Kitchen findKitchenById(Integer someId){

        return entityManager.find(Kitchen.class, someId);

    }

    public BedRoom findBedRoomById(Integer someId){

        return entityManager.find(BedRoom.class, someId);

    }

    public BathRoom findBathRoomById(Integer someId){

        return entityManager.find(BathRoom.class, someId);

    }

    public void addNewDecorativeAccessoriesItemToLivingRoom(Integer livingRoomId, String decorativeAccessoriesItemName){

        DecorativeAccessories someNewDecorativeAccessoriesItem = new DecorativeAccessories(decorativeAccessoriesItemName);
        entityManager.persist(someNewDecorativeAccessoriesItem);

        LivingRoom existingLivingRoom = findLivingRoomById(livingRoomId);
        existingLivingRoom.setDecorativeAccessories(someNewDecorativeAccessoriesItem);
        someNewDecorativeAccessoriesItem.setLivingRoom(existingLivingRoom);

        entityManager.persist(someNewDecorativeAccessoriesItem);
    }

    public void addNewDecorativeAccessoriesItemToKitchen(Integer kitchenId, String decorativeAccessoriesItemName){

        DecorativeAccessories someNewDecorativeAccessoriesItem = new DecorativeAccessories(decorativeAccessoriesItemName);
        entityManager.persist(someNewDecorativeAccessoriesItem);

        Kitchen existingKitchen = findKitchenById(kitchenId);
        existingKitchen.setDecorativeAccessories(someNewDecorativeAccessoriesItem);
        someNewDecorativeAccessoriesItem.setKitchen(existingKitchen);
    }

    public void addNewDecorativeAccessoriesItemToBedRoom(Integer bedRoomId, String decorativeAccessoriesItemName){

        DecorativeAccessories someNewDecorativeAccessoriesItem = new DecorativeAccessories(decorativeAccessoriesItemName);
        entityManager.persist(someNewDecorativeAccessoriesItem);

        BedRoom existingBedRoom = findBedRoomById(bedRoomId);
        existingBedRoom.setDecorativeAccessories(someNewDecorativeAccessoriesItem);
        someNewDecorativeAccessoriesItem.setBedRoom(existingBedRoom);
    }

    public void addNewDecorativeAccessoriesItemToBathRoom(Integer bathRoomId, String decorativeAccessoriesItemName){

        DecorativeAccessories someNewDecorativeAccessoriesItem = new DecorativeAccessories(decorativeAccessoriesItemName);
        entityManager.persist(someNewDecorativeAccessoriesItem);

        BathRoom existingBathRoom = findBathRoomById(bathRoomId);
        existingBathRoom.setDecorativeAccessories(someNewDecorativeAccessoriesItem);
        someNewDecorativeAccessoriesItem.setBathRoom(existingBathRoom);
    }

}
