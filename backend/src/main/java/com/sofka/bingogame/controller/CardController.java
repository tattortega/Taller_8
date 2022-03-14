package com.sofka.bingogame.controller;

import com.sofka.bingogame.domain.Card;
import com.sofka.bingogame.service.CardService;
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
public class CardController {

    @Autowired
    private CardService cardService;
    private Response response = new Response();


    /**
     * GET Route all cards
     * @return List cards
     */
    @GetMapping(path = "/cards")
    public Response list() {
        try {
            response.data = cardService.list();
        } catch (Exception exc) {
            response.error = true;
            response.message = exc.getMessage();
            response.status = "ERROR 404, NOT FOUND";
        }
        return response;
    }

    /**
     * GET Route one card
     * @param card Object
     * @param cardId Id Object
     * @return player
     */
    @GetMapping(path = "/card/{id}")
    public Response findCard(Card card, @PathVariable("id") Integer cardId){
        try {
            log.info("Tarjeta a encontrar: {}", card);
            response.data = cardService.findCard(card);
        } catch (Exception exc) {
            response.error = true;
            response.message = exc.getMessage();
            response.status = "ERROR 404, NOT FOUND";
        }
        return response;
    }

    /**
     * POST Route add card
     * @param card Object
     * @return card
     */
    @PostMapping(path= ("/card"))
    public ResponseEntity<Response> create(@RequestBody Card card){
        response.data = card;
        try {
            log.info("Tarjeta a crear: {}", card);
            cardService.save(card);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (Exception exc) {
            response.status = exc.getCause().toString();
            response.error = true;
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * DELETE Route delete card
     * @param card Object
     * @return
     */
    @DeleteMapping(path= ("/card/{id}"))
    public ResponseEntity<Card> delete(Card card){
        try {
            log.info("Tarjeta a borrar: {}", card);
            cardService.delete(card);
            return new ResponseEntity<>(card, HttpStatus.OK);
        } catch (Exception exc) {
            response.status = exc.getCause().toString();
            response.error = true;
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * PUT Route update card
     * @param card Object
     * @param cardId Id Object
     * @return contact
     */
    @PutMapping(path= ("/card/{id}"))
    public ResponseEntity<Card> update(@RequestBody Card card, @PathVariable("id") Integer cardId){
        try {
            log.info("Tarjeta a actualizar: {}", card);
            cardService.update(cardId, card);
            return new ResponseEntity<>(card, HttpStatus.OK);
        } catch (Exception exc) {
            response.status = exc.getCause().toString();
            response.error = true;
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
