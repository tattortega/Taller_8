package com.sofka.bingogame.dao;

import com.sofka.bingo.domain.Ballot;
import org.springframework.data.repository.CrudRepository;

public interface BallotDao extends CrudRepository<Ballot, Integer> {
}
