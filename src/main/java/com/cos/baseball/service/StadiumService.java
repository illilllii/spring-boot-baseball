package com.cos.baseball.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.baseball.domain.stadium.Stadium;
import com.cos.baseball.domain.stadium.StadiumRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class StadiumService {
	private final StadiumRepository stadiumRepository;
	
	@Transactional(readOnly = true)
	public List<Stadium> 구장목록보기() {
		return stadiumRepository.findAll();
	}
	
	@Transactional
	public void 구장등록(Stadium stadium) {
		stadiumRepository.save(stadium);
	}
	
	@Transactional
	public void 삭제하기(int id) {
		stadiumRepository.deleteById(id);
	}
}
