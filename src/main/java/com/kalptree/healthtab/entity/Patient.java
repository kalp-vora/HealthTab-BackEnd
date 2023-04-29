package com.kalptree.healthtab.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Integer patientId;

    private String allergies;

    @Column(columnDefinition = "TEXT")
    private String chronicDisease;

    @Column(columnDefinition = "TEXT")
    private String unhealthyHabits;

    @OneToOne
    @JoinColumn(name = "userId", referencedColumnName = "userId")
    private Users userId;

    @OneToMany(mappedBy = "patientId")
    private List<Appointment> appointments;
}
