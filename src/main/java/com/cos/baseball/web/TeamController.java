package com.cos.baseball.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cos.baseball.domain.stadium.Stadium;
import com.cos.baseball.domain.team.Team;
import com.cos.baseball.service.StadiumService;
import com.cos.baseball.service.TeamService;
import com.cos.baseball.utils.Script;
import com.cos.baseball.web.dto.CMRespDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class TeamController {
	private final TeamService teamService;
	private final StadiumService stadiumService;
	@GetMapping("/team")
	public String findAll(Model model) {
		List<Team> teams = teamService.팀목록보기();
		
		model.addAttribute("teams", teams);
		//System.out.println(teams.get(0).getPlayers());
		return "team/list";
	}
	
	@GetMapping("/team/saveForm")
	public String saveForm(Model model) {
		List<Stadium> stadiums = stadiumService.구장목록보기();
		model.addAttribute("stadiums", stadiums);
		return "team/saveForm";
	}
	
	
	@PostMapping("/team")
	public @ResponseBody String save(Team team) {
		teamService.팀등록(team);
		//System.out.println(team.getPlayers());
		//team.getId()
		return Script.href("등록성공", "/team");
	}
	
	@DeleteMapping("/team/{id}")
	public @ResponseBody CMRespDto<?> delete(@PathVariable int id) {
		System.out.println(id);
		teamService.삭제하기(id);
		return new CMRespDto<>(1, null);
	}
}
