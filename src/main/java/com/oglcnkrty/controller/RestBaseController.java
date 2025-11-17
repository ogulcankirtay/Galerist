package com.oglcnkrty.controller;

import com.oglcnkrty.dto.RootEntity;

public abstract class RestBaseController {

    public <T> RootEntity<T> ok(T payload) {
        return RootEntity.ok(payload);
    }

    public <T> RootEntity<T> error(String errorMessage) {
        return RootEntity.error(errorMessage);
    }

}
