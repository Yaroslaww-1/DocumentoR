package com.documentor.shared.domain;

public interface BusinessRule {
    boolean isBroken();
    String message();
}
