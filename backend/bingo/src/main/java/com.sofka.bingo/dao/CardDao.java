package com.sofka.bingo.dao;

import com.sofka.bingo.domain.Card;
import org.springframework.data.repository.CrudRepository;

public interface CardDao extends CrudRepository<Card, Integer> {
}
