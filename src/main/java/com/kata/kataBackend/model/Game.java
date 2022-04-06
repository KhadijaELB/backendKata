package com.kata.kataBackend.model;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Check;
import com.kata.kataBackend.enums.GameStatus;
import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@Check(constraints = "game_status = 'IN_PROGRESS' or game_status = 'FIRST_PLAYER_WON' or game_status = 'SECOND_PLAYER_WON'" +
        "or game_status = 'FINISHED'")


public class Game {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "game_sequence")
    @SequenceGenerator(name = "game_sequence", sequenceName = "game_sequence")
    @Column(name = "id", nullable = false)
    private int id;
	
	@Column(name = "game_Name", nullable = false)
    private String gameName;

    @ManyToOne
    @JoinColumn(name = "second_player_id", nullable = false)
    private Player secondPlayer;

    @ManyToOne
    @JoinColumn(name = "first_player_id", nullable = false)
    private Player firstPlayer;
    
    @Enumerated(EnumType.STRING)
    private GameStatus gameStatus;

    @Column(name = "created", nullable = false)
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

	public Player getSecondPlayer() {
		return secondPlayer;
	}

	public void setSecondPlayer(Player secondPlayer) {
		this.secondPlayer = secondPlayer;
	}

	public Player getFirstPlayer() {
		return firstPlayer;
	}

	public void setFirstPlayer(Player firstPlayer) {
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
