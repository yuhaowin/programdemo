package com.yuhaowin.enums;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Getter;

@Getter
public enum Type implements EnumBase {
    A("11","This is A"),
    B("12","This is B")
    ;
    private String code;
    private String message;

    Type(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
