package com.example.apartment_creator.Entities.Equipment;

import com.example.apartment_creator.Entities.Premises.*;
import javax.persistence.*;

@Entity
public class Furniture {

    @Id
    @GeneratedValue
    private Integer id;

    @Column
    private String furnitureName;

    @OneToOne
    LivingRoom livingRoom;

    @OneToOne
    Kitchen kitchen;

    @OneToOne
    BedRoom bedRoom;

    @OneToOne
    BathRoom bathRoom;

    protected Furniture(){}

    public Furniture(String furnitureName) {
        this.furnitureName = furnitureName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFurnitureName() {
        return furnitureName;
    }

    public void setFurnitureName(String furnitureName) {
        this.furnitureName = furnitureName;
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
