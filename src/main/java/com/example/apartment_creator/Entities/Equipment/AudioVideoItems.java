package com.example.apartment_creator.Entities.Equipment;

import com.example.apartment_creator.Entities.Premises.BathRoom;
import com.example.apartment_creator.Entities.Premises.BedRoom;
import com.example.apartment_creator.Entities.Premises.Kitchen;
import com.example.apartment_creator.Entities.Premises.LivingRoom;
import javax.persistence.*;

@Entity
public class AudioVideoItems {

    @Id
    @GeneratedValue
    Integer id;

    @Column
    String audioVideoItemName;

    @OneToOne
    LivingRoom livingRoom;

    @OneToOne
    Kitchen kitchen;

    @OneToOne
    BedRoom bedRoom;

    @OneToOne
    BathRoom bathRoom;

    protected AudioVideoItems(){}

    public AudioVideoItems(String audioVideoItemName) {
        this.audioVideoItemName = audioVideoItemName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAudioVideoItemName() {
        return audioVideoItemName;
    }

    public void setAudioVideoItemName(String audioVideoItemName) {
        this.audioVideoItemName = audioVideoItemName;
    }

    public LivingRoom getLivingRoom() {
        return livingRoom;
    }

    public void setLivingRoom(LivingRoom livingRoom) {
        this.livingRoom = livingRoom;
    }

    public Kitchen getKitchen() {
        return kitchen;
    }

    public void setKitchen(Kitchen kitchen) {
        this.kitchen = kitchen;
    }

    public BedRoom getBedRoom() {
        return bedRoom;
    }

    public void setBedRoom(BedRoom bedRoom) {
        this.bedRoom = bedRoom;
    }

    public BathRoom getBathRoom() {
        return bathRoom;
    }

    public void setBathRoom(BathRoom bathRoom) {
        this.bathRoom = bathRoom;
    }

}
