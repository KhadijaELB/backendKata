package com.kata.kataBackend.service;

import java.util.List;

import com.kata.kataBackend.DTO.GameDTO;

public interface GameService {
	public GameDTO createGame(GameDTO gameDto);
	public List<GameDTO> getGames();
	public GameDTO updateGame(Integer id,GameDTO gameDto);
	public GameDTO getPlayerById(Integer id);

}
