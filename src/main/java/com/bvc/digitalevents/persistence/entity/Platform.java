package com.bvc.digitalevents.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "platform")
public class Platform {

    @Id
    @Column(name = "id")
    private String idPlatform;
    private String name;

    public Platform(String idPlatform, String name) {
        this.idPlatform = idPlatform;
        this.name = name;
    }

    public Platform() {
    }

    public String getIdPlatform() {
        return idPlatform;
    }

    public void setIdPlatform(String idPlatform) {
        this.idPlatform = idPlatform;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
