package com.documentor.shared.domain.exceptions;

import com.documentor.shared.domain.BusinessRule;
import lombok.Getter;
import lombok.NonNull;
import lombok.experimental.Accessors;

@Accessors(fluent = true)
public class BusinessRuleValidationException extends RuntimeException {
    @Getter
    private final BusinessRule brokenRule;

    @Getter
    @NonNull
    private final String details;

    public BusinessRuleValidationException(
            BusinessRule brokenRule
    ) {
        super(brokenRule.message());
        this.brokenRule = brokenRule;
        this.details = brokenRule.message();
    }

    @Override
    public String toString() {
        return brokenRule.getClass().getName() + " : " + brokenRule.message();
    }
}
