package com.deliveryslotbookingapi.slot;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum Status {
    AVAILABLE
    , FULL
    , CLOSED;

    @JsonCreator
    public static Status fromValue(String value){
        return Status.valueOf(value.toUpperCase());
    }
}
