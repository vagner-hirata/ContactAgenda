package com.vh.ContactAgenda.service;

import com.vh.ContactAgenda.dto.ContactDataDetails;
import com.vh.ContactAgenda.dto.ContactDataList;
import com.vh.ContactAgenda.dto.RegisterContactData;
import com.vh.ContactAgenda.dto.UpdateContactData;
import com.vh.ContactAgenda.exception.ContactNotFoundException;
import com.vh.ContactAgenda.model.Contact;
import com.vh.ContactAgenda.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;


@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;


    // Method Get
    // it will display all contact when called
    public ResponseEntity<Page<ContactDataList>> getAllContacts(Pageable pageable) {
        Page<ContactDataList> page = contactRepository.findAll(pageable).map(ContactDataList::new);
        return ResponseEntity.ok(page);

    }

    // Method Post
    // it will create a new contact with the required data when called
    public ResponseEntity createContact(RegisterContactData contactData, UriComponentsBuilder uriBuilder) {
        Contact contact = new Contact(contactData);
        contactRepository.save(contact);
        URI uri = uriBuilder.path("/contact/{id}").buildAndExpand(contact.getId()).toUri();
        return ResponseEntity.created(uri).body(new ContactDataDetails(contact));
    }


    // Method Put
    // It will update the contact data that you want to change when called
    public ResponseEntity updateContact(UpdateContactData contactData) {
        isNotValidId(contactData.id());
        Contact contact = contactRepository.getReferenceById(contactData.id());

        contact.updateData(contactData);
        return ResponseEntity.ok(new ContactDataDetails(contact));
    }

    public ResponseEntity deleteContact(Long id) {
        isNotValidId(id);
       contactRepository.deleteById(id);
       return ResponseEntity.noContent().build();
    }

    public ResponseEntity<Page<Contact>> getContactByNameOrEmail(Pageable pageable, String name, String email) {
        if(!contactRepository.existsByNameOrEmail(name, email)) {
            throw new ContactNotFoundException("Contact by name or email provided was not found");
        }
        Page<Contact> filteredPage = contactRepository.findContactByNameOrEmail(pageable, name, email);
        return ResponseEntity.ok(filteredPage);
    }

    private void isNotValidId(Long id) {
        if(!contactRepository.existsById(id)) {
            throw new ContactNotFoundException("Contact by id: " + id + " was not found");
        }
    }

}
