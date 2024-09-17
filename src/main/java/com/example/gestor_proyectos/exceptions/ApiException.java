package com.example.gestor_proyectos.exceptions;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class ApiException extends RuntimeException {

    private String descripcion;
    private HttpStatus status;

    public ApiException(final String descripcion, final HttpStatus status) {
        super(descripcion);
        this.descripcion = descripcion;
        this.status = status;
    }
}
