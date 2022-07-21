package com.documentor.shared.domain.valueobjects.email;

import com.documentor.shared.domain.BusinessRule;

final class EmailIsValidRule implements BusinessRule {
    private final String email;

    public EmailIsValidRule(String email) {
        this.email = email;
    }

    @Override
    public boolean isBroken() {
        return email == null || !email.matches("^[a-zA-Z\\d_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z\\d.-]+$");
    }

    @Override
    public String message() {
        return "Email format is invalid";
    }
}
