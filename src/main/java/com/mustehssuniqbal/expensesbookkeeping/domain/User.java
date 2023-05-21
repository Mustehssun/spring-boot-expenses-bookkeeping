package com.mustehssuniqbal.expensesbookkeeping.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mustehssuniqbal.expensesbookkeeping.constants.Gender;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@Table(name = "users")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String username;
    private String email;

    @JsonIgnore
    private String password;

    private String firstName;
    private String lastName;
    private Integer age;
    private Gender gender;

    @Embedded
    private Collection<? extends GrantedAuthority> authorities;
    private Boolean isAccountExpired = false;
    private Boolean isAccountLocked = false;
    private Boolean isAccountEnabled = true;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return !isAccountExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !isAccountLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return isAccountEnabled;
    }
}
