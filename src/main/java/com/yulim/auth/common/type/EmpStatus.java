package com.yulim.auth.common.type;

import com.fasterxml.jackson.annotation.JsonValue;

public enum EmpStatus {
    WORK("01"),  //재직
    ON_LEAVE("02"),  //휴직
    RETIRED("03"), //퇴직
    ;

    String code;

    EmpStatus(String code) {
        this.code = code;
    }

    @JsonValue
    public String getCode() {
        return this.code;
    }
}
