package com.oglcnkrty.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class RefreshToken extends BaseEntity {

    private String refreshToken;

    private Date expiresAt;

    @ManyToOne
    private User user;
}
