package com.example.apartment_creator.Entities.Equipment;

import com.example.apartment_creator.Entities.Premises.BathRoom;
import com.example.apartment_creator.Entities.Premises.BedRoom;
import com.example.apartment_creator.Entities.Premises.Kitchen;
import com.example.apartment_creator.Entities.Premises.LivingRoom;
import javax.persistence.*;

@Entity
public class LightingAccessories {

    @Id
    @GeneratedValue
    private Integer id;

    @Column
    private String lightingAccessoryName;

    @OneToOne
    BedRoom bedRoom;

    @OneToOne
    Kitchen kitchen;

    @OneToOne
    LivingRoom livingRoom;

    @OneToOne
    BathRoom bathRoom;

    protected LightingAccessories(){}

    public LightingAccessories(String lightingAccessoryName) {
        this.lightingAccessoryName = lightingAccessoryName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLightingAccessoryName() {
        return lightingAccessoryName;
    }

    public void setLightingAccessoryName(String lightingAccessoryName) {
        this.lightingAccessoryName = lightingAccessoryName;
    }

    public BedRoom getBedRoom() {
        return bedRoom;
    }

    public void setBedRoom(BedRoom bedRoom) {
        this.bedRoom = bedRoom;
    }

    public Kitchen getKitchen() {
        return kitchen;
    }

    public void setKitchen(Kitchen kitchen) {
        this.kitchen = kitchen;
    }

    public LivingRoom getLivingRoom() {
        return livingRoom;
    }

    public void setLivingRoom(LivingRoom livingRoom) {
        this.livingRoom = livingRoom;
    }

    public BathRoom getBathRoom() {
        return bathRoom;
    }

    public void setBathRoom(BathRoom bathRoom) {
        this.bathRoom = bathRoom;
    }

}
