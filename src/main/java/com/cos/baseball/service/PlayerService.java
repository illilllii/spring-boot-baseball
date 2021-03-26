package com.cos.baseball.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.qlrm.mapper.JpaResultMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.baseball.domain.player.Player;
import com.cos.baseball.domain.player.PlayerRepository;
import com.cos.baseball.web.dto.player.PlayerPositionRespDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PlayerService {
	private final PlayerRepository playerRepository;
	private final EntityManager entityManager;
	
	@Transactional(readOnly = true)
	public List<Player> 선수목록보기() {
		return playerRepository.findAll();
	}
	
	@Transactional
	public void 선수등록(Player player) {
		playerRepository.save(player);
	}
	
	@Transactional
	public void 삭제하기(int id) {
		playerRepository.deleteById(id);
	}
	@Transactional(readOnly = true)
	public List<PlayerPositionRespDto> 포지션별선수목록보기() {
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT position, ");
		sb.append("MAX(if(teamId = 1, name, \"\")) LG, ");
		sb.append("MAX(if(teamId = 2, name, \"\")) LOTTE, ");
		sb.append("MAX(if(teamId = 3, name, \"\")) SAMSUNG ");
		sb.append("FROM player ");
		sb.append("GROUP BY position ");
		Query q = entityManager.createNativeQuery(sb.toString());
		JpaResultMapper result = new JpaResultMapper();
		List<PlayerPositionRespDto> playerPositionRespDto = result.list(q, PlayerPositionRespDto.class);
		
		return playerPositionRespDto;
	}

}
