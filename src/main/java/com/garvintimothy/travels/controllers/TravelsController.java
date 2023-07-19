package com.garvintimothy.travels.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.garvintimothy.travels.models.Travel;
import com.garvintimothy.travels.services.TravelService;

import jakarta.validation.Valid;

@Controller
public class TravelsController {
	
	@Autowired
	TravelService travelService;
	
	@GetMapping("/travels")
	public String index(@ModelAttribute("travel") Travel travel, Model model) {
		List<Travel> travels = travelService.allTravels();
		
		model.addAttribute("travels", travels);
		return "index.jsp";
	}
	
	@GetMapping("/travels/{id}")
	public String details(Model model, @PathVariable("id") Long id) {
		model.addAttribute("travel", travelService.findTrip(id));
		return "details.jsp";
	}
	
	@PostMapping("/travels/add")
	public String main(@Valid @ModelAttribute("travel") Travel travel, BindingResult result, Model model) {
		if(result.hasErrors()) {
			List<Travel> travels = travelService.allTravels();
			model.addAttribute("travels", travels);
			return "index.jsp";
		} else {
			travelService.createTravel(travel);
			return "redirect:/travels";
		}
	}
	@RequestMapping("/travels/{id}/edit")
	public String edit(@PathVariable("id") Long id, Model model) {
		Travel travel = travelService.findTrip(id);
		model.addAttribute("travel", travel);
		return "edit.jsp";
	}
	@RequestMapping(value="/travels/{id}", method=RequestMethod.PUT)
	public String update(@Valid @ModelAttribute("travel") Travel travel, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("travel", travel);
			return "edit.jsp";
		} else {
			travelService.updateTravel(travel);
			return "redirect:/travels";
		}
	}
	
	@RequestMapping(value="/travels/{id}", method=RequestMethod.DELETE)
	public String destroy(@PathVariable("id") Long id) {
		travelService.deleteTravel(id);
		return "redirect:/travels";
	}
}

