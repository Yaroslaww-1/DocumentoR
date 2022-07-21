package com.documentor.user.service.application.companyowners.register;

import an.awesome.pipelinr.Voidy;
import com.documentor.shared.application.cqrs.Command;
import lombok.Data;

@Data
public class RegisterCompanyOwnerCommand implements Command<Voidy> {
    final String name;
    final String email;
}
