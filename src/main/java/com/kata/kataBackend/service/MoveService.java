package com.kata.kataBackend.service;

import java.util.List;

import com.kata.kataBackend.DTO.MoveDTO;

public interface MoveService {
	public MoveDTO addMove(MoveDTO moveDto);
	public List<MoveDTO> getMoves(Integer idGame);

}
