package com.kata.kataBackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.kata.kataBackend.service.GameService;
import com.kata.kataBackend.DTO.GameDTO;
import com.kata.kataBackend.DTO.PlayerDTO;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class GameController {
	
	@Autowired
	private GameService gameService;
	
	@PostMapping("/createGame")
    public ResponseEntity<GameDTO> createGame(@RequestBody GameDTO gameDto) {
    	GameDTO game = gameService.createGame(gameDto);
        return new ResponseEntity<>(game, HttpStatus.CREATED);
       }
    @PutMapping("/updateGame/{id}")
    public ResponseEntity<GameDTO> updateGame(@PathVariable(name = "id") Integer id,@RequestBody GameDTO gameDto) {
    	GameDTO game = gameService.updateGame(id,gameDto);
        return new ResponseEntity<>(game, HttpStatus.CREATED);
        
    }
    @GetMapping("/getListGame")
    public List<GameDTO> getGames() {
    	List<GameDTO> listGame = gameService.getGames();
        return listGame;
    }
    @GetMapping("/getGame/{id}")
    public GameDTO getGameById(@PathVariable(name = "id") Integer id) {
    	GameDTO game = gameService.getPlayerById(id);
        return game;
    }

}
