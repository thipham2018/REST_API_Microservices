package org.ac.cst8277.pham.thi.controller;

import org.ac.cst8277.pham.thi.common.utils.ResponseUtils;
import org.ac.cst8277.pham.thi.dto.Users;
import org.ac.cst8277.pham.thi.service.IUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private IUsersService usersService;

    @GetMapping("")
    public Mono<ResponseUtils<List<Users>>> getAll(){
        return usersService.getAll();
    }

    @GetMapping("/info")
    public Mono<ResponseUtils<Users>> getInfo(){
        return usersService.getInfo();
    }

    @GetMapping("/{id}")
    public Mono<ResponseUtils<Users>> getOne(@PathVariable("id") UUID id){
        return usersService.getOne(id);
    }

    @PostMapping("")
    public Mono<ResponseUtils<Users>> add(@RequestBody Users users){
        return usersService.add(users);
    }

    @DeleteMapping("/{id}")
    public Mono<ResponseUtils<Users>> delete(@PathVariable("id") UUID id){
        return usersService.delete(id);
    }
}
