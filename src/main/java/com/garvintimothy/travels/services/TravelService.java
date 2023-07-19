package com.garvintimothy.travels.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.garvintimothy.travels.models.Travel;
import com.garvintimothy.travels.repositories.TravelRepository;

@Service
public class TravelService {
	private final TravelRepository travelRepository;
	
	public TravelService(TravelRepository travelRepository) {
		this.travelRepository = travelRepository;
	}
	public List<Travel> allTravels(){
		return travelRepository.findAll();
	}
	public Travel createTravel(Travel t) {
		return travelRepository.save(t);
	}
	public Travel updateTravel(Travel t) {
		return travelRepository.save(t);
	}
	public Travel findTrip(Long id) {
		Optional<Travel> optionalTravel = travelRepository.findById(id);
			if(optionalTravel.isPresent()) {
				return optionalTravel.get();
			} else {
				return null;
			}
	}
	public List<Travel> travelsContaining(String search){
		return travelRepository.findByNameContaining(search);
	}
	public Travel deleteTravel(Long id) {
		travelRepository.deleteById(id);
		return null;
	}
}
