package com.kata.kataBackend.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kata.kataBackend.model.Game;

@Repository
public interface GameRepository extends JpaRepository<Game, Integer> {
 
}
