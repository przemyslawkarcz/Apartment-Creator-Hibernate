package com.example.apartment_creator.Entities.Premises;

import com.example.apartment_creator.Entities.Equipment.AudioVideoItems;
import com.example.apartment_creator.Entities.Equipment.DecorativeAccessories;
import com.example.apartment_creator.Entities.Equipment.Furniture;
import com.example.apartment_creator.Entities.Equipment.LightingAccessories;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class LivingRoom {

    @Id
    @GeneratedValue
    Integer id;

    @Column
    public String roomName;

    @OneToOne
    Furniture furniture;

    @OneToOne
    LightingAccessories lightingAccessories;

    @OneToOne
    AudioVideoItems audioVideoItems;

    @OneToMany(fetch = FetchType.EAGER)
    List<DecorativeAccessories> decorativeAccessories = new ArrayList<>();

    protected LivingRoom(){}

    public LivingRoom(String roomName) {
        this.roomName = roomName;
    }

    public Integer getId() {
        return id;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
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

    @Override
    public String toString() {
        return "LivingRoom{" +
                "decorativeAccessories=" + decorativeAccessories +
                '}';
    }

}
