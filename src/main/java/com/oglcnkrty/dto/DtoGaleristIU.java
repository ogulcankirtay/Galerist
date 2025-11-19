package com.oglcnkrty.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data

public class DtoGaleristIU {

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    private Long addressId;
}
