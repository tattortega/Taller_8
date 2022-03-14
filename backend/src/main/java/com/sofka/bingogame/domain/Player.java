package com.sofka.bingogame.domain;

import lombok.Data;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Object Relational Mapping (ORM)
 *
 * @version 1.0.0 2022/03/13
 * @author Ricardo Ortega - tattortega.28@gmail.com
 * @since 1.0.0
 */
@Data
@Entity
@Table(name = "player_bingo")
public class Player implements Serializable {

    private static final long serialVersionUID= 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "player_id")
    private Integer playerId;

    @Column(name = "player_name")
    private String playerName;

    @Column(name = "player_status")
    private Boolean playerStatus;

    @Column(name = "game_bingo_game_id")
    private Integer gameId;

    @Column(name = "card_bingo_card_id")
    private Integer cardId;
}
