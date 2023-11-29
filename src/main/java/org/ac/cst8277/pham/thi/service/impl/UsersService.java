package org.ac.cst8277.pham.thi.service.impl;

import org.ac.cst8277.pham.thi.common.utils.ResponseUtils;
import org.ac.cst8277.pham.thi.config.security.CustomOAuth2User;
import org.ac.cst8277.pham.thi.config.security.CustomOAuth2UserService;
import org.ac.cst8277.pham.thi.config.security.UserManagementService;
import org.ac.cst8277.pham.thi.dao.RolesRepository;
import org.ac.cst8277.pham.thi.dao.UserHasRoleRepository;
import org.ac.cst8277.pham.thi.dao.UserRepository;
import org.ac.cst8277.pham.thi.dto.Roles;
import org.ac.cst8277.pham.thi.dto.UsersHasRoles;
import org.ac.cst8277.pham.thi.dto.Users;
import org.ac.cst8277.pham.thi.service.IUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.*;

@Service
public class UsersService implements IUsersService {

    @Autowired
    private UserManagementService userManagementService;

    @Autowired
    private RolesRepository rolesRepository;

    @Autowired
    private RolesService roleService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserHasRoleRepository userHasRoleRepository;

    @Override
    public Mono<ResponseUtils<List<Users>>> getAll() {
        List<Users> users = userRepository.findAll();
        if(users.size() > 0){
            users.forEach((el) -> {
                el.setRoles(userHasRoleRepository.selectRoleByUser(el.getId()));
            });
        }else{
            return Mono.just(ResponseUtils.of(HttpStatus.OK, false, "Data empty", users));
        }
        return Mono.just(ResponseUtils.of(HttpStatus.OK, true, "Load user successful", users));
    }

    @Override
    public Mono<ResponseUtils<Users>> getInfo() {
        Users userInfo = userManagementService.getSessionLogin();
        userInfo.setRoles(userHasRoleRepository.selectRoleByUser(userInfo.getId()));
        return Mono.just(ResponseUtils.of(HttpStatus.OK, true, "Load user successful", userInfo));
    }

    @Override
    public Mono<ResponseUtils<Users>> getOne(UUID id) {
        Optional<Users> opUser = userRepository.findById(id);
        if(!opUser.isPresent()) return Mono.just(ResponseUtils.of(HttpStatus.OK, false, "User not found", null));
        Users userInfo = opUser.get();
        userInfo.setRoles(userHasRoleRepository.selectRoleByUser(userInfo.getId()));
        return Mono.just(ResponseUtils.of(HttpStatus.OK, true, "Load user successful", userInfo));
    }

    @Override
    public Mono<ResponseUtils<Users>> add(Users user) {
        Users userInfo = userRepository.findByEmail(user.getEmail());
        if(userInfo != null) return Mono.just(ResponseUtils.of(HttpStatus.OK, false, "Can't using this email", new Users()));

        String messageRole = "";
        Boolean checkStatus = true;
        userRepository.save(user);
        if(user.getRoles().size() > 0){
            for(Roles role : user.getRoles()){
                Optional<Roles> optRole = rolesRepository.findById(role.getId());
                if(optRole.isPresent()){
                    userHasRoleRepository.save(new UsersHasRoles(user, role));
                }else{
                    messageRole = "[Role not found]";
                    checkStatus = false;
                }
            }
        }
        return Mono.just(ResponseUtils.of(HttpStatus.OK, checkStatus, "Create user successful "+messageRole, user));
    }

    @Override
    public Mono<ResponseUtils<Users>> delete(UUID id) {
        Optional<Users> opUser = userRepository.findById(id);
        if(opUser.isPresent()){
            userHasRoleRepository.deleteByUserId(id);
            userRepository.deleteById(id);
            return Mono.just(ResponseUtils.of(HttpStatus.OK, true, "Delete user successful", new Users()));
        }
        return Mono.just(ResponseUtils.of(HttpStatus.OK, false, "Account unavailable", new Users()));
    }
}
