package com.example.apartment_creator.Entities.Premises;

import com.example.apartment_creator.Entities.Equipment.AudioVideoItems;
import com.example.apartment_creator.Entities.Equipment.DecorativeAccessories;
import com.example.apartment_creator.Entities.Equipment.Furniture;
import com.example.apartment_creator.Entities.Equipment.LightingAccessories;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class BedRoom {

    @Id
    @GeneratedValue
    public Integer id;

    @Column
    public String bedRoomName;

    @OneToOne
    Furniture furniture;

    @OneToOne
    LightingAccessories lightingAccessories;

    @OneToOne
    AudioVideoItems audioVideoItems;

    @OneToMany(fetch = FetchType.EAGER)
    List<DecorativeAccessories> decorativeAccessories = new ArrayList<>();

    public BedRoom(){}

    public BedRoom(String bedRoomName) {
        this.bedRoomName = bedRoomName;
    }

    public Integer getId() {
        return id;
    }

    public String getBedRoomName() {
        return bedRoomName;
    }

    public void setBedRoomName(String bedRoomName) {
        this.bedRoomName = bedRoomName;
    }

    public AudioVideoItems getAudioVideoItems() {
        return audioVideoItems;
    }

    public void setAudioVideoItems(AudioVideoItems audioVideoItems) {
        this.audioVideoItems = audioVideoItems;
    }

    public Furniture getFurniture() {
        return furniture;
    }

    public void setFurniture(Furniture furniture) {
        this.furniture = furniture;
    }

    public LightingAccessories getLightingAccessories() {
        return lightingAccessories;
    }

    public void setLightingAccessories(LightingAccessories lightingAccessories) {
        this.lightingAccessories = lightingAccessories;
    }

    public List<DecorativeAccessories> getDecorativeAccessories() {
        return decorativeAccessories;
    }

    public void setDecorativeAccessories(DecorativeAccessories decorativeAccessories) {
        this.decorativeAccessories.add(decorativeAccessories);
    }

}
