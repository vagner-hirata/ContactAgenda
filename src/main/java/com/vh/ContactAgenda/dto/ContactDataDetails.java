package com.vh.ContactAgenda.dto;

import com.vh.ContactAgenda.model.Contact;

public record ContactDataDetails(Long id, String name, String phoneNumber, String email) {

    public ContactDataDetails(Contact contact) {
        this(contact.getId(), contact.getName(), contact.getPhoneNumber(), contact.getEmail());
    }
}
