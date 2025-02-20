package com.vh.ContactAgenda.service;

import com.vh.ContactAgenda.dto.ContactDataDetails;
import com.vh.ContactAgenda.dto.ContactDataList;
import com.vh.ContactAgenda.dto.RegisterContactData;
import com.vh.ContactAgenda.model.Contact;
import com.vh.ContactAgenda.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;


@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

    public ResponseEntity getAllContacts() {
        List<ContactDataList> contacts = contactRepository.findAll().stream().map(ContactDataList::new).toList();
        return ResponseEntity.ok(contacts);

    }

    public ResponseEntity createContact(RegisterContactData contactData, UriComponentsBuilder uriBuilder) {
        Contact contact = new Contact(contactData);
        contactRepository.save(contact);
        URI uri = uriBuilder.path("/contact/{id}").buildAndExpand(contact.getId()).toUri();
        return ResponseEntity.created(uri).body(new ContactDataDetails(contact));
    }

}
