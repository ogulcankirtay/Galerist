package com.oglcnkrty.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Galerist extends BaseEntity {

    private String firstName;

    private String lastName;

    @OneToOne
    private Address address;
}
