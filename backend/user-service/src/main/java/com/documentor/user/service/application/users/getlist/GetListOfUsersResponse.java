package com.documentor.user.service.application.users.getlist;

import lombok.Data;

import java.util.List;

@Data
public final class GetListOfUsersResponse {
    private final List<GetListOfUsersResponseItem> items;

    @Data
    static final class GetListOfUsersResponseItem {
        private final String name;
        private final String email;
    }
}
