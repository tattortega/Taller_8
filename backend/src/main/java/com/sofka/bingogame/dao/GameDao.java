package com.sofka.bingogame.dao;

import com.sofka.bingogame.domain.Game;
import org.springframework.data.repository.CrudRepository;

public interface GameDao extends CrudRepository<Game, Integer> {
}
