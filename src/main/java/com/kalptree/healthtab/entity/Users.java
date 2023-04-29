package com.kalptree.healthtab.entity;

import com.kalptree.healthtab.constant.Gender;
import com.kalptree.healthtab.constant.UserType;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static com.kalptree.healthtab.constant.Constants.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Integer userId;

    @NotEmpty(message = REQUIRED_FIRST_NAME)
    @Column(nullable = false, length = 30)
    private String firstName;

    @NotEmpty(message = REQUIRED_LAST_NAME)
    @Column(nullable = false, length = 30)
    private String lastName;

    @NotEmpty(message = REQUIRED_EMAIL)
    @Email
    @Length(min = 5)
    @Column(nullable = false, unique = true, length = 50)
    private String email;

    @NotEmpty(message = REQUIRED_PASSWORD)
    @Column(nullable = false)
    private String password;

    @NotEmpty(message = REQUIRED_CONTACT)
    @Length(min = 12, max = 12)
    @Column(nullable = false, unique = true, length = 12)
    private String contact_number;

    @NotNull(message = REQUIRED_GENDER)
    @Column(nullable = false, columnDefinition = "ENUM('M','F','T')")
    private Enum<Gender> gender;

    @NotNull(message = REQUIRED_DATE_OF_BIRTH)
    @Column(nullable = false)
    private LocalDate dateOfBirth;

    @NotEmpty(message = REQUIRED_USER_TYPE)
    @Column(nullable = false, columnDefinition = "ENUM('PATIENT','DOCTOR','ADMIN')")
    private Enum<UserType> userType;

    @CreationTimestamp
    private LocalDateTime creationDateTime;

    @UpdateTimestamp
    private LocalDateTime modifiedDateTime;
}
