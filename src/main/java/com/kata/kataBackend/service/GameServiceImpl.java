package com.kata.kataBackend.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kata.kataBackend.repo.GameRepository;
import com.kata.kataBackend.DTO.GameDTO;
import com.kata.kataBackend.model.Game;
import com.kata.kataBackend.model.Player;
import com.kata.kataBackend.repo.PlayerRepository;

@Service
public class GameServiceImpl implements GameService{
	@Resource
	private GameRepository gameRepository;
	@Resource
	private PlayerRepository playerRepository;
	
	@Override
	@Transactional
	public GameDTO createGame(GameDTO gameDto) {
		Game game = new Game();
        mapDtoToEntity(gameDto, game);
        Game savedGame = gameRepository.save(game);
        return mapEntityToDto(savedGame);
	}
    @Override
	@Transactional
	public List<GameDTO> getGames() {
		List<Game> listGame = gameRepository.findAll();
		List<GameDTO> listGameDto= new ArrayList<GameDTO>();
		 listGame.forEach(game ->{GameDTO gameDto= mapEntityToDto(game);
		 listGameDto.add(gameDto);
		 });
		return listGameDto;
	}

	@Override
	@Transactional
	public GameDTO updateGame(Integer id, GameDTO gameDto) {
		Game game = gameRepository.getOne(id);
    	mapDtoToEntity(gameDto, game);
        Game gme = gameRepository.save(game);
        return mapEntityToDto(gme);
	}
	
	@Override
	@Transactional
	public GameDTO getPlayerById(Integer id) {
		Game game = gameRepository.getOne(id);
		return mapEntityToDto(game);
	}
	
	private GameDTO mapEntityToDto(Game savedGame) {
		GameDTO responseDto = new GameDTO();
		responseDto.setId(savedGame.getId());
		responseDto.setGameName(savedGame.getGameName());
    	responseDto.setGameStatus(savedGame.getGameStatus());
    	responseDto.setCreated(savedGame.getCreated());
    	responseDto.setFirstPlayer(savedGame.getFirstPlayer().getId());
    	responseDto.setSecondPlayer(savedGame.getSecondPlayer().getId());
        return responseDto;
	}

	private void mapDtoToEntity(GameDTO gameDto, Game game) {
		game.setSecondPlayer(playerRepository.findById(gameDto.getSecondPlayer()));
		game.setFirstPlayer(playerRepository.findById(gameDto.getFirstPlayer()));
		game.setGameName(gameDto.getGameName());
		game.setGameStatus(gameDto.getGameStatus());
		game.setCreated(gameDto.getCreated());
	}
	


}
