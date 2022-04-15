package application.companyowners.register;

import an.awesome.pipelinr.Command;
import an.awesome.pipelinr.Voidy;
import domain.companyowners.CompanyOwner;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor(access = AccessLevel.PACKAGE)
@Component
public class RegisterCompanyOwnerCommandHandler implements Command.Handler<RegisterCompanyOwnerCommand, Voidy> {
    @Override
    public Voidy handle(RegisterCompanyOwnerCommand command) {
        var companyOwner = CompanyOwner.CreateNew(command.name());
        return new Voidy();
    }
}
