package com.mustehssuniqbal.expensesbookkeeping.domain;

import com.mustehssuniqbal.expensesbookkeeping.constants.Gender;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String username;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private Integer age;
    private Gender gender;
}
