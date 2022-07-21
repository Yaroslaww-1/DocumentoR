package com.documentor.user.service.api.controllers.companyowners;

import an.awesome.pipelinr.Pipeline;
import an.awesome.pipelinr.Voidy;
import com.documentor.user.service.application.companyowners.register.RegisterCompanyOwnerCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/company-owners")
public class CompanyOwnersController {
    private final Pipeline pipeline;

    @Autowired
    public CompanyOwnersController(Pipeline pipeline) {
        this.pipeline = pipeline;
    }

    @PostMapping("/register")
    public ResponseEntity<Voidy> register(@Valid @RequestBody() RegisterCompanyOwnerRequest request) {
        var resp = pipeline.send(new RegisterCompanyOwnerCommand(request.name(), request.email()));
        return ResponseEntity.ok(resp);
    }
}
