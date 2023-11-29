package org.ac.cst8277.pham.thi.dto;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private UUID id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "created")
    private Long created = new Date().getTime()/1000;

    @Column(name = "last_visit_id")
    private UUID lastVisitId;

    @Transient
    private List<Roles> roles;
}
