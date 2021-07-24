package com.ajitesh.Bubble.Car.Wash.controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ajitesh.Bubble.Car.Wash.bean.Body;
import com.ajitesh.Bubble.Car.Wash.bean.CarDetails;
import com.ajitesh.Bubble.Car.Wash.bean.Make;
import com.ajitesh.Bubble.Car.Wash.bean.Wash;
import com.ajitesh.Bubble.Car.Wash.bean.WashType;
import com.ajitesh.Bubble.Car.Wash.service.CarWashService;

@Controller
public class CarWashViewController {
	
	@Autowired
	private CarWashService carWashService;

	@RequestMapping("/home")
	public ModelAndView welcome() {
			return new ModelAndView("index");
	}
	
	@RequestMapping("/allentries")
	public ModelAndView all() {
		List<Wash> all = carWashService.allData();
		return new ModelAndView("/crud/all", "wlist", all); 
	}

	 
	@GetMapping("/add")
	public ModelAndView add() {
			return new ModelAndView("/crud/add"); 
	}
	
	@PostMapping("/addentry")
	public String addentry(@RequestParam("make") String make, @RequestParam("body") String body, @RequestParam("registration") String registration, @RequestParam("color") String color, @RequestParam("washtype") String washtype, @RequestParam("date") String date, @RequestParam("time") String time, @RequestParam("model") String model) {
		LocalDate dateFinal = LocalDate.parse(date);
		LocalTime timeFinal = LocalTime.parse(time);
		CarDetails carDetails = new CarDetails(Make.valueOf(make),model,Body.valueOf(body),registration,color);
		Wash wash = new Wash("",carDetails,WashType.valueOf(washtype),dateFinal,timeFinal);
		
		carWashService.addEntry(wash);
		return "/response/success";
	}
	
	@GetMapping("/update")
	public ModelAndView update() {
		return new ModelAndView("/crud/update"); 
	}
	
	@PostMapping("/updateentry")
	public String updateentry(@RequestParam("uuid") String uuid, @RequestParam("make") String make, @RequestParam("body") String body, @RequestParam("registration") String registration, @RequestParam("color") String color, @RequestParam("washtype") String washtype, @RequestParam("date") String date, @RequestParam("time") String time, @RequestParam("model") String model) {
		LocalDate dateFinal = LocalDate.parse(date);
		LocalTime timeFinal = LocalTime.parse(time);
		CarDetails carDetails = new CarDetails(Make.valueOf(make),model,Body.valueOf(body),registration,color);
		Wash wash = new Wash(uuid,carDetails,WashType.valueOf(washtype),dateFinal,timeFinal);
		
		carWashService.updateEntry(uuid, wash);
		return "/response/success";
	}
	
	@GetMapping("/delete")
	public ModelAndView delete() {
			return new ModelAndView("/crud/delete"); 
	}
	
	@PostMapping("/deleteentry")
	public String deleteentry(@RequestParam("uuid") String uuid) {
		carWashService.deleteEntry(uuid);
		return "/response/success"; 
	}
	
	@GetMapping("/searchbydate")
	public ModelAndView searchbydate() {
		return new ModelAndView("/search/searchbydate"); 
	}
	
	@PostMapping("/searchbydate")
	public ModelAndView searchbydate(@RequestParam("date") String date) {
		List<Wash> sbd = carWashService.searchByDate(date);
		return new ModelAndView("/search/searchbydate", "sbdlist", sbd); 
	}
	
	@GetMapping("/searchbyepochdate")
	public ModelAndView searchbyepochdate() {
		return new ModelAndView("/search/searchbyepochdate"); 
	}
	
	@PostMapping("/searchbyepochdate")
	public ModelAndView searchbyepochdate(@RequestParam("date") long date) {
		List<Wash> sbed = carWashService.searchByEpochDate(date);
		return new ModelAndView("/search/searchbyepochdate", "sbedlist", sbed); 
	}
	
	@GetMapping("/searchbyregistration")
	public ModelAndView searchbyregistration() {
		return new ModelAndView("/search/searchbyregistration"); 
	}
	
	@PostMapping("/searchbyregistration")
	public ModelAndView searchbyregistration(@RequestParam("registration") String registration) {
		List<Wash> sbr = carWashService.getHistoryByRegistration(registration);
		return new ModelAndView("/search/searchbyregistration", "sbrlist", sbr); 
	}
	
	@GetMapping("/searchbycartypeanddate")
	public ModelAndView searchbycartypeanddate() {
		return new ModelAndView("/search/searchbycartypeanddate"); 
	}
	
	@PostMapping("/searchbycartypeanddate")
	public ModelAndView searchbycartypeanddate(@RequestParam("body") String body, @RequestParam("date") String date) {
		CarDetails cd = new CarDetails(Body.valueOf(body));
		LocalDate ld = LocalDate.parse(date); 
		Wash wash = new Wash(cd, ld);
		List<Wash> sbctandd = carWashService.getCarTypeByDate(wash);
		return new ModelAndView("/search/searchbycartypeanddate", "sbctanddlist", sbctandd); 
	}
}
