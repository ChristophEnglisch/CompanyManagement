package com.cenglisch.appointment.port.adapter.secondary.database.participant;

import com.cenglisch.common.Default;

import javax.persistence.*;

@Entity(name = "participant")
public class ParticipantEntity {
    @Id
    @Column(name = "id", nullable = false)
    private String id;
    @Column
    private String name;
    @Column
    private String email;

    public ParticipantEntity(){}

    @Default
    public ParticipantEntity(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
