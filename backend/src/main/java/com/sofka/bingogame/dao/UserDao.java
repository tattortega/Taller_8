package com.sofka.bingogame.dao;

import com.sofka.bingo.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserDao extends CrudRepository<User, Integer> {
}
