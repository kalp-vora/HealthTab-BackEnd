package com.kalptree.healthtab.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import java.time.LocalTime;
import java.util.Set;

import static com.kalptree.healthtab.constant.Constants.*;
import static com.kalptree.healthtab.constant.Constants.REQUIRED_CLOSING_HOURS;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Clinic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Integer clinicId;

    @NotEmpty(message = REQUIRED_CLINIC_NAME)
    @Column(nullable = false, length = 100)
    private String name;

    @NotEmpty(message = REQUIRED_CONTACT)
    @Length(min = 12, max = 12)
    @Column(nullable = false, unique = true, length = 12)
    private String contact_number;

    @NotEmpty(message = REQUIRED_ADDRESS)
    @Column(nullable = false, columnDefinition = "TEXT")
    private String address;

    @NotEmpty(message = REQUIRED_CITY)
    @Column(nullable = false, length = 50)
    private String city;

    @NotEmpty(message = REQUIRED_STATE)
    @Column(nullable = false, length = 50)
    private String state;

    @NotEmpty(message = REQUIRED_PINCODE)
    @Length(min = 6, max = 6)
    @Column(nullable = false)
    private Integer pincode;

    @NotEmpty(message = REQUIRED_OPENING_HOURS)
    @Column(nullable = false)
    private LocalTime openingTime;

    @NotEmpty(message = REQUIRED_CLOSING_HOURS)
    @Column(nullable = false)
    private LocalTime closingTime;

    @ManyToMany(mappedBy = "clinics")
    private Set<Doctor> doctors;
}
