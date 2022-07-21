package com.documentor.user.service.api.controllers.users;

import an.awesome.pipelinr.Pipeline;
import com.documentor.user.service.api.controllers.companyowners.RegisterCompanyOwnerRequest;
import com.documentor.user.service.application.companyowners.register.RegisterCompanyOwnerCommand;
import com.documentor.user.service.application.users.getlist.GetListOfUsersQuery;
import com.documentor.user.service.application.users.getlist.GetListOfUsersResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
public class UsersController {
    private final Pipeline pipeline;

    @Autowired
    public UsersController(Pipeline pipeline) {
        this.pipeline = pipeline;
    }

    @GetMapping("")
    public ResponseEntity<GetListOfUsersResponse> get() {
        var resp = pipeline.send(new GetListOfUsersQuery());
        return ResponseEntity.ok(resp);
    }
}
