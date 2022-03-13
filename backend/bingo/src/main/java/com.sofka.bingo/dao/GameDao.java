package com.sofka.bingo.dao;

import com.sofka.bingo.domain.Game;
import org.springframework.data.repository.CrudRepository;

public interface GameDao extends CrudRepository<Game, Integer> {
}
