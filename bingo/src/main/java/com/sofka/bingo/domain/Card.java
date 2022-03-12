package com.sofka.bingo.domain;


import lombok.Data;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table(name = "card")
public class Card implements Serializable {

    private static final long serialVersionUID= 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "card_id")
    private Integer carId;

    @Column(name = "game_game_id")
    private Integer gameId;

    @Column(name = "card_row")
    private Integer row;

    @Column(name = "card_column")
    private Integer column;
}
