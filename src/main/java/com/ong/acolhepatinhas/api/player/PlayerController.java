package com.ong.acolhepatinhas.api.player;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ong.acolhepatinhas.api.player.dto.NewPlayer;
import com.ong.acolhepatinhas.api.player.dto.PlayerResponse;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController 
@RequiredArgsConstructor
@RequestMapping("/fifa")
@Tag(name = "Player", description = "Endpoints for managing players")
public class PlayerController {

    private final PlayerService playerService;

    
    @GetMapping
    public ResponseEntity<List<PlayerResponse>> getAllPlayers() {
        List<PlayerResponse> players = playerService.getAllPlayers().stream()
                .map(PlayerResponse::new)
                .toList();
        return ResponseEntity.ok(players);
    }

    @GetMapping("/id/{playerId}")
    public ResponseEntity<PlayerResponse> getPlayerById(@PathVariable int playerId) {
        Player player = playerService.getPlayerById(playerId);
        PlayerResponse playerResponse = new PlayerResponse(player);
        return ResponseEntity.ok(playerResponse);
    }

    @GetMapping("/count")
    public ResponseEntity<Integer> getPlayerCount() {
        int count = playerService.getAllPlayers().size();
        return ResponseEntity.ok(count);
    }


    @GetMapping("/nat/{exp}")
    public ResponseEntity<List<PlayerResponse>> getPlayersByNationality(@PathVariable String exp) {
        List<PlayerResponse> players = playerService.getAllPlayers().stream()
                .filter(player -> player.getNationality().equalsIgnoreCase(exp))
                .map(PlayerResponse::new)
                .toList();
        return ResponseEntity.ok(players);
    }


    @PostMapping
    public ResponseEntity<Player> createPlayer(@Valid @RequestBody NewPlayer data) {
        Player responseData = playerService.newplayer(data);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseData);
    }
    
}
