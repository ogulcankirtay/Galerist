package com.oglcnkrty.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Customer extends BaseEntity {

    private String firstName;

    private String lastName;

    private String tckn;

    private Date dateOfBirth;

    @OneToOne
    private Address address;

    @OneToMany
    private List<Account> accounts;
}
