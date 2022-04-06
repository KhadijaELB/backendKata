package com.kata.kataBackend.model;

import javax.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Entity
@Getter
@Setter
public class Player {
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "player_sequence")
    @SequenceGenerator(name = "player_sequence", sequenceName = "player_sequence")
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "player_name", unique = true, nullable = false)
    private String playerName;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

}
