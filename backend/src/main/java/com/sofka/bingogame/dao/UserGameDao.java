package com.sofka.bingogame.dao;

import com.sofka.bingo.domain.UserGame;
import org.springframework.data.repository.CrudRepository;

public interface UserGameDao extends CrudRepository<UserGame, Integer> {
}
