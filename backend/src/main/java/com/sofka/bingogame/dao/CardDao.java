package com.sofka.bingogame.dao;

import com.sofka.bingogame.domain.Card;
import org.springframework.data.repository.CrudRepository;

public interface CardDao extends CrudRepository<Card, Integer> {
}
