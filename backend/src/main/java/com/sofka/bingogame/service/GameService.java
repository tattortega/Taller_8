package com.sofka.bingogame.service;

import com.sofka.bingogame.dao.GameDao;
import com.sofka.bingogame.domain.Game;
import com.sofka.bingogame.domain.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

/**
 * Services of game
 *
 * @version 1.0.0 2022/03/13
 * @author Ricardo Ortega - tattortega.28@gmail.com
 * @since 1.0.0
 */
public class GameService implements  IGameService{

    @Autowired
    private GameDao gameDao;

    /**
     * Shows one game
     * @param game Object
     * @return game
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<Game> findGame(Game game) {
        Optional<Game> games = Optional.empty();
        try {
            games = gameDao.findById(game.getGameId());
        } catch (Exception exc) {
            throw exc;
        }
        return games;
    }

    /**
     * Shows list games
     * @return list
     */
    @Override
    @Transactional(readOnly = true)
    public List<Game> list() {
        List<Game> games = null;
        try {
            games = (List<Game>) gameDao.findAll();
        } catch (Exception exc) {
            throw exc;
        }
        return games;
    }

    /**
     * Save game
     * @param game Object
     * @return game
     */
    @Override
    public Game save(Game game) {
        Game games = null;
        try {
            games = gameDao.save(game);
        } catch (Exception exc) {
            throw exc;
        }
        return games;
    }

    /**
     * Update game
     * @param gameId Integer
     * @param game Object
     * @return game
     */
    @Override
    public Game update(Integer gameId, Game game) {
        Game games = null;
        try {
            game.setGameId(gameId);
            games = gameDao.save(game);
        } catch (Exception exc) {
            throw exc;
        }
        return games;
    }

    /**
     * Delete game
     * @param game Object
     */
    @Override
    public void delete(Game game) {
        try {
            gameDao.delete(game);
        } catch (Exception exc) {
            throw exc;
        }
    }

    /**
     * Update winner game
     * @param gameId Long
     * @param game Object
     */
    @Transactional
    public void updateGameWinner(Integer gameId, Game game){
        try {
            gameDao.updateGameWinner(gameId, game.getGameWinner());
        } catch (Exception exc) {
            throw exc;
        }
    }

    /**
     * Update ballot game
     * @param gameId Long
     * @param game Object
     */
    @Transactional
    public void updateGameBallot(Integer gameId, Game game){
        try {
            gameDao.updateGameBallot(gameId, game.getGameBallot());
        } catch (Exception exc) {
            throw exc;
        }
    }

    /**
     * Update status game
     * @param gameId Long
     * @param game Object
     */
    @Transactional
    public void updateGameStatus(Integer gameId, Game game){
        try {
            gameDao.updateGameStatus(gameId, game.getGameStatus());
        } catch (Exception exc) {
            throw exc;
        }
    }
}
