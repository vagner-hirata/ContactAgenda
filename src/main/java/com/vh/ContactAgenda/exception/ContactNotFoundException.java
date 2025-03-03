package com.vh.ContactAgenda.exception;

public class ContactNotFoundException extends RuntimeException {
    public ContactNotFoundException(String msg) {
        super(msg);
    }
}
