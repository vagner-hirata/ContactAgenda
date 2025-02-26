package com.vh.ContactAgenda.model;

import com.vh.ContactAgenda.dto.RegisterContactData;
import com.vh.ContactAgenda.dto.UpdateContactData;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Table(name= "contacts")
@Entity(name="contact")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String phoneNumber;
    private String email;

    public Contact(RegisterContactData data) {

        this.name = data.name();
        this.phoneNumber = data.phoneNumber();
        this.email = data.email();

    }

    public void updateData(UpdateContactData contactData) {
        if(contactData.name() != null) {
            this.name = contactData.name();
        }
        if(contactData.phoneNumber() != null) {
            this.phoneNumber = contactData.phoneNumber();
        }
        if(contactData.email() != null) {
            this.email = contactData.email();
        }
    }
}


