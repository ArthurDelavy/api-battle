package com.ong.acolhepatinhas.api.player.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record NewPlayer(

    @NotBlank @Size(max = 100)
    String playerName,

    @NotNull 
    Short age,

    @NotBlank @Size(max = 100)
    String nationality,

    @NotBlank @Size(max = 100)
    String club,

    @NotBlank @Size(max = 100)
    String position,

    @NotNull
    Short overallRating,

    @NotNull
    Short potentialRating,

    @NotNull
    Short matchesPlayed,

    @NotNull
    Short goals,

    @NotNull
    Short assists,

    @NotNull
    int minutesPlayed,

    @NotNull 
    BigDecimal marketValueMillionEur,

    @NotNull
    Short contractYearsLeft,

    @NotBlank @Size(max = 5)
    String injuryProne,

    @NotBlank @Size(max = 100)
    String transferRiskLevel

) {
}
