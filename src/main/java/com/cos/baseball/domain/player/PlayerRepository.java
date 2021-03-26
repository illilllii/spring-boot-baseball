package com.cos.baseball.domain.player;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cos.baseball.web.dto.player.PlayerPositionRespDto;

public interface PlayerRepository extends JpaRepository<Player, Integer>{

	
}
