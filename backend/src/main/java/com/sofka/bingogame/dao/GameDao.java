package com.sofka.bingogame.dao;

import com.sofka.bingogame.domain.Game;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 * Data Access Object (DAO)
 *
 * @version 1.0.0 2022/03/13
 * @author Ricardo Ortega - tattortega.28@gmail.com
 * @since 1.0.0
 */
public interface GameDao extends CrudRepository<Game, Integer> {

    /**
     * Update gameWinner
     * @param gameId Integer
     * @param gameWinner String
     */
    @Modifying
    @Query("update Game gm set gm.gameWinner = :gameWinner where gm.gameId = :gameId")
    public  void updateGameWinner(
            @Param(value = "gameId") Integer gameId,
            @Param(value = "gameWinner") String gameWinner
    );

    /**
     * Update gameStatus
     * @param gameId Integer
     * @param gameStatus String
     */
    @Modifying
    @Query("update Game gm set gm.gameStatus = :gameStatus where gm.gameId = :gameId")
    public  void updateGameStatus(
            @Param(value = "gameId") Integer gameId,
            @Param(value = "gameStatus") Boolean gameStatus
    );

    /**
     * Update gameWinner
     * @param gameId Integer
     * @param gameBallot String
     */
    @Modifying
    @Query("update Game gm set gm.gameBallot= :gameBallot where gm.gameId = :gameId")
    public  void updateGameBallot(
            @Param(value = "gameId") Integer gameId,
            @Param(value = "gameBallot") Integer gameBallot
    );

}
