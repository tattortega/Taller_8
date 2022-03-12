package com.sofka.bingo.dao;

import com.sofka.bingo.domain.CardBallot;
import org.springframework.data.repository.CrudRepository;

public interface CardBallotDao extends CrudRepository<CardBallot, Integer> {
}
