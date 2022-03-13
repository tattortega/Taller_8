package com.sofka.bingogame.service;

import com.sofka.bingogame.dao.PlayerDao;
import com.sofka.bingogame.domain.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

/**
 * Services of player
 *
 * @version 1.0.0 2022/03/13
 * @author Ricardo Ortega - tattortega.28@gmail.com
 * @since 1.0.0
 */
public class PlayerService implements IPlayerService{

    @Autowired
    private PlayerDao playerDao;

    /**
     * Shows one player
     * @param player Object
     * @return player
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<Player> findPlayer(Player player) {
        Optional<Player> players = Optional.empty();
        try {
            players = playerDao.findById(player.getPlayerId());
        } catch (Exception exc) {
            throw exc;
        }
        return players;
    }

    /**
     * Shows list players
     * @return list
     */
    @Override
    @Transactional(readOnly = true)
    public List<Player> list() {
        List<Player> players = null;
        try {
            players = (List<Player>) playerDao.findAll();
        } catch (Exception exc) {
            throw exc;
        }
        return players;
    }

    /**
     * Save contact
     * @param player Object
     * @return player
     */
    @Override
    public Player save(Player player) {
        Player players = null;
        try {
            players = playerDao.save(player);
        } catch (Exception exc) {
            throw exc;
        }
        return players;
    }

    /**
     * Update player
     * @param playerId Integer
     * @param player Object
     * @return player
     */
    @Override
    public Player update(Integer playerId, Player player) {
        Player players = null;
        try {
            player.setPlayerId(playerId);
            players = playerDao.save(player);
        } catch (Exception exc) {
            throw exc;
        }
        return players;
    }

    /**
     * Delete player
     * @param player Object
     */
    @Override
    public void delete(Player player) {
        try {
            playerDao.delete(player);
        } catch (Exception exc) {
            throw exc;
        }
    }

    /**
     * Update name of player
     * @param playerId Long
     * @param player Object
     */
    @Transactional
    public void updatePlayer(Integer playerId, Player player){
        try {
            playerDao.updatePlayer(playerId, player.getPlayer());
        } catch (Exception exc) {
            throw exc;
        }
    }

    /**
     * Update status player
     * @param playerId Long
     * @param player Object
     */
    @Transactional
    public void updatePlayerStatus(Integer playerId, Player player){
        try {
            playerDao.updatePlayerStatus(playerId, player.getPlayerStatus());
        } catch (Exception exc) {
            throw exc;
        }
    }

    /**
     * Update game player
     * @param playerId Long
     * @param player Object
     */
    @Transactional
    public void updatePlayerGameId(Integer playerId, Player player){
        try {
            playerDao.updateGameId(playerId, player.getGameId());
        } catch (Exception exc) {
            throw exc;
        }
    }

    /**
     * Update card player
     * @param playerId Long
     * @param player Object
     */
    @Transactional
    public void updatePlayerCardId(Integer playerId, Player player){
        try {
            playerDao.updateCardId(playerId, player.getCardId());
        } catch (Exception exc) {
            throw exc;
        }
    }
}
