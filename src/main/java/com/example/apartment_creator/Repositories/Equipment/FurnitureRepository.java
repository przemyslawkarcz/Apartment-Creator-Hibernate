package com.example.apartment_creator.Repositories.Equipment;

import com.example.apartment_creator.Entities.Premises.*;
import com.example.apartment_creator.Entities.Equipment.Furniture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Repository
@Transactional
public class FurnitureRepository {

    @Autowired
    EntityManager entityManager;

    public Furniture findFurnitureById(Integer someId){

        return entityManager.find(Furniture.class, someId);

    }

    public Furniture addNewFurniture(String someNewFurniture){

        Furniture newFurniture = new Furniture(someNewFurniture);
        entityManager.persist(newFurniture);

        return newFurniture;
    }

    public void deleteFurnitureById(Integer someFurnitureId){

        Furniture furnitureToDelete = findFurnitureById(someFurnitureId);
        entityManager.remove(furnitureToDelete);

    }

    public Furniture changeNameOfExistingFurnitureById(Integer someExistingFurnitureId, String newFurnitureName){

        Furniture existingFurnitureWithCertainId = findFurnitureById(someExistingFurnitureId);
        existingFurnitureWithCertainId.setFurnitureName(newFurnitureName);

        return entityManager.merge(existingFurnitureWithCertainId);
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

    public void addNewFurnitureToLivingRoom(Integer livingRoomId, String furnitureName){

        Furniture someNewFurniture = new Furniture(furnitureName);
        entityManager.persist(someNewFurniture);

        LivingRoom existingLivingRoom = findLivingRoomById(livingRoomId);
        existingLivingRoom.setFurniture(someNewFurniture);
        someNewFurniture.setLivingRoom(existingLivingRoom);

    }

    public void addNewFurnitureToKitchen(Integer kitchenId, String furnitureName){

        Furniture someNewFurniture = new Furniture(furnitureName);
        entityManager.persist(someNewFurniture);

        Kitchen existingKitchen = findKitchenById(kitchenId);
        existingKitchen.setFurniture(someNewFurniture);
        someNewFurniture.setKitchen(existingKitchen);

    }

    public void addNewFurnitureToBedRoom(Integer bedRoomId, String furnitureName){

        Furniture someNewFurniture = new Furniture(furnitureName);
        entityManager.persist(someNewFurniture);

        BedRoom existingBedRoom = findBedRoomById(bedRoomId);
        existingBedRoom.setFurniture(someNewFurniture);
        someNewFurniture.setBedRoom(existingBedRoom);
    }

    public void addNewFurnitureToBathRoom(Integer bathRoomId, String furnitureName){

        Furniture someNewFurniture = new Furniture(furnitureName);
        entityManager.persist(someNewFurniture);

        BathRoom existingBathRoom = findBathRoomById(bathRoomId);
        existingBathRoom.setFurniture(someNewFurniture);
        someNewFurniture.setBathRoom(existingBathRoom);

    }

}
