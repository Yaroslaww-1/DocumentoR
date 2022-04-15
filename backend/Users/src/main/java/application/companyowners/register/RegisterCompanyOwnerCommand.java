package application.companyowners.register;

import an.awesome.pipelinr.Command;
import an.awesome.pipelinr.Voidy;

public record RegisterCompanyOwnerCommand(String name) implements Command<Voidy> {
}
