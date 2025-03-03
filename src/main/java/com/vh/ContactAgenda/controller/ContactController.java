package com.vh.ContactAgenda.controller;

import com.vh.ContactAgenda.dto.RegisterContactData;
import com.vh.ContactAgenda.dto.UpdateContactData;
import com.vh.ContactAgenda.service.ContactService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/contact")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @GetMapping("/all")
    public ResponseEntity getAllContacts(@PageableDefault(sort = {"name"}) Pageable pageable) {

        return contactService.getAllContacts(pageable);
    }

    @PostMapping("/create-new-contact")
    @Transactional
    public ResponseEntity createContact(@RequestBody @Valid RegisterContactData contactData, UriComponentsBuilder uri) {

        return contactService.createContact(contactData, uri);

    }

    @PutMapping("/update-contact")
    @Transactional
    public ResponseEntity updateContact(@RequestBody @Valid UpdateContactData contactData) {

        return contactService.updateContact(contactData);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity deleteContact(@PathVariable Long id) {
        return contactService.deleteContact(id);
    }



    @GetMapping("/filtered-contact")
    @ResponseBody
    public ResponseEntity getContactByNameOrEmail(Pageable pageable,
                                                  @RequestParam(required = false) String name,
                                                  @RequestParam(required = false) String email) {

            return contactService.getContactByNameOrEmail(pageable, name, email);

    }











}
