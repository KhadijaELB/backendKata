package com.kata.kataBackend.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kata.kataBackend.service.PlayerService;
import com.kata.kataBackend.repo.PlayerRepository;

@Service
public class PlayerServiceImpl implements PlayerService{
	@Resource
    private PlayerRepository playerRepository;

}
