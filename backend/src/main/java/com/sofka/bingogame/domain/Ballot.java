package com.sofka.bingogame.domain;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "ballot")
public class Ballot implements Serializable {

    private static final long serialVersionUID= 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ballot_id")
    private Integer ballotId;

    @Column(name = "ballot_number")
    private Integer ballotNumber;
}
