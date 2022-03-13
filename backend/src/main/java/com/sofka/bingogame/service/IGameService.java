package com.sofka.bingogame.service;

import com.sofka.bingogame.domain.Game;
import java.util.List;
import java.util.Optional;

/**
 * Interface of game
 *
 * @version 1.0.0 2022/03/13
 * @author Ricardo Ortega - tattortega.28@gmail.com
 * @since 1.0.0
 */
public interface IGameService {

    /**
     * Show one game
     * @param game Object
     * @return game
     */
    public Optional<Game> findGame(Game game);

    /**
     * Show all games
     * @return List
     */
    public List<Game> list();

    /**
     * Save game
     * @param game Object
     * @return game
     */
    public Game save(Game game);

    /**
     * Update game
     * @param gameId Integer
     * @param game Object
     * @return game
     */
    public Game update(Integer gameId, Game game);

    /**
     * Delete players
     * @param game Object
     */
    public void delete(Game game);
}
