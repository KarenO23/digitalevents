package com.bvc.digitalevents.domain;

import java.time.LocalDate;


public class RegistryEvent {

    private String idEvent;
    private String idPlatform;
    private LocalDate initDate;
    private int quantity;
    private float price;

    public RegistryEvent(String idEvent, String idPlatform, LocalDate initDate, int quantity, float price) {
        this.idEvent = idEvent;
        this.idPlatform = idPlatform;
        this.initDate = initDate;
        this.quantity = quantity;
        this.price = price;
    }

    public String getIdEvent() {
        return idEvent;
    }

    public void setIdEvent(String idEvent) {
        this.idEvent = idEvent;
    }

    public String getIdPlatform() {
        return idPlatform;
    }

    public void setIdPlatform(String idPlatform) {
        this.idPlatform = idPlatform;
    }

    public LocalDate getInitDate() {
        return initDate;
    }

    public void setInitDate(LocalDate initDate) {
        this.initDate = initDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
