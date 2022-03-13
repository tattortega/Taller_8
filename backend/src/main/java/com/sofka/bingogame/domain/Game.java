package com.sofka.bingogame.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

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

    @Column(name = "game_crated_at")
    private Date created_at;
}
