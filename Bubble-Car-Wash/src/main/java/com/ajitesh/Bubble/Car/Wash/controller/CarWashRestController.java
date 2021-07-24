package com.ajitesh.Bubble.Car.Wash.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ajitesh.Bubble.Car.Wash.bean.Wash;
import com.ajitesh.Bubble.Car.Wash.service.CarWashService;


	
@RestController
public class CarWashRestController {
	
	private static final Logger logger = LogManager.getLogger(CarWashRestController.class);
	
	@Autowired
	private CarWashService carWashService;
	
	@GetMapping("/all")
	public List<Wash> allData(){
		logger.info("Controller - All Entries");
		return carWashService.allData();
	}
	
	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping("/add")
	public JSONObject addEntry(@Valid @RequestBody Wash wash) {
		logger.info("Controller - Add New Entry");
		return carWashService.addEntry(wash);
	}
	
	@PutMapping("/update/{uuid}")
	public void updateEntry(@PathVariable String uuid,@Valid @RequestBody Wash wash) {
		logger.info("Controller - Update Entry By UUID");
		carWashService.updateEntry(uuid, wash);
	}
	
	@DeleteMapping("/delete/{uuid}")
	public void deleteEntry(@PathVariable String uuid) {
		logger.info("Controller - Delete Entry By UUID");
		carWashService.deleteEntry(uuid);
	}
	
	@GetMapping("/search/date/{date}")
	public List<Wash> getDetailsByDate(@PathVariable String date){
		logger.info("Controller - Search Entry By Date");
		return carWashService.searchByDate(date);
	}
	
	@GetMapping("/search/epochdate/{date}")
	public List<Wash> getDetailsByEpochDate(@PathVariable long date){
		logger.info("Controller - Search Entry By Epoch Date");
		return carWashService.searchByEpochDate(date);
	}
	
	@GetMapping("/search/registration/{registration}")
	public List<Wash> getHistoryByRegistration(@PathVariable String registration){
		logger.info("Controller - Search Entry By Registration");
		System.out.println(registration);
		return carWashService.getHistoryByRegistration(registration);
	}
	
	@GetMapping("/search/cartypeanddate")
	public List<Wash> searchByCarTypeAndDate(@RequestBody Wash wash){
		return carWashService.getCarTypeByDate(wash);
	}
}
