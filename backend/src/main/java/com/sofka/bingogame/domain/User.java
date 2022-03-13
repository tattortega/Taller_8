package com.sofka.bingogame.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "player_bingo")
public class User implements Serializable {

    private static final long serialVersionUID= 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "player_id")
    private Integer playerId;

    @Column(name = "player_name")
    private String player;

    @Column(name = "player_status")
    private Boolean playerStatus;

    @Column(name = "game_bingo_game_id")
    private Integer gameId;

    @Column(name = "card_bingo_card_id")
    private Integer cardId;
}
