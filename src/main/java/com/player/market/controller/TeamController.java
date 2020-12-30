package com.player.market.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.player.market.model.Team;
import com.player.market.service.PlayerMarketService;

@RestController
public class TeamController {

	@Autowired
	PlayerMarketService playerMarketService;

	@GetMapping(path = "/team")
	public ResponseEntity<?> listTeams() {
		try {
			return ResponseEntity.ok(playerMarketService.getAllTeam());
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@PostMapping(path = "/team")
	public ResponseEntity<?> addTeam(@RequestBody Team team) {
		try {
			return ResponseEntity.ok(playerMarketService.createUpdateTeam(team));
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@PutMapping(path = "/team/{teamId}")
	public ResponseEntity<?> updateTeam(@PathVariable Long teamId, @RequestBody Team team) {
		try {
			return ResponseEntity.ok(playerMarketService.createUpdateTeam(team));
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@DeleteMapping(path = "/team/{teamId}")
	public ResponseEntity<?> deleteTeam(@PathVariable Long teamId) {
		try {
			return ResponseEntity.ok(playerMarketService.deleteTeam(teamId));
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

}
