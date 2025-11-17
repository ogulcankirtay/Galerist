package com.oglcnkrty.model;

import jakarta.persistence.Entity;
import lombok.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Address extends BaseEntity {

    private String city;

    private String district;

    private String neighborhood;

    private String street;

}
