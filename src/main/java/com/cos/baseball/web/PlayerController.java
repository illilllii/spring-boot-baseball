package com.cos.baseball.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cos.baseball.domain.player.Player;
import com.cos.baseball.domain.team.Team;
import com.cos.baseball.service.PlayerService;
import com.cos.baseball.service.TeamService;
import com.cos.baseball.utils.Script;
import com.cos.baseball.web.dto.CMRespDto;
import com.cos.baseball.web.dto.player.PlayerPositionRespDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class PlayerController {

	private final PlayerService playerService;
	private final TeamService teamServcie;
	@GetMapping({"/","/player"})
	public String findAll(Model model) {
		List<Player> players = playerService.선수목록보기();
		
		model.addAttribute("players", players);
		//playerService.포지션별선수목록보기();
		//System.out.println(playerService.포지션별선수목록보기());
		return "player/list";
	}
	
	@GetMapping("/player/saveForm")
	public String saveForm(Model model) {
		List<Team> teams = teamServcie.팀목록보기();
		model.addAttribute("teams", teams);
		return "player/saveForm";
	}
	
	@PostMapping("/player")
	public @ResponseBody String save(Player player) {
		playerService.선수등록(player);
		
		return Script.href("등록성공", "/player");
	}
	
	@DeleteMapping("/player/{id}")
	public @ResponseBody CMRespDto<?> delete(@PathVariable int id) {
		playerService.삭제하기(id);
		return new CMRespDto<>(1, null);
	}
	
	@GetMapping("/player/positionList")
	public String positionList(Model model) {
		List<PlayerPositionRespDto> dtos = playerService.포지션별선수목록보기();
		model.addAttribute("dtos", dtos);
		return "player/positionList";
	}
	
	
}
