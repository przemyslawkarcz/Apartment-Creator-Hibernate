package com.example.apartment_creator.Repositories.Equipment;

import com.example.apartment_creator.Entities.Equipment.AudioVideoItems;
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
public class AudioVideoItemsRepository {

    @Autowired
    EntityManager entityManager;

    public AudioVideoItems findAudioVideoItemById(Integer someId){

        return entityManager.find(AudioVideoItems.class, someId);

    }

    public AudioVideoItems addNewAudioVideoItem(String someNewAudioVideoItem){

        AudioVideoItems newAudioVideoItem = new AudioVideoItems(someNewAudioVideoItem);
        entityManager.persist(newAudioVideoItem);
        return newAudioVideoItem;
    }

    public void deleteAudioVideoItemById(Integer someAudioVideoItemId){

        AudioVideoItems audioVideoToDelete = findAudioVideoItemById(someAudioVideoItemId);
        entityManager.remove(audioVideoToDelete);

    }

    public AudioVideoItems changeNameOfExistingAudioVideoItemById(Integer someExistingAudioVideoItemId, String newAudioVideoItemName){

        AudioVideoItems existingAudioVideoItemWithCertainId = findAudioVideoItemById(someExistingAudioVideoItemId);
        existingAudioVideoItemWithCertainId.setAudioVideoItemName(newAudioVideoItemName);

        return entityManager.merge(existingAudioVideoItemWithCertainId);
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

    public void addNewAudioVideoItemToLivingRoom(Integer livingRoomId, String audioVideoItemName){

        AudioVideoItems someNewAudioVideoItem = new AudioVideoItems(audioVideoItemName);
        entityManager.persist(someNewAudioVideoItem);

        LivingRoom existingLivingRoom = findLivingRoomById(livingRoomId);
        existingLivingRoom.setAudioVideoItems(someNewAudioVideoItem);
        someNewAudioVideoItem.setLivingRoom(existingLivingRoom);
    }

    public void addNewAudioVideoItemToKitchen(Integer kitchenId, String audioVideoItemName){

        AudioVideoItems someNewAudioVideoItem = new AudioVideoItems(audioVideoItemName);
        entityManager.persist(someNewAudioVideoItem);

        Kitchen existingKitchen = findKitchenById(kitchenId);
        existingKitchen.setAudioVideoItems(someNewAudioVideoItem);
        someNewAudioVideoItem.setKitchen(existingKitchen);
    }

    public void addNewAudioVideoItemToBedRoom(Integer bedRoomId, String audioVideoItemName){

        AudioVideoItems someNewAudioVideoItem = new AudioVideoItems(audioVideoItemName);
        entityManager.persist(someNewAudioVideoItem);

        BedRoom existingBedRoom = findBedRoomById(bedRoomId);
        existingBedRoom.setAudioVideoItems(someNewAudioVideoItem);
        someNewAudioVideoItem.setBedRoom(existingBedRoom);
    }

    public void addNewAudioVideoItemToBathRoom(Integer bathRoomId, String audioVideoItemName){

        AudioVideoItems someNewAudioVideoItem = new AudioVideoItems(audioVideoItemName);
        entityManager.persist(someNewAudioVideoItem);

        BathRoom existingBathRoom = findBathRoomById(bathRoomId);
        existingBathRoom.setAudioVideoItems(someNewAudioVideoItem);
        someNewAudioVideoItem.setBathRoom(existingBathRoom);
    }

}
