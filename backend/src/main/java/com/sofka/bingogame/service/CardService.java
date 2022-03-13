package com.sofka.bingogame.service;

import com.sofka.bingogame.dao.CardDao;
import com.sofka.bingogame.domain.Card;
import com.sofka.bingogame.domain.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

/**
 * Services of card
 *
 * @version 1.0.0 2022/03/13
 * @author Ricardo Ortega - tattortega.28@gmail.com
 * @since 1.0.0
 */

public class CardService implements  ICardService{

    @Autowired
    private CardDao cardDao;

    /**
     * Shows one card
     * @param card Object
     * @return card
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<Card> findCard(Card card) {
        Optional<Card> cards = Optional.empty();
        try {
            cards = cardDao.findById(card.getCardId());
        } catch (Exception exc) {
            throw exc;
        }
        return cards;
    }

    /**
     * Shows list cards
     * @return list
     */
    @Override
    @Transactional(readOnly = true)
    public List<Card> list() {
        List<Card> cards = null;
        try {
            cards = (List<Card>) cardDao.findAll();
        } catch (Exception exc) {
            throw exc;
        }
        return cards;
    }

    /**
     * Save cards
     * @param card Object
     * @return card
     */
    @Override
    public Card save(Card card) {
        Card cards = null;
        try {
            cards = cardDao.save(card);
        } catch (Exception exc) {
            throw exc;
        }
        return cards;
    }

    /**
     * Update cards
     * @param cardId Integer
     * @param card Object
     * @return card
     */
    @Override
    public Card update(Integer cardId, Card card) {
        Card cards = null;
        try {
            card.setCardId(cardId);
            cards = cardDao.save(card);
        } catch (Exception exc) {
            throw exc;
        }
        return cards;
    }

    /**
     * Delete card
     * @param card Object
     */
    @Override
    public void delete(Card card) {
        try {
            cardDao.delete(card);
        } catch (Exception exc) {
            throw exc;
        }
    }

    /**
     * Update card ballot
     * @param cardId Long
     * @param card Object
     */
    @Transactional
    public void updateCardBallot(Integer cardId, Card card){
        try {
            cardDao.updateCardBallot(cardId, card.getCardBallot());
        } catch (Exception exc) {
            throw exc;
        }
    }
}
