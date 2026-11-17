package com.ong.acolhepatinhas.api.player;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ong.acolhepatinhas.api.player.dto.NewPlayer;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor 
@Transactional(readOnly = true)
public class PlayerService {
    
    private final PlayerRepository playerRepository;



    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    public Player getPlayerById(int playerId) {
        return playerRepository.findById(playerId)
                .orElseThrow(() -> new RuntimeException("Player not found with id: " + playerId));
    }

    public List<Player> getPlayersByNationality(String nationality) {
        return playerRepository.findByNationality(nationality);
    }


    public Player newplayer(NewPlayer data) {
        Player player = Player.builder()
                .playerName(data.playerName())
                .age(data.age())
                .nationality(data.nationality())
                .club(data.club())
                .position(data.position())
                .overallRating(data.overallRating())
                .potentialRating(data.potentialRating())
                .matchesPlayed(data.matchesPlayed())
                .goals(data.goals())
                .assists(data.assists())
                .minutesPlayed(data.minutesPlayed())
                .marketValueMillionEur(data.marketValueMillionEur())
                .contractYearsLeft(data.contractYearsLeft())
                .injuryProne(data.injuryProne())
                .transferRiskLevel(data.transferRiskLevel())
                .build();

        playerRepository.save(player);

        return player;  
    }
}
