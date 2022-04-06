package com.kata.kataBackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kata.kataBackend.service.PlayerService;
import com.kata.kataBackend.DTO.PlayerDTO;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class PlayerController {
	@Autowired
    private PlayerService playerService;
	@PostMapping("/addPlayer")
    public ResponseEntity<PlayerDTO> createPlayer(@RequestBody PlayerDTO playerDto) {
		return null;
	}
	 @GetMapping("/getPlayer/{id}")
	    public PlayerDTO getPlayerById(@PathVariable(name = "id") Integer id) {
	    	return null;
	    }

}
