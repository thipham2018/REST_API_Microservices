package org.ac.cst8277.pham.thi.dao;

import org.ac.cst8277.pham.thi.dto.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<Users, UUID> {

    Users findByEmail(String email);

}
