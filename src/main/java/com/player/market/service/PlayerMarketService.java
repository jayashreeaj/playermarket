package com.player.market.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.player.market.dto.ContractFee;
import com.player.market.model.Player;
import com.player.market.model.PlayerTeamMapper;
import com.player.market.model.Team;
import com.player.market.repo.PlayerRepository;
import com.player.market.repo.PlayerTeamRepository;
import com.player.market.repo.TeamRepository;

@Component
public class PlayerMarketService {

	@Autowired
	TeamRepository teamRepository;

	@Autowired
	PlayerRepository playerRepository;

	@Autowired
	PlayerTeamRepository playerTeamRepository;

	public ArrayList<Player> getAllPlayers() {
		return (ArrayList<Player>) playerRepository.findAll();
	}

	public List<Player> findPlayerByIds(List<Long> ids) {
		return playerRepository.findAllById(ids);
	}

	public Optional<Player> findById(Long id) {
		return playerRepository.findById(id);
	}

	public Player createUpdatePlayer(Player p) {
		return playerRepository.save(p);
	}

	public String deletePlayer(Long id) {
		playerRepository.deleteById(id);
		return "Player Deleted Successfully ";
	}

	public List<Team> getAllTeam() {
		return teamRepository.findAll();
	}

	public Team createUpdateTeam(Team t) {
		return teamRepository.save(t);
	}

	public String deleteTeam(Long id) {
		teamRepository.deleteById(id);
		return "Team Deleted Successfully ";
	}

	public List<PlayerTeamMapper> getAllPlayerTeamMappings() {
		return playerTeamRepository.findAll();
	}

	public PlayerTeamMapper createUpdatePlayerTeam(PlayerTeamMapper t) {
		return playerTeamRepository.save(t);
	}

	public String deletePlayerTeamMapping(Long id) {
		teamRepository.deleteById(id);
		return "Player/Team Mapping Deleted Successfully ";
	}

	public List<Team> getTeamsByPlayerId(List<Long> playerIds) {
		return teamRepository.findAll(playerIds);
	}

	public Team getTeamByPlayerId(Long playerId) {
		return teamRepository.findByPlayerId(playerId);
	}
	
	public ContractFee playerContractFee(Long playerId) {
		Player player = playerRepository.findById(playerId).get();
		double transferFee = player.getTransferFee();
		PlayerTeamMapper pt = playerTeamRepository.findByPlayerId(playerId);
		Team team = teamRepository.findById(pt.getTeamId()).get();
		return new ContractFee(transferFee + (transferFee * team.getCommission()), team.getCurrency());
	}
}
