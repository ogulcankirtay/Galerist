package com.oglcnkrty.dto;

import lombok.Data;

import java.util.Date;

@Data
public class ExceptionModel<T> {
    private String path;
    private Date creationDate;
    private String hostName;

    private T message;
}
