package org.ac.cst8277.pham.thi.dto;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Data
@Entity
@Table(name = "users_has_roles")
@IdClass(UsersHasRoles.UsersHasRolesId.class)
public class UsersHasRoles {

    @Id
    @Column(name="users_id")
    private UUID usersId;

    @Id
    @Column(name="roles_id")
    private UUID rolesId;

    @Data
    public static class UsersHasRolesId implements Serializable {
        private UUID usersId;
        private UUID rolesId;
    }

    public UsersHasRoles() {
    }

    public UsersHasRoles(Users u, Roles r) {
        this.usersId = u.getId();
        this.rolesId = r.getId();
    }
}
