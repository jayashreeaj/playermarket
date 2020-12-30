package com.player.market.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.player.market.model.Player;
import com.player.market.model.PlayerTeamMapper;
import com.player.market.model.Team;
import com.player.market.service.PlayerMarketService;

@RestController
@RequestMapping(name = "/player")
public class PlayerController {

	@Autowired
	PlayerMarketService playerMarketService;


	@GetMapping(path = "/player")
	public ResponseEntity<?> listPlayers() {
		try {
			return ResponseEntity.ok(playerMarketService.getAllPlayers());
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@PostMapping(path = "/player")
	public ResponseEntity<?> addPlayer(@RequestBody Player player) {
		try {
			return ResponseEntity.ok(playerMarketService.createUpdatePlayer(player));
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@PutMapping(path = "/player/{playerId}")
	public ResponseEntity<?> updatePlayer(@PathVariable Long playerId, @RequestBody Player player) {
		try {
			return ResponseEntity.ok(playerMarketService.createUpdatePlayer(player));
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@DeleteMapping(path = "/player/{playerId}")
	public ResponseEntity<?> deletePlayer(@PathVariable Long playerId) {
		try {
			return ResponseEntity.ok(playerMarketService.deletePlayer(playerId));
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
}
