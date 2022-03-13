package com.sofka.bingogame.dao;

import com.sofka.bingogame.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserDao extends CrudRepository<User, Integer> {
}
