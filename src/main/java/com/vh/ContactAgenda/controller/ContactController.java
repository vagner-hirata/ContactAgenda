package com.vh.ContactAgenda.controller;

import com.vh.ContactAgenda.dto.RegisterContactData;
import com.vh.ContactAgenda.dto.UpdateContactData;
import com.vh.ContactAgenda.service.ContactService;
import jakarta.transaction.Transactional;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/contact")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @GetMapping("/all")
    public ResponseEntity getAllContacts() {

        return contactService.getAllContacts();
    }

    @PostMapping("/create-new-contact")
    @Transactional
    public ResponseEntity createContact(@RequestBody RegisterContactData contactData, UriComponentsBuilder uri) {

        return contactService.createContact(contactData, uri);

    }

    @PutMapping("/update-contact")
    @Transactional
    public ResponseEntity updateContact(@RequestBody UpdateContactData contactData) {

        return contactService.updateContact(contactData);
    }











}
