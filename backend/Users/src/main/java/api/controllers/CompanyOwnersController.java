package api.controllers;

import an.awesome.pipelinr.Pipeline;
import application.companyowners.register.RegisterCompanyOwnerCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/company-owners")
public class CompanyOwnersController {
    private final Pipeline pipeline;

    @Autowired
    public CompanyOwnersController(Pipeline pipeline) {
        this.pipeline = pipeline;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody() RegisterCompanyOwnerRequest request) {
        new RegisterCompanyOwnerCommand(request.name()).execute(pipeline);
        return ResponseEntity.ok().build();
    }
}
