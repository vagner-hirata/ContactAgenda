package com.vh.ContactAgenda.dto;

import com.vh.ContactAgenda.model.Contact;

public record ContactDataList(String name, String phoneNumber, String email) {
    public ContactDataList(Contact contact) {
        this(contact.getName(),
                contact.getPhoneNumber(),
                contact.getEmail());
    }
}
