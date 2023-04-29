package com.kalptree.healthtab.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import static com.kalptree.healthtab.constant.Constants.REQUIRED_DEGREE;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class DoctorDegree {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "doctorId", referencedColumnName = "doctorId")
    private Doctor doctorId;

    @NotEmpty(message = REQUIRED_DEGREE)
    @Column(nullable = false, length = 50)
    private String degreeName;

}
