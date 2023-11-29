package org.ac.cst8277.pham.thi.dto;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Data
@Entity
@Table(name = "last_visit")
public class LastVisit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "`in`")
    private Long in = new Date().getTime()/1000;

    @Column(name = "`out`")
    private Long out;
}
