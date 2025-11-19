package com.oglcnkrty.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DtoCustomerIU {
    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    private String tckn;

    @NotNull(message = "dateOfBirth cannot be null")
    private Date dateOfBirth;

    @NotNull
    private Long addressId;

    @NotNull
    private List<Long> accountsId;

}
