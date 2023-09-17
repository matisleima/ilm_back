package com.example.ilm_back.infrastructure;
import lombok.Getter;

@Getter
public enum Error {
    CITY_ALREADY_RECORDED("Selle linna kohta juba kogutakse andmeid!", 111);

    private final String message;
    private final int errorCode;

    Error(String message, int errorCode) {
        this.message = message;
        this.errorCode = errorCode;
    }
}
