package com.vh.ContactAgenda.repository;

import com.vh.ContactAgenda.model.Contact;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Long> {
    Page<Contact> findContactByNameOrEmail(Pageable pageable, String name, String email);

    boolean existsByNameOrEmail(String name, String email);
}
