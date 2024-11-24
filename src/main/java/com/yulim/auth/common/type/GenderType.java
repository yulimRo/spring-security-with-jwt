package com.yulim.auth.common.type;

import com.fasterxml.jackson.annotation.JsonValue;

public enum GenderType {
    MAN("M"),  //남성
    WOMAN("W")   //여성
    ;

    String code;

    GenderType(String code) {
        this.code = code;
    }

    @JsonValue
    public String getCode() {
        return this.code;
    }
}
