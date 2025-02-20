package com.vh.ContactAgenda.controller;

import com.vh.ContactAgenda.service.ContactService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/contact")
public class ContactController {

    private ContactService contactService;

    @GetMapping
    public void getAllContacts() {

    }
}
