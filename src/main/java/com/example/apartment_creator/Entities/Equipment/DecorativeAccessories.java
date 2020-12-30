package com.example.apartment_creator.Entities.Equipment;

import com.example.apartment_creator.Entities.Premises.BathRoom;
import com.example.apartment_creator.Entities.Premises.BedRoom;
import com.example.apartment_creator.Entities.Premises.Kitchen;
import com.example.apartment_creator.Entities.Premises.LivingRoom;
import javax.persistence.*;

@Entity
public class DecorativeAccessories {

    @Id
    @GeneratedValue
    public Integer id;

    @Column
    String decorativeAccessoriesName;

    @ManyToOne
    BathRoom bathRoom;

    @ManyToOne
    LivingRoom livingRoom;

    @ManyToOne
    BedRoom bedRoom;

    @ManyToOne
    Kitchen kitchen;

    protected DecorativeAccessories(){}

    public DecorativeAccessories(String decorativeAccessoriesName) {
        this.decorativeAccessoriesName = decorativeAccessoriesName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDecorativeAccessoriesName() {
        return decorativeAccessoriesName;
    }

    public void setDecorativeAccessoriesName(String decorativeAccessories) {
        this.decorativeAccessoriesName = decorativeAccessories;
    }

    public BathRoom getBathRoom() {
        return bathRoom;
    }

    public void setBathRoom(BathRoom bathRoom) {
        this.bathRoom = bathRoom;
    }

    public LivingRoom getLivingRoom() {
        return livingRoom;
    }

    public void setLivingRoom(LivingRoom livingRoom) {
        this.livingRoom = livingRoom;
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

}
