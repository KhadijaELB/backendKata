package com.kata.kataBackend.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kata.kataBackend.model.Move;

public interface MoveRepository extends JpaRepository<Move, Integer> {
	public List<Move> findByGameId(Integer idGame);

}
