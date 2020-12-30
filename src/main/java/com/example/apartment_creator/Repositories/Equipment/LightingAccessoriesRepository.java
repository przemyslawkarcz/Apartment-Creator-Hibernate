package com.example.apartment_creator.Repositories.Equipment;

import com.example.apartment_creator.Entities.Equipment.LightingAccessories;
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
public class LightingAccessoriesRepository {

    @Autowired
    EntityManager entityManager;

    public LightingAccessories findLightingAccessoryById(Integer someId){

        return entityManager.find(LightingAccessories.class, someId);

    }

    public LightingAccessories addNewLightingAccessory(String someNewLightingAccessory){

        LightingAccessories newLightingAccessory = new LightingAccessories(someNewLightingAccessory);
        entityManager.persist(newLightingAccessory);

        return newLightingAccessory;
    }

    public void deleteLightingAccessoryById(Integer someLightingAccessoryId){

        LightingAccessories lightingAccessoryToDelete = findLightingAccessoryById(someLightingAccessoryId);
        entityManager.remove(lightingAccessoryToDelete);

    }

    public LightingAccessories changeNameOfExistingLightingAccessoryById(Integer someExistingLightingAccessoryId, String newLightingAccessoryName){

        LightingAccessories existingLightingAccessoryWithCertianId = findLightingAccessoryById(someExistingLightingAccessoryId);
        existingLightingAccessoryWithCertianId.setLightingAccessoryName(newLightingAccessoryName);

        return entityManager.merge(existingLightingAccessoryWithCertianId);

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

    public void addNewLightingAccessoryToLivingRoom(Integer livingRoomId, String lightingAccessoryName){

        LightingAccessories someNewLightingAccessories = new LightingAccessories(lightingAccessoryName);
        entityManager.persist(someNewLightingAccessories);

        LivingRoom existinglivingRoom = findLivingRoomById(livingRoomId);
        existinglivingRoom.setLightingAccessories(someNewLightingAccessories);
        someNewLightingAccessories.setLivingRoom(existinglivingRoom);

    }

    public void addNewLightingAccessoryToKitchen(Integer kitchenId, String lightingAccessoryName){

        LightingAccessories someNewLightingAccessories = new LightingAccessories(lightingAccessoryName);
        entityManager.persist(someNewLightingAccessories);

        Kitchen existingKitchen = findKitchenById(kitchenId);
        existingKitchen.setLightingAccessories(someNewLightingAccessories);
        someNewLightingAccessories.setKitchen(existingKitchen);

    }

    public void addNewLightingAccessoryToBedRoom(Integer bedRoomId, String lightingAccessoryName){

        LightingAccessories someNewLightingAccessory = new LightingAccessories(lightingAccessoryName);
        entityManager.persist(someNewLightingAccessory);

        BedRoom existingBedRoom = findBedRoomById(bedRoomId);
        existingBedRoom.setLightingAccessories(someNewLightingAccessory);
        someNewLightingAccessory.setBedRoom(existingBedRoom);

    }

    public void addNewLightingAccessoryToBathRoom(Integer bathRoomId, String lightingAccessoryName){

        LightingAccessories someNewLightingAccessories = new LightingAccessories(lightingAccessoryName);
        entityManager.persist(someNewLightingAccessories);

        BathRoom existingBathRoom = findBathRoomById(bathRoomId);
        existingBathRoom.setLightingAccessories(someNewLightingAccessories);
        someNewLightingAccessories.setBathRoom(existingBathRoom);

    }

}
