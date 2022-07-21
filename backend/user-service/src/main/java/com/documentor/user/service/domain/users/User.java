package com.documentor.user.service.domain.users;

import com.documentor.shared.domain.AggregateRoot;
import com.documentor.shared.domain.Entity;
import com.documentor.shared.domain.valueobjects.email.Email;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.experimental.Accessors;

import java.util.UUID;

@Accessors(fluent = true)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public final class User extends Entity implements AggregateRoot {
    @Getter
    @NonNull
    private final UserId id;

    @Getter
    @NonNull
    private String name;

    @Getter
    @NonNull
    private Email email;

    public static User newInstance(
            @NonNull String name,
            @NonNull String email
    ) {
        return new User(
                new UserId(UUID.randomUUID()),
                name,
                new Email(email));
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }
}

