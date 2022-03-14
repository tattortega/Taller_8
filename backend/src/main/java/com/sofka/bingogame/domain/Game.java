package com.sofka.bingogame.domain;

import lombok.Data;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;


/**
 * Object Relational Mapping (ORM)
 *
 * @version 1.0.0 2022/03/13
 * @author Ricardo Ortega - tattortega.28@gmail.com
 * @since 1.0.0
 */
@Data
@Entity
@Table(name = "game_bingo")
public class Game implements Serializable {

    private static final long serialVersionUID= 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "game_id")
    private Integer gameId;

    @Column(name = "game_winner")
    private String gameWinner;

    @Column(name = "game_ballot")
    private Integer gameBallot;

    @Column(name = "game_status")
    private Boolean gameStatus;

    @Column(name = "game_created_at")
    private Date created_at;
}
