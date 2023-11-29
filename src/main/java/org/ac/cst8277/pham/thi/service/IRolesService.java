package org.ac.cst8277.pham.thi.service;

import org.ac.cst8277.pham.thi.common.utils.ResponseUtils;
import org.ac.cst8277.pham.thi.dto.Roles;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.UUID;

public interface IRolesService {

    Mono<ResponseUtils<List<Roles>>> getAll();

    Mono<ResponseUtils<Roles>> getOne(UUID id);
}
