package org.ac.cst8277.pham.thi.controller;

import org.ac.cst8277.pham.thi.common.utils.ResponseUtils;
import org.ac.cst8277.pham.thi.dto.Roles;
import org.ac.cst8277.pham.thi.service.IRolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/roles")
public class RolesController {

    @Autowired
    private IRolesService rolesService;

    @GetMapping("")
    public Mono<ResponseUtils<List<Roles>>> getAll(){
        return rolesService.getAll();
    }

    @GetMapping("/{id}")
    public Mono<ResponseUtils<Roles>> getOne(@PathVariable("id") UUID id){
        return rolesService.getOne(id);
    }
}
