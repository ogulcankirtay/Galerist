package com.oglcnkrty.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RootEntity<T> {

    private Integer status;

    private T payload;

    private String errorMessage;

    public static <T> RootEntity<T> ok(T payload) {
        RootEntity<T> entity = new RootEntity<T>();
        entity.setPayload(payload);
        entity.setStatus(HttpStatus.OK.value());
        entity.setErrorMessage(null);
        return entity;
    }

    public static <T> RootEntity<T> error(String errorMessage) {
        RootEntity<T> entity = new RootEntity<T>();
        entity.setStatus(HttpStatus.BAD_REQUEST.value());
        entity.setErrorMessage(errorMessage);
        return entity;
    }
}
