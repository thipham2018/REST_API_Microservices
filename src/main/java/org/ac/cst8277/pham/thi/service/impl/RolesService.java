package org.ac.cst8277.pham.thi.service.impl;

import org.ac.cst8277.pham.thi.common.utils.ResponseUtils;
import org.ac.cst8277.pham.thi.dao.RolesRepository;
import org.ac.cst8277.pham.thi.dto.Roles;
import org.ac.cst8277.pham.thi.service.IRolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class RolesService implements IRolesService {

    @Autowired
    private RolesRepository rolesRepository;

    @Override
    public Mono<ResponseUtils<List<Roles>>> getAll() {
        return Mono.just(ResponseUtils.of(HttpStatus.OK, true, "Load role successful", rolesRepository.findAll()));
    }

    @Override
    public Mono<ResponseUtils<Roles>> getOne(UUID id) {
        Optional<Roles> opRole = rolesRepository.findById(id);
        return opRole.map(roles -> Mono.just(ResponseUtils.of(HttpStatus.OK, true, "Load role successful", roles))).orElseGet(() -> Mono.just(ResponseUtils.of(HttpStatus.OK, false, "Role not found", null)));
    }
}