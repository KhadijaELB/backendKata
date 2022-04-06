package com.kata.kataBackend.playerTests;


import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import com.kata.kataBackend.DTO.PlayerDTO;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PlayerControllerTest {
	@Autowired
    private TestRestTemplate testRestTemplate;
	
	@Test
    public void testGetPlayerById() {
		PlayerDTO player = testRestTemplate.getForObject("/api/v1/getPlayer/1", PlayerDTO.class);
        assertNotNull(player.getPlayerName());
    }
	@Test
    public void testCreatePlayer() {
        PlayerDTO player = new PlayerDTO();
        player.setPlayerName("Khadija");
        ResponseEntity<PlayerDTO> postResponse = testRestTemplate.postForEntity("/api/v1/addPlayer", player, PlayerDTO.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

}
