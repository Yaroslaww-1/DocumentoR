package com.documentor.shared.domain;

import com.documentor.shared.domain.exceptions.BusinessRuleValidationException;

public abstract class Entity {
    protected static void checkRule(BusinessRule rule) {
        if (rule.isBroken()) {
            throw new BusinessRuleValidationException(rule);
        }
    }
}