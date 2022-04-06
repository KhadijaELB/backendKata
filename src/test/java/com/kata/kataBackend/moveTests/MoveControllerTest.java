package com.kata.kataBackend.moveTests;

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
import com.kata.kataBackend.DTO.MoveDTO;
import com.kata.kataBackend.enums.GameStatus;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MoveControllerTest {
	@Autowired
    private TestRestTemplate testRestTemplate;
	
	@Test
    public void testCreateMove() {
		MoveDTO move = new MoveDTO();
		move.setBoardColumn(1);
		move.setBoardRow(1);
		move.setCreated(new Date());
		move.setGame(1);
		move.setPlayer(1);
		
        ResponseEntity<MoveDTO> postResponse = testRestTemplate.postForEntity("/api/v1/addMove", move, MoveDTO.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
		
	}
	@Test
    public void testListMoves() {
		int id =1;
		HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);

        ResponseEntity<String> response = testRestTemplate.exchange("/api/v1/getListMove/"+id,
            HttpMethod.GET, entity, String.class);

        assertNotNull(response.getBody());
		
	}

}
