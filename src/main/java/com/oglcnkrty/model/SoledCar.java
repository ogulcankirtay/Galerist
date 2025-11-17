package com.oglcnkrty.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "soled_car", uniqueConstraints = {@UniqueConstraint(columnNames =
         {"galerist_id", "car_id", "customer_id"},name = "uq_galerist_car_customer")})
public class SoledCar extends BaseEntity {
    @ManyToOne
    private Galerist galerist;
    @ManyToOne
    private Car car;
    @ManyToOne
    private Customer customer;
}
