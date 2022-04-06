package com.kata.kataBackend.service;

import com.kata.kataBackend.DTO.PlayerDTO;

public interface PlayerService {
	public PlayerDTO addPlayer(PlayerDTO playerDto);
	public PlayerDTO getPlayerById(Integer id);
}