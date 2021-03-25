package com.cos.baseball.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.baseball.domain.team.Team;
import com.cos.baseball.domain.team.TeamRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class TeamService {
	private final TeamRepository teamRepository;
	
	@Transactional(readOnly = true)
	public List<Team> 팀목록보기() {
		return teamRepository.findAll();
	}
	
	@Transactional
	public void 팀등록(Team team) {
		teamRepository.save(team);
		//playerRepository.findAll();
	}
	
	@Transactional
	public void 삭제하기(int id) {
		teamRepository.deleteById(id);
	}
}
