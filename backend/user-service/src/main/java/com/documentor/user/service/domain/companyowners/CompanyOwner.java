package com.documentor.user.service.domain.companyowners;

import com.documentor.shared.domain.AggregateRoot;
import com.documentor.shared.domain.Entity;
import com.documentor.user.service.domain.users.User;
import com.documentor.user.service.domain.users.UserId;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.experimental.Accessors;

import java.util.UUID;

@Accessors(fluent = true)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public final class CompanyOwner extends Entity implements AggregateRoot {
    @NonNull
    private final CompanyOwnerId id;

    @NonNull
    private UserId userId;

    public static CompanyOwner newInstance(
            @NonNull User user
    ) {
        return new CompanyOwner(
                new CompanyOwnerId(UUID.randomUUID()),
                user.id());
    }
}

