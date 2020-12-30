package com.example.apartment_creator;

import com.example.apartment_creator.Repositories.Equipment.AudioVideoItemsRepository;
import com.example.apartment_creator.Repositories.Equipment.DecorativeAccessoriesRepository;
import com.example.apartment_creator.Repositories.Equipment.FurnitureRepository;
import com.example.apartment_creator.Repositories.Equipment.LightingAccessoriesRepository;
import com.example.apartment_creator.Repositories.Premises.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApartmentCreatorApplication implements CommandLineRunner {

    public static void main(String[] args) {

        SpringApplication.run(ApartmentCreatorApplication.class, args);

    }

    //premises
    @Autowired
    LivingRoomRepository livingRoomRepository;

    @Autowired
    KitchenRepository kitchenRepository;

    @Autowired
    BedRoomRepository bedRoomRepository;

    @Autowired
    BathRoomRepository bathRoomRepository;


    //equipment
    @Autowired
    FurnitureRepository furnitureRepository;

    @Autowired
    LightingAccessoriesRepository lightingAccessoriesRepository;

    @Autowired
    AudioVideoItemsRepository audioVideoItemsRepository;

    @Autowired
    DecorativeAccessoriesRepository decorativeAccessoriesRepository;


    @Override
    public void run(String... args) throws Exception {

        //- - - - - - - - - - - - - premises - - - - - - - - - - - - -

        //creating of premises
        livingRoomRepository.addNewLivingRoom("Living room");      //default 'id' is 1
        kitchenRepository.addNewKitchen("Kitchen");                   //default 'id' is 2

        //creating bedrooms
        //use below method if you want to create only 1 bedroom
        //bedRoomRepository.addNewBedRoom("Bedroom");

        //use below method if you want to create more than 1 bedroom
        bedRoomRepository.addSpecificNumberOfBedrooms("Bedroom", 3); //default 'ids' are 3, 4, 5

        bathRoomRepository.addNewBathRoom("Bathroom");              //default 'id' is 6 etc ....

        //changing name of existing premises e.g. bed room with 'id' = 3
        //bedRoomRepository.changeNameOfExistingBedRoomById(3, "Bedroom - large");

        //- - - - - - - - - - - - - the end of block of premises - - - - - - - - - - - - -

        //adding new furniture to premises; here the tables relation @OneToOne-@OneToOne were used
        furnitureRepository.addNewFurnitureToLivingRoom(1, "TV panel");
        furnitureRepository.addNewFurnitureToKitchen(2, "Kitchen furniture set");
        furnitureRepository.addNewFurnitureToBedRoom(3, "Bedroom furniture set 01");
        furnitureRepository.addNewFurnitureToBedRoom(4, "Bedroom furniture set 02");
        furnitureRepository.addNewFurnitureToBedRoom(5, "Bedroom furniture set 03");
        furnitureRepository.addNewFurnitureToBathRoom(6, "Bathroom furniture set");

        //adding new lighting accessories to premises; here the tables relation @OneToOne-@OneToOne were used
        lightingAccessoriesRepository.addNewLightingAccessoryToLivingRoom(1, "Pendant lamp in the living room");
        lightingAccessoriesRepository.addNewLightingAccessoryToKitchen(2, "Pendant lamp in the kitchen");
        lightingAccessoriesRepository.addNewLightingAccessoryToBedRoom(3, "Pendant lamp in the bedroom 01");
        lightingAccessoriesRepository.addNewLightingAccessoryToBedRoom(4, "Pendant lamp in the bedroom 02");
        lightingAccessoriesRepository.addNewLightingAccessoryToBedRoom(5, "Pendant lamp in the bedroom 03");
        lightingAccessoriesRepository.addNewLightingAccessoryToBathRoom(6, "Ceiling lighting and wall lamps");

        //adding new audio or video items to premises; here the tables relation @OneToOne-@OneToOne were used
        audioVideoItemsRepository.addNewAudioVideoItemToLivingRoom(1, "Living room stereo system");
        audioVideoItemsRepository.addNewAudioVideoItemToKitchen(2, "Kitchen radio");
        audioVideoItemsRepository.addNewAudioVideoItemToBedRoom(3, "Mini stereo system in bedroom 01");
        audioVideoItemsRepository.addNewAudioVideoItemToBedRoom(4, "Mini stereo system in bedroom 02");
        audioVideoItemsRepository.addNewAudioVideoItemToBedRoom(5, "Mini stereo system in bedroom 03");
        audioVideoItemsRepository.addNewAudioVideoItemToBathRoom(6, "Wall phone");

        //adding new decorative accessories items to premises; here the tables relation @OneToMany-@ManyToOne were used
        decorativeAccessoriesRepository.addNewDecorativeAccessoriesItemToBathRoom(6, "Barbados landscape photo no.1");
        decorativeAccessoriesRepository.addNewDecorativeAccessoriesItemToBathRoom(6, "Barbados landscape photo no.2");
        decorativeAccessoriesRepository.addNewDecorativeAccessoriesItemToLivingRoom(1, "Barbados sunset beach view photo");
        decorativeAccessoriesRepository.addNewDecorativeAccessoriesItemToBedRoom(4, "Abu Dhabi picture");
        decorativeAccessoriesRepository.addNewDecorativeAccessoriesItemToKitchen(2, "Walruses on Svalbard beach");

    }

}
