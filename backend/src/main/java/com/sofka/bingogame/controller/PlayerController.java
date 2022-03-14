package com.sofka.bingogame.controller;

import com.sofka.bingogame.domain.Player;
import com.sofka.bingogame.service.PlayerService;
import com.sofka.bingogame.util.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
public class PlayerController {

    @Autowired
    private PlayerService playerService;
    private Response response = new Response();

    /**
     * GET Route index
     * @return String
     */
    @GetMapping(path = "/")
    public  String index(){
        return "API: Bingo";
    }

    /**
     * GET Route all players
     * @return List players
     */
    @GetMapping(path = "/players")
    public Response list() {
        try {
            response.data = playerService.list();
        } catch (Exception exc) {
            response.error = true;
            response.message = exc.getMessage();
            response.status = "ERROR 404, NOT FOUND";
        }
        return response;
    }

    /**
     * GET Route one player
     * @param player Object
     * @param playerId Id Object
     * @return player
     */
    @GetMapping(path = "/player/{playerId}")
    public Response findPlayer(Player player, @PathVariable("playerId") Integer playerId){
        try {
            log.info("Jugador a encontrar: {}", player);
            response.data = playerService.findPlayer(player);
            System.out.println(response.data);
        } catch (Exception exc) {
            response.error = true;
            response.message = exc.getMessage();
            response.status = "ERROR 404, NOT FOUND";
        }
        return response;
    }

    /**
     * POST Route add player
     * @param player Object
     * @return player
     */
    @PostMapping(path= ("/player"))
    public ResponseEntity<Response> create(@RequestBody Player player){
        response.data = player;
        try {
            log.info("Jugador a crear: {}", player);
            playerService.save(player);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (Exception exc) {
            response.status = exc.getCause().toString();
            response.error = true;
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * DELETE Route delete player
     * @param player Object
     * @return
     */
    @DeleteMapping(path= ("/player/{id}"))
    public ResponseEntity<Player> delete(Player player){
        try {
            log.info("Jugador a borrar: {}", player);
            playerService.delete(player);
            return new ResponseEntity<>(player, HttpStatus.OK);
        } catch (Exception exc) {
            response.status = exc.getCause().toString();
            response.error = true;
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * PUT Route update contact
     * @param player Object
     * @param playerId Id Object
     * @return contact
     */
    @PutMapping(path= ("/player/{playerId}"))
    public ResponseEntity<Player> update(@RequestBody Player player, @PathVariable("playerId") Integer playerId){
        try {
            log.info("Jugador a actualizar: {}", player);
            playerService.update(playerId, player);
            return new ResponseEntity<>(player, HttpStatus.OK);
        } catch (Exception exc) {
            response.status = exc.getCause().toString();
            response.error = true;
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
