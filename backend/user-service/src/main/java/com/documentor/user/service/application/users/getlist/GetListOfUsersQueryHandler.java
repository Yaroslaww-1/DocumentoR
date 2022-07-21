package com.documentor.user.service.application.users.getlist;

import com.documentor.shared.application.cqrs.QueryHandler;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import java.util.List;

@Component
public class GetListOfUsersQueryHandler implements QueryHandler<GetListOfUsersQuery, GetListOfUsersResponse> {
    @Override
    public GetListOfUsersResponse handle(@NotNull GetListOfUsersQuery query) {
        return new GetListOfUsersResponse(
                List.of(
                    new GetListOfUsersResponse.GetListOfUsersResponseItem("Alex", "alex@gmail.com")
                )
        );
    }
}