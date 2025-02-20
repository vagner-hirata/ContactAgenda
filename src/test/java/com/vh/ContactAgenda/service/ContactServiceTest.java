package com.vh.ContactAgenda.service;

import com.vh.ContactAgenda.dto.ContactDataList;
import com.vh.ContactAgenda.model.Contact;
import com.vh.ContactAgenda.repository.ContactRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ContactServiceTest {
    private ContactRepository contactRepository;

    @Test
    void getAllContacts() {
        // given

        Contact contact = new Contact(1L, "Henrique", "11912345678", "henrique@email.com");

        // when
//        List<ContactDataList> contacts = contactRepository.findAll().stream().map(ContactDataList::new).toList();
        Contact ContactById = contactRepository.getReferenceById(1L);
        // then
        assertEquals(contact, ContactById);

    }
}