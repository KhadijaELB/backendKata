package com.kata.kataBackend.DTO;

import java.util.Date;

import com.kata.kataBackend.enums.GameStatus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class GameDTO {
	private int id;
	private String gameName;
	private int secondPlayer;
	private int firstPlayer;
    private GameStatus gameStatus;
    private Date created;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getGameName() {
		return gameName;
	}
	public void setGameName(String gameName) {
		this.gameName = gameName;
	}
	public int getSecondPlayer() {
		return secondPlayer;
	}
	public void setSecondPlayer(int secondPlayer) {
		this.secondPlayer = secondPlayer;
	}
	public int getFirstPlayer() {
		return firstPlayer;
	}
	public void setFirstPlayer(int firstPlayer) {
		this.firstPlayer = firstPlayer;
	}
	public GameStatus getGameStatus() {
		return gameStatus;
	}
	public void setGameStatus(GameStatus gameStatus) {
		this.gameStatus = gameStatus;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
    

}
