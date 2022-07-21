package com.documentor.user.service.api.controllers.companyowners;

import lombok.NonNull;

import javax.validation.constraints.Email;

public record RegisterCompanyOwnerRequest(
        @NonNull @Email String email,
        @NonNull String name
) { }