package com.projeto.productms.utils;

import org.springframework.http.HttpStatus;

public enum HttpEnum {

    HTTP_200(HttpStatus.OK, "200"),
    HTTP_201(HttpStatus.CREATED, "201"),
    HTTP_304(HttpStatus.NOT_MODIFIED, "304"),
    HTTP_400(HttpStatus.BAD_REQUEST, "400"),
    HTTP_404(HttpStatus.NOT_FOUND, "404"),
    HTTP_500(HttpStatus.INTERNAL_SERVER_ERROR, "500");

    private HttpStatus status;
    private String mensagem;

    private HttpEnum(final HttpStatus status, final String mensagem) {
        this.status = status;
        this.mensagem = mensagem;
    }

    public String getMensagem() {
        return mensagem;
    }

    public HttpStatus getStatus() {
        return status;
    }
}
