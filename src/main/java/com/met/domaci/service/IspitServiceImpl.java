package com.met.domaci.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.met.domaci.entities.Ispit;
import com.met.domaci.repository.IspitRepository;


@Service
public class IspitServiceImpl implements IspitService{
	
	@Autowired
	private IspitRepository ispitRepository;

	@Override
	public List<Ispit> listAllIspiti() {
		List<Ispit> ispiti = ispitRepository.findAll();
		return ispiti;
	}

	public Ispit findOne(int id) {
		Ispit i = ispitRepository.getOne(id);
		return i;
	}
}
