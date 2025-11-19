package com.oglcnkrty.dto;

import com.oglcnkrty.model.BaseEntity;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DtoAddressIU extends BaseEntity {

    @NotEmpty
    private String city;
    @NotEmpty
    private String district;
    @NotEmpty
    private String neighborhood;
    @NotEmpty
    private String street;
}
