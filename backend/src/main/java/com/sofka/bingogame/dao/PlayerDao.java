package com.sofka.bingogame.dao;

import com.sofka.bingogame.domain.Player;
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
public interface PlayerDao extends CrudRepository<Player, Integer> {

    /**
     * Update player
     * @param playerId Integer
     * @param playerName String
     */
    @Modifying
    @Query("update Player us set us.playerName = :playerName where us.playerId = :playerId")
    public  void updatePlayer(
            @Param(value = "playerId") Integer playerId,
            @Param(value = "playerName") String playerName
    );

    /**
     * Update playerStatus
     * @param playerId Long
     * @param playerStatus String
     */
    @Modifying
    @Query("update Player us set us.playerStatus = :playerStatus where us.playerId = :playerId")
    public  void updatePlayerStatus(
            @Param(value = "playerId") Integer playerId,
            @Param(value = "playerStatus") Boolean playerStatus
    );

    /**
     * Update gameId
     * @param playerId Long
     * @param gameId String
     */
    @Modifying
    @Query("update Player us set us.gameId = :gameId where us.playerId = :playerId")
    public  void updateGameId(
            @Param(value = "playerId") Integer playerId,
            @Param(value = "gameId") Integer gameId
    );

    /**
     * Update cardId
     * @param playerId Long
     * @param cardId String
     */
//    @Modifying
//    @Query("update Player us set us.cardId = :cardid where us.playerId = :playerId")
//    public void updateCardId(
//            @Param(value = "playerId") Integer playerId,
//            @Param(value = "cardId") Integer cardId
//    );

}
