package com.kata.kataBackend.gameTests;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import com.kata.kataBackend.DTO.GameDTO;
import com.kata.kataBackend.enums.GameStatus;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GameControllerTest {
	
	@Autowired
    private TestRestTemplate testRestTemplate;
	
	@Test
    public void testCreateGame() {
		GameDTO game = new GameDTO();
		game.setGameName("tictactoe");
		game.setCreated(new Date());
		game.setFirstPlayer(1);
		game.setSecondPlayer(2);
		game.setGameStatus(GameStatus.IN_PROGRESS);
		
        ResponseEntity<GameDTO> postResponse = testRestTemplate.postForEntity("/api/v1/createGame", game, GameDTO.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
		
	}
	@Test
    public void testUpdateGame() {
		int id =1;
		GameDTO game = testRestTemplate.getForObject("/api/v1/getGame/"+id, GameDTO.class);
		game.setGameName("tictactoe");
		game.setCreated(new Date());
		game.setFirstPlayer(1);
		game.setSecondPlayer(2);
		game.setGameStatus(GameStatus.FIRST_PLAYER_WON);
		testRestTemplate.put("/api/v1/updateGame/"+id, game);
		GameDTO updatedGame = testRestTemplate.getForObject("/api/v1/getGame/"+id, GameDTO.class);
        assertNotNull(updatedGame);
		
	}
	@Test
    public void testListGames() {
		HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);

        ResponseEntity<String> response = testRestTemplate.exchange("/api/v1/getListGame",
            HttpMethod.GET, entity, String.class);

        assertNotNull(response.getBody());
		
	}

}
