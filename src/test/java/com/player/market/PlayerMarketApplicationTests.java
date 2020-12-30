package com.player.market;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.player.market.model.Player;
import com.player.market.model.PlayerTeamMapper;
import com.player.market.model.Team;
import com.player.market.service.PlayerMarketService;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)	
class PlayerMarketApplicationTests {

	@Autowired
	private PlayerMarketService playerMarketService;

	@Test
	public void whenplayeriscreted_thenretrivetheplayer() {
		Mockito.when(playerMarketService.getTeamByPlayerId(Long.valueOf(1)))
				.thenReturn(new Team(Long.valueOf(1), "AJROCKS", "INR", 10.0f));
		Team t = playerMarketService.getTeamByPlayerId(Long.valueOf(1));
		Assert.assertEquals("AJROCKS", t.getName());
		Assert.assertEquals(Long.valueOf(1), t.getId());
		Assert.assertEquals("INR", t.getCurrency());
		Assert.assertEquals(10.0f, t.getCommission());
		System.out.println("whenplayeriscreted_thenretrivetheplayer success");
	}


	@Test
	public void whenteamiscreted_thenretrivetheteam() {
		ArrayList<Player> plist=new ArrayList<Player>();
		plist.add(new Player(Long.valueOf(1), "JAY", new Date(1989,03,23), new Date(2010,12,9)));
		plist.add(new Player(Long.valueOf(1), "JAY", new Date(1991,07,21), new Date(2012,12,24)));
		Mockito.when(playerMarketService.getAllPlayers()).thenReturn(plist);
		ArrayList<Player> result = playerMarketService.getAllPlayers();
		Assert.assertEquals(2, result.size());
		System.out.println("whenteamiscreted_thenretrivetheteam:"+plist.toString());
	}

	@Test
	public void whenplayerismapped_thenretrivethemapping() {
		ArrayList<PlayerTeamMapper> plist=new ArrayList<PlayerTeamMapper>();
		plist.add(new PlayerTeamMapper(Long.valueOf(1), Long.valueOf(1),Long.valueOf(1)));
		plist.add(new PlayerTeamMapper(Long.valueOf(1), Long.valueOf(1),Long.valueOf(1)));
		Mockito.when(playerMarketService.getAllPlayerTeamMappings()).thenReturn(plist);
		ArrayList<Player> result = playerMarketService.getAllPlayers();
		Assert.assertEquals(2, result.size());
		System.out.println("whenteamiscreted_thenretrivetheteam:"+plist.toString());
	}

	@Test
	public void whenplayerismapped_thenretrivetheteambyplayerid() {
		ArrayList<Team> plist=new ArrayList<Team>();
		plist.add(new Team(Long.valueOf(1), "AJROCKS","INR",10.0f));
		plist.add(new Team(Long.valueOf(1), "AJROCKS","INR",10.0f));	
		Mockito.when(playerMarketService.getTeamsByPlayerId(new ArrayList<Long>(Arrays.asList(1L, 2L, 3L)))).thenReturn(plist);
		ArrayList<Team> result = (ArrayList<Team>) playerMarketService.getTeamsByPlayerId(new ArrayList<Long>(Arrays.asList(1L, 2L, 3L)));
		Assert.assertEquals(2, result.size());
		System.out.println("whenteamiscreted_thenretrivetheteam:"+plist.toString());
	}
}
