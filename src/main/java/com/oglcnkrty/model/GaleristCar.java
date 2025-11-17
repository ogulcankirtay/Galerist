package com.oglcnkrty.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "galerist_car",
uniqueConstraints = {@UniqueConstraint(columnNames = {"galerist_id","car_id"},name = "uq_galerist_car")})
public class GaleristCar extends BaseEntity {

    @ManyToOne
    private Galerist Galerist;

    @OneToOne
    private Car Car;
}
