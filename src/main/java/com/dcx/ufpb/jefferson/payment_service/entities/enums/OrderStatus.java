package com.dcx.ufpb.jefferson.payment_service.entities.enums;

public enum OrderStatus {
    WAITING_PAYMENT(1),
    PAID(2),
    SHIPPED(3),
    DELIVERED(4),
    CANCELED(5);

    private final int code;

    private OrderStatus(int values) {
        this.code = values;
    }

    public int getCode() {
        return code;
    }

    public static OrderStatus valueOf(int code) {
        for(OrderStatus orderStatus : OrderStatus.values()) {
            if(orderStatus.getCode() == code) {
                return orderStatus;
            }
        }
        throw new IllegalArgumentException("No OrderStatus with code " + code);
    }
}
