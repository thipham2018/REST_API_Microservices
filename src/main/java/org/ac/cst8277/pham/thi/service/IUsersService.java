package org.ac.cst8277.pham.thi.service;

import org.ac.cst8277.pham.thi.common.utils.ResponseUtils;
import org.ac.cst8277.pham.thi.dto.Users;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.UUID;

public interface IUsersService {

    Mono<ResponseUtils<List<Users>>> getAll();

    Mono<ResponseUtils<Users>> getInfo();

    Mono<ResponseUtils<Users>> getOne(UUID id);

    Mono<ResponseUtils<Users>> add(Users user);

    Mono<ResponseUtils<Users>> delete(UUID id);
}
