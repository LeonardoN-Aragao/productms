package com.projeto.productms.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.projeto.productms.utils.HttpEnum;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@JsonInclude(value = NON_NULL)
public class ProductResponse<T>{

    private Integer statusNumber;
    private String message;
    private T data;

    public ProductResponse() {}

    public ProductResponse(final HttpEnum status, final T data) {
        this.statusNumber = status.getStatus().value();
        this.message = status.getMensagem();
        this.data = data;
    }
}

