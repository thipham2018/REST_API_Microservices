package org.ac.cst8277.pham.thi.dao;

import org.ac.cst8277.pham.thi.dto.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RolesRepository extends JpaRepository<Roles, UUID> {

}
