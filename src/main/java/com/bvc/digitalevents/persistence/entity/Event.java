package com.bvc.digitalevents.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "event")
public class Event {
    @Id
    @Column(name = "id")
    private String idEvent;

    private String description;

    @Column(name = "unit_value")
    private Float unitValue;

    public Event(String idEvent, String description, Float unitValue) {
        this.idEvent = idEvent;
        this.description = description;
        this.unitValue = unitValue;
    }

    public Event() {
    }

    public String getIdEvent() {
        return idEvent;
    }

    public void setIdEvent(String idEvent) {
        this.idEvent = idEvent;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getUnitValue() {
        return unitValue;
    }

    public void setUnitValue(Float unitValue) {
        this.unitValue = unitValue;
    }
}
