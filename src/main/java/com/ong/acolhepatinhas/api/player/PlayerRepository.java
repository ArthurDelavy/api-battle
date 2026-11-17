package com.ong.acolhepatinhas.api.player;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository 
public interface PlayerRepository extends JpaRepository<Player, Integer> {
    List<Player> findByNationality(String nationality);
}
