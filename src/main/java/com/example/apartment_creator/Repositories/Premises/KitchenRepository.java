package com.example.apartment_creator.Repositories.Premises;

import com.example.apartment_creator.Entities.Premises.Kitchen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Repository
@Transactional
public class KitchenRepository {

    @Autowired
    EntityManager entityManager;

    public Kitchen findKitchenById(Integer someKitchenId){

        return entityManager.find(Kitchen.class, someKitchenId);

    }

    public void deleteKitchenById(Integer someKitchenId){

        Kitchen kitchenToDelete = findKitchenById(someKitchenId);
        entityManager.remove(kitchenToDelete);

    }

    public Kitchen changeNameOfExistingKitchenById(Integer someExistingKitchenId, String newKitchenName){

        Kitchen existingKitchenWithCertainId = findKitchenById(someExistingKitchenId);
        existingKitchenWithCertainId.setKitchenName(newKitchenName);

        return entityManager.merge(existingKitchenWithCertainId);

    }

    public Kitchen addNewKitchen(String someKitchenName){

        Kitchen someNewKitchen = new Kitchen(someKitchenName);
        entityManager.persist(someNewKitchen);
        return someNewKitchen;

    }

}
