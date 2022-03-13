package com.sofka.bingogame.domain;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "card_has_ballot")
public class CardBallot implements Serializable {

    private static final long serialVersionUID= 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "card_has_ballot_id")
    private Integer cardBallotId;

    @Column(name = "card_card_id")
    private Integer cardId;

    @Column(name = "ballot_ballot_id")
    private Integer ballotId;
}
