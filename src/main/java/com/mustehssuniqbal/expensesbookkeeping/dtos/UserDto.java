package com.mustehssuniqbal.expensesbookkeeping.dtos;

import com.mustehssuniqbal.expensesbookkeeping.constants.Gender;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
    private String username;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private Integer age;
    private Gender gender;
}
