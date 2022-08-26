package com.bvc.digitalevents.persistence.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "event_platform")
@IdClass(EventPerPlatformPK.class)
public class EventPerPlatform implements Serializable {

    @Id
    @Temporal (TemporalType.DATE)
    @Column(name = "init_date")
    private LocalDate initDate;
    @Id
    @Column(name = "id_platform")
    private String platformId;

    @Id
    @Column(name = "id_event")
    private String eventId;

    private Integer quantity;

    private Float price;

    public EventPerPlatform(LocalDate initDate, String platformId, String eventId, Integer quantity, Float price) {
        this.initDate = initDate;
        this.platformId = platformId;
        this.eventId = eventId;
        this.quantity = quantity;
        this.price = price;
    }

    public EventPerPlatform() {
    }

    public LocalDate getInitDate() {
        return initDate;
    }

    public void setInitDate(LocalDate initDate) {
        this.initDate = initDate;
    }

    public String getPlatformId() {
        return platformId;
    }

    public void setPlatformId(String platformId) {
        this.platformId = platformId;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
}
