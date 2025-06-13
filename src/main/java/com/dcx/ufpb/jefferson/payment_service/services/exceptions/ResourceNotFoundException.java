package com.dcx.ufpb.jefferson.payment_service.services.exceptions;

public class ResourceNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public ResourceNotFoundException(Object id) {
        super("Rosource not found. Id " + id);
    }
}
