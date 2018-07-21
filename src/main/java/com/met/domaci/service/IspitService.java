package com.met.domaci.service;

import java.util.List;

import com.met.domaci.entities.Ispit;



public interface IspitService {
	
	List<Ispit> listAllIspiti();
	
	public Ispit findOne(int id);
}
