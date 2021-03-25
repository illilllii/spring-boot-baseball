package com.cos.baseball.domain.player;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cos.baseball.web.dto.player.PlayerPositionRespDto;

public interface PlayerRepository extends JpaRepository<Player, Integer>{

	@Query(value = "select position,\r\n"
			+ "MAX(case when t.name = '롯데' then p.name end) as '롯데',\r\n"
			+ "	MAX(case when t.name='NC' then p.name end) as 'NC',\r\n"
			+ "	MAX(case when t.name='기아' then p.name end) as '기아',\r\n"
			+ "	MAX(case when t.name='해태' then p.name end) as '해태'\r\n"
			+ "from player p inner join team t where t.id=p.teamId group by position", nativeQuery = true)
	List<PlayerPositionRespDto> findPlayerPosition();
}
