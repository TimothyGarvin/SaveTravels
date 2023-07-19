package com.garvintimothy.travels.controllers;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.garvintimothy.travels.models.Travel;
import com.garvintimothy.travels.services.TravelService;

@RestController
public class TravelApi {
	private final TravelService travelService;
	public TravelApi(TravelService travelService) {
		this.travelService = travelService;
	}
	@RequestMapping("/api/travels")
	public List<Travel> index(){
		return travelService.allTravels();
	}
	@RequestMapping(value ="/api/travels", method=RequestMethod.POST)
	public Travel create(
			@RequestParam(value="name") String name,
			@RequestParam(value="vendor") String vendor,
			@RequestParam(value="amount") Double amount,
			@RequestParam(value="description") String description) {
		Travel travel = new Travel(name, vendor, amount, description);
		System.out.println("anything");
		return travelService.createTravel(travel);
	}
	@RequestMapping("/api/travels/{id}")
	public Travel show(@PathVariable("id") Long id) {
		Travel travel = travelService.findTrip(id);
		return travel;
	}
}
