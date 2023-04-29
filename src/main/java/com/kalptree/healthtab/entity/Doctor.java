package com.kalptree.healthtab.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.util.Set;

import static com.kalptree.healthtab.constant.Constants.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Integer doctorId;

    @NotEmpty(message = REQUIRED_LICENCE)
    @Column(nullable = false, unique = true, length = 30)
    private String licenseNumber;

    @NotEmpty(message = REQUIRED_OLD_CASE_FEES)
    @Column(nullable = false)
    private Integer oldCaseFees;

    @NotEmpty(message = REQUIRED_NEW_CASE_FEES)
    @Column(nullable = false)
    private Integer newCaseFees;

    @OneToOne
    @JoinColumn(name = "userId", referencedColumnName = "userId")
    private Users userId;

    @OneToMany(mappedBy = "doctorId")
    private Set<DoctorDegree> doctorDegree;
}
