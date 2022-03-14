package com.sofka.bingogame.controller;

import com.sofka.bingogame.domain.Game;
import com.sofka.bingogame.service.GameService;
import com.sofka.bingogame.util.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Routes CRUD
 *
 * @version 1.0.0 2022/03/13
 * @author Ricardo Ortega - tattortega.28@gmail.com
 * @since 1.0.0
 */
@Slf4j
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class GameController {

    @Autowired
    private GameService gameService;
    private Response response = new Response();


    /**
     * GET Route all games
     * @return List games
     */
    @GetMapping(path = "/games")
    public Response list() {
        try {
            response.data = gameService.list();
        } catch (Exception exc) {
            response.error = true;
            response.message = exc.getMessage();
            response.status = "ERROR 404, NOT FOUND";
        }
        return response;
    }

    /**
     * GET Route one game
     * @param game Object
     * @param gameId Id Object
     * @return game
     */
    @GetMapping(path = "/game/{id}")
    public Response findGame(Game game, @PathVariable("id") Integer gameId){
        try {
            log.info("Juego a encontrar: {}", game);
            response.data = gameService.findGame(game);
        } catch (Exception exc) {
            response.error = true;
            response.message = exc.getMessage();
            response.status = "ERROR 404, NOT FOUND";
        }
        return response;
    }

    /**
     * POST Route add gae
     * @param game Object
     * @return game
     */
    @PostMapping(path= ("/game"))
    public ResponseEntity<Response> create(@RequestBody Game game){
        response.data = game;
        try {
            log.info("Juego a crear: {}", game);
            gameService.save(game);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (Exception exc) {
            response.status = exc.getCause().toString();
            response.error = true;
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * DELETE Route delete game
     * @param game Object
     * @return
     */
    @DeleteMapping(path= ("/game/{id}"))
    public ResponseEntity<Game> delete(Game game){
        try {
            log.info("Juego a borrar: {}", game);
            gameService.delete(game);
            return new ResponseEntity<>(game, HttpStatus.OK);
        } catch (Exception exc) {
            response.status = exc.getCause().toString();
            response.error = true;
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * PUT Route update GAME
     * @param game Object
     * @param gameId Id Object
     * @return contact
     */
    @PutMapping(path= ("/game/{id}"))
    public ResponseEntity<Game> update(@RequestBody Game game, @PathVariable("id") Integer gameId){
        try {
            log.info("Juego a actualizar: {}", game);
            gameService.update(gameId, game);
            return new ResponseEntity<>(game, HttpStatus.OK);
        } catch (Exception exc) {
            response.status = exc.getCause().toString();
            response.error = true;
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
