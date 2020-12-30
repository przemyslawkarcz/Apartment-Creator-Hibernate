package com.example.apartment_creator.Entities.Premises;

import com.example.apartment_creator.Entities.Equipment.AudioVideoItems;
import com.example.apartment_creator.Entities.Equipment.DecorativeAccessories;
import com.example.apartment_creator.Entities.Equipment.Furniture;
import com.example.apartment_creator.Entities.Equipment.LightingAccessories;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class BathRoom {

    @Id
    @GeneratedValue
    Integer id;

    @Column
    String bathRoomName;

    @OneToOne
    Furniture furniture;

    @OneToOne
    LightingAccessories lightingAccessories;

    @OneToOne
    AudioVideoItems audioVideoItems;

    @OneToMany(fetch = FetchType.EAGER)
    List<DecorativeAccessories> decorativeAccessories = new ArrayList<>();

    public BathRoom(){}

    public BathRoom(String bathRoomName) {
        this.bathRoomName = bathRoomName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBathRoomName() {
        return bathRoomName;
    }

    public void setBathRoomName(String bathRoomName) {
        this.bathRoomName = bathRoomName;
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

    public AudioVideoItems getAudioVideoItems() {
        return audioVideoItems;
    }

    public void setAudioVideoItems(AudioVideoItems audioVideoItems) {
        this.audioVideoItems = audioVideoItems;
    }

    public List<DecorativeAccessories> getDecorativeAccessories() {
        return decorativeAccessories;
    }

    public void setDecorativeAccessories(DecorativeAccessories decorativeAccessories) {
        this.decorativeAccessories.add(decorativeAccessories);
    }

}
