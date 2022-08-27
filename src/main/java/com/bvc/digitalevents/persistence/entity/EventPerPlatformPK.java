package com.bvc.digitalevents.persistence.entity;

import javax.persistence.Column;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class EventPerPlatformPK implements Serializable {

    @Column(name = "init_date")
    private LocalDate initDate;

    @Column(name = "id_platform")
    private String platformId;

    @Column(name = "id_event")
    private String eventId;

    public EventPerPlatformPK(LocalDate initDate, String platformId, String eventId) {
        this.initDate = initDate;
        this.platformId = platformId;
        this.eventId = eventId;
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

    public EventPerPlatformPK() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EventPerPlatformPK that = (EventPerPlatformPK) o;
        return initDate.equals(that.initDate) && platformId.equals(that.platformId) && eventId.equals(that.eventId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(initDate, platformId, eventId);
    }
}
