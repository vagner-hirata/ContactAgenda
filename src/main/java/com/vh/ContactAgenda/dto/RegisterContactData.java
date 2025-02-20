package com.vh.ContactAgenda.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RegisterContactData(
        @NotNull
        String name,
        @NotBlank
        String phoneNumber,
        @NotBlank
        String email
) {
}
