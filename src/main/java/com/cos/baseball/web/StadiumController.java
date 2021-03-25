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
import com.cos.baseball.service.StadiumService;
import com.cos.baseball.utils.Script;
import com.cos.baseball.web.dto.CMRespDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class StadiumController {
	private final StadiumService stadiumService;
	//private final TeamService teamServcie;
	
	@GetMapping("/stadium")
	public String findAll(Model model) {
		List<Stadium> stadiums = stadiumService.구장목록보기();
		
		model.addAttribute("stadiums", stadiums);
		return "stadium/list";
	}
	
	@GetMapping("/stadium/saveForm")
	public String saveForm(Model model) {

		return "stadium/saveForm";
	}
	
	@PostMapping("/stadium")
	public @ResponseBody String save(Stadium stadium) {
		stadiumService.구장등록(stadium);
		return Script.href("등록성공", "/stadium");
	}
	
	@DeleteMapping("/stadium/{id}")
	public @ResponseBody CMRespDto<?> delete(@PathVariable int id) {
		stadiumService.삭제하기(id);
		return new CMRespDto<>(1, null);
	}
}

