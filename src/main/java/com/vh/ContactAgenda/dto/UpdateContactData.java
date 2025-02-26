package com.vh.ContactAgenda.dto;

import jakarta.validation.constraints.NotNull;

public record UpdateContactData(
        @NotNull
        Long id,
        String name,
        String phoneNumber,
        String email
) {
}
