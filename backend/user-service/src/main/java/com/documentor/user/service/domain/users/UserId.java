package com.documentor.user.service.domain.users;

import lombok.NonNull;
import lombok.Value;

import java.util.UUID;

@Value
public class UserId {
    @NonNull UUID id;
}