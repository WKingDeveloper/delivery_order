package com.example.order.model.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Response {
    private String code;
    private Object data;
    private String error;

    public Response() {
        this.code = "200";
        this.data = "";
        this.error = "";
    }
}
