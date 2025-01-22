package com.pinnacle.bus.exception;

import java.io.Serial;

public class BookingNotFoundException extends RuntimeException{
    @Serial
    private static final long serialVersionUID = 1L;

    public BookingNotFoundException() {
        super();
    }

    public BookingNotFoundException(String customMessage) {
        super(customMessage);
    }
}
