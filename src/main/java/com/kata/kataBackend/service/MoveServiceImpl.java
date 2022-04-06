package com.kata.kataBackend.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kata.kataBackend.repo.MoveRepository;



@Service
public class MoveServiceImpl implements MoveService {
	@Resource
	private MoveRepository moveRepository;
	
	

}

