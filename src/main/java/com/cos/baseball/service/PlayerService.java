package com.cos.baseball.service;

import java.util.List;

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
		return playerRepository.findPlayerPosition();
	}
}
