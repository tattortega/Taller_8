package com.sofka.bingogame.service;


import com.sofka.bingogame.domain.Card;
import java.util.List;
import java.util.Optional;

/**
 * Interface of card
 *
 * @version 1.0.0 2022/03/13
 * @author Ricardo Ortega - tattortega.28@gmail.com
 * @since 1.0.0
 */
public interface ICardService {

    /**
     * Show one card
     * @param card Object
     * @return card
     */
    public Optional<Card> findCard(Card card);

    /**
     * Show all cards
     * @return List
     */
    public List<Card> list();

    /**
     * Save card
     * @param card Object
     * @return card
     */
    public Card save(Card card);

    /**
     * Update card
     * @param cardId Integer
     * @param card Object
     * @return card
     */
    public Card update(Integer cardId, Card card);

    /**
     * Delete card
     * @param card Object
     */
    public void delete(Card card);
}
