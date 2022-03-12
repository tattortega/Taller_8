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
@Table(name = "user_has_game")
public class UserGame implements Serializable {

    private static final long serialVersionUID= 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_has_game_id")
    private Integer userGameId;

    @Column(name = "user_user_id")
    private Integer userId;

    @Column(name = "game_game_id")
    private Integer gameId;
}
