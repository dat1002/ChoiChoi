package com.example.test.constant;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


public enum ResponseMessageEnum {
    SUCCESS ("Response success"),
    ERROR ("Response error");
    private String message;

    ResponseMessageEnum() {
    }

    ResponseMessageEnum(String message) {
        this.message = message;
    }
}
