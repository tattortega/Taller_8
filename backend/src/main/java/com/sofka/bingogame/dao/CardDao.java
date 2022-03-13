package com.sofka.bingogame.dao;

import com.sofka.bingogame.domain.Card;
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
public interface CardDao extends CrudRepository<Card, Integer> {

    /**
     * Update cardBallot
     * @param cardId Integer
     * @param cardBallot String
     */
    @Modifying
    @Query("update Card ca set ca.cardBallot = :cardBallot where ca.cardId = :cardId")
    public  void updateCardBallot(
            @Param(value = "cardId") Integer cardId,
            @Param(value = "cardBallot") Integer cardBallot
    );
}
