package com.example.order.model.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorResponseDto extends ResponseDto{
    private String errorMessage;

    public ErrorResponseDto(String code, String errorMessage) {
        super();
        super.code = code;
        this.errorMessage = errorMessage;
    }
}
