package com.kata.kataBackend.service;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.kata.kataBackend.repo.GameRepository;

@Service
public class GameServiceImpl implements GameService{
	@Resource
	private GameRepository gameRepository;

}
