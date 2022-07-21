package com.documentor.user.service.application.companyowners.register;

import an.awesome.pipelinr.Command;
import an.awesome.pipelinr.Voidy;
import com.documentor.shared.application.cqrs.CommandHandler;
import com.documentor.user.service.domain.companyowners.CompanyOwner;
import com.documentor.user.service.domain.users.User;
import lombok.NonNull;
import org.springframework.stereotype.Component;

@Component
public class RegisterCompanyOwnerCommandHandler implements CommandHandler<RegisterCompanyOwnerCommand, Voidy> {
    @Override
    public Voidy handle(@NonNull RegisterCompanyOwnerCommand command) {
        var user = User.newInstance(command.name, command.email);
        var companyOwner = CompanyOwner.newInstance(user);
        return new Voidy();
    }
}
