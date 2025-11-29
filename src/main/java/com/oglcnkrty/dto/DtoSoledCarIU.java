package com.oglcnkrty.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DtoSoledCarIU {
    @NotNull
    private Long galeristId;
    @NotNull
    private Long carId;
    @NotNull
    private Long customerId;
}
