package com.kalptree.healthtab.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import static com.kalptree.healthtab.constant.Constants.REQUIRED_DIAGNOSIS;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Prescription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Integer prescriptionId;

    @NotEmpty(message = REQUIRED_DIAGNOSIS)
    @Column(nullable = false, columnDefinition = "TEXT")
    private String diagnosis;

    @Column(columnDefinition = "TEXT")
    private String treatmentPlan;

    @Column(columnDefinition = "TEXT")
    private String medicationName;

    @Column(length = 100)
    private String dosage;

    @Column(columnDefinition = "TEXT")
    private String prescriptionNotes;

    @OneToOne
    @JoinColumn(name = "appointmentId", referencedColumnName = "appointmentId")
    private Appointment appointmentId;
}
