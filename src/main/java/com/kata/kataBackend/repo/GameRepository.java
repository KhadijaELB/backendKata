package com.kata.kataBackend.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kata.kataBackend.model.Game;

@Repository
public interface GameRepository extends JpaRepository<Game, Integer> {
	public List<Game> findAll();
}
