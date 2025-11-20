package com.oglcnkrty.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DtoGaleristCarIU {
    @NotNull
    private Long GaleristId;

    @NotNull
    private Long CarId;
}
