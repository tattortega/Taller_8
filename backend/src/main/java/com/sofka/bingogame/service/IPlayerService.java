package com.sofka.bingogame.service;

import com.sofka.bingogame.domain.Player;

import java.util.List;
import java.util.Optional;

/**
 * Interface of player
 *
 * @version 1.0.0 2022/03/13
 * @author Ricardo Ortega - tattortega.28@gmail.com
 * @since 1.0.0
 */
public interface IPlayerService {

    /**
     * Show one player
     * @param player Object
     * @return player
     */
    public Optional<Player> findPlayer(Player player);

    /**
     * Show all players
     * @return List
     */
    public List<Player> list();

    /**
     * Save players
     * @param player Object
     * @return player
     */
    public Player save(Player player);

    /**
     * Update player
     * @param playerId Integer
     * @param player Object
     * @return player
     */
    public Player update(Integer playerId, Player player);

    /**
     * Delete players
     * @param player Object
     */
    public void delete(Player player);
}
