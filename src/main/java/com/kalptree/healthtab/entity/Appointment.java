package com.kalptree.healthtab.entity;

import com.kalptree.healthtab.constant.AppointmentStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.time.LocalDateTime;

import static com.kalptree.healthtab.constant.Constants.REQUIRED_APPOINTMENT_STATUS;
import static com.kalptree.healthtab.constant.Constants.REQUIRED_APPOINTMENT_TIME;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Integer appointmentId;

    @NotEmpty(message = REQUIRED_APPOINTMENT_TIME)
    @Column(nullable = false)
    private LocalDateTime appointmentTime;

    @Column(columnDefinition = "TEXT")
    private String appointmentNotes;

    @NotEmpty(message = REQUIRED_APPOINTMENT_STATUS)
    @Column(nullable = false, columnDefinition = "ENUM('PENDING','CONFIRMED','COMPLETED','CANCELLED')")
    private Enum<AppointmentStatus> appointmentStatus;

    @ManyToOne
    private Patient patientId;

    @ManyToOne
    private Doctor doctorId;
}
