package com.kata.kataBackend.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kata.kataBackend.repo.MoveRepository;
import com.kata.kataBackend.DTO.MoveDTO;
import com.kata.kataBackend.model.Move;
import com.kata.kataBackend.repo.GameRepository;
import com.kata.kataBackend.repo.PlayerRepository;



@Service
public class MoveServiceImpl implements MoveService {
	@Resource
	private MoveRepository moveRepository;
	@Resource
	private GameRepository gameRepository;
	@Resource
	private PlayerRepository playerRepository;
	
	@Override
	@Transactional
	public MoveDTO addMove(MoveDTO moveDto) {
		Move move = new Move();
        mapDtoToEntity(moveDto, move);
        Move savedMove = moveRepository.save(move);
        return mapEntityToDto(savedMove);
	}
	
	@Override
	@Transactional
	public List<MoveDTO> getMoves(Integer idGame) {
		List<Move> listMove = moveRepository.findByGameId(idGame);
		List<MoveDTO> listMoveDto= new ArrayList<MoveDTO>();
		listMove.forEach(move ->{MoveDTO moveDto= mapEntityToDto(move);
		 listMoveDto.add(moveDto);
		 });
		return listMoveDto;
	}
	
	private MoveDTO mapEntityToDto(Move savedMove) {
		MoveDTO responseDto = new MoveDTO();
    	responseDto.setBoardColumn(savedMove.getBoardColumn());
    	responseDto.setBoardRow(savedMove.getBoardRow());
    	responseDto.setCreated(savedMove.getCreated());
    	responseDto.setGame(savedMove.getGame().getId());
    	responseDto.setPlayer(savedMove.getPlayer().getId());
        return responseDto;
	}

	private void mapDtoToEntity(MoveDTO moveDto, Move move) {
		move.setBoardColumn(moveDto.getBoardColumn());
		move.setBoardRow(moveDto.getBoardRow());
		move.setCreated(moveDto.getCreated());
		move.setGame(gameRepository.getById(moveDto.getGame()));
		move.setPlayer(playerRepository.getById(moveDto.getPlayer()));
	}
	
	
	

}

