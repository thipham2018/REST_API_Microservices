package org.ac.cst8277.pham.thi.dao;

import org.ac.cst8277.pham.thi.dto.Roles;
import org.ac.cst8277.pham.thi.dto.UsersHasRoles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

public interface UserHasRoleRepository extends JpaRepository<UsersHasRoles, Integer> {

    @Query("SELECT r " +
            " FROM UsersHasRoles uhr " +
            " INNER JOIN Roles r ON uhr.rolesId = r.id " +
            " WHERE uhr.usersId = :id ")
    List<Roles> selectRoleByUser(UUID id);

    @Modifying
    @Transactional
    @Query("DELETE FROM UsersHasRoles WHERE usersId = :usersId")
    void deleteByUserId(UUID usersId);
}
