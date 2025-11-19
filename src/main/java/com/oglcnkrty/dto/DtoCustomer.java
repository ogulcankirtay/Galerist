package com.oglcnkrty.dto;

import com.oglcnkrty.model.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DtoCustomer extends BaseEntity {

    private String firstName;

    private String lastName;

    private String tckn;

    private Date dateOfBirth;

    private DtoAddress address;

    private List<DtoAccount> accounts = new ArrayList<>();
}
