package com.ong.acolhepatinhas.api.player.dto;

import java.math.BigDecimal;

import com.ong.acolhepatinhas.api.player.Player;

public record PlayerResponse(

    int playerId,

    String playerName,

    int age,

    String nationality,

    String club,

    String position,

    int overallRating,

    int potentialRating,

    int matchesPlayed,

    int goals,

    int assists,

    int minutesPlayed,

    BigDecimal marketValueMillionEur,

    int contractYearsLeft,

    String injuryProne,

    String transferRiskLevel
) {

    public PlayerResponse(Player player) {
        this(
            player.getPlayerId(),
            player.getPlayerName(),
            player.getAge(),
            player.getNationality(),
            player.getClub(),
            player.getPosition(),
            player.getOverallRating(),
            player.getPotentialRating(),
            player.getMatchesPlayed(),
            player.getGoals(),
            player.getAssists(),
            player.getMinutesPlayed(),
            player.getMarketValueMillionEur(),
            player.getContractYearsLeft(),
            player.getInjuryProne(),
            player.getTransferRiskLevel()
        );
    }
}
