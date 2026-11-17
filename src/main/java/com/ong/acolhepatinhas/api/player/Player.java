package com.ong.acolhepatinhas.api.player;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @Builder
@AllArgsConstructor @NoArgsConstructor
@Table(name = "players")
public class Player {
    
    @Id @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private int playerId;
    
    private String playerName;

    private Short age;

    private String nationality;

    private String club;

    private String position;

    private Short overallRating;

    private Short potentialRating;

    private Short matchesPlayed;

    private Short goals;

    private Short assists;

    private int minutesPlayed;

    private BigDecimal marketValueMillionEur;

    private Short contractYearsLeft;

    private String injuryProne;

    private String transferRiskLevel;
}
