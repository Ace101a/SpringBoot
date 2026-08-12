package com.aman.springbootweb.advices;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ApiResponse<T> {
    private T data;

    private LocalDateTime timeStamp;

    private ApiErrors error;

    public ApiResponse() {
        this.timeStamp = LocalDateTime.now();
    }

    public ApiResponse(T data) {
        this();
        this.data = data;
    }

    public ApiResponse(ApiErrors error) {
        this();
        this.error = error;
    }

}
