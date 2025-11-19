package com.oglcnkrty.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DtoGalerist extends DtoBase {

    private String firstName;

    private String lastName;

    private DtoAddress address;
}
