package com.example.order.model.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SuccessResponseDto extends ResponseDto {
    private Object data;

    public SuccessResponseDto(Object data) {
        super();
        super.code = "200";
        this.data = data;
    }
}
