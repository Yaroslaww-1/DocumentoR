package com.documentor.shared.domain.valueobjects.email;

import com.documentor.shared.domain.ValueObject;
import lombok.*;

@Value
@EqualsAndHashCode(callSuper = false)
public class Email extends ValueObject {
    @NonNull String value;

    public Email(@NonNull String email) {
        checkRule(new EmailIsValidRule(email));
        this.value = email;
    }
}