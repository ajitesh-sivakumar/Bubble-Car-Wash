package com.ajitesh.Bubble.Car.Wash.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ajitesh.Bubble.Car.Wash.bean.Wash;
import com.ajitesh.Bubble.Car.Wash.exception.InvalidRegistrationException;
import com.ajitesh.Bubble.Car.Wash.exception.NoEntryForDateException;
import com.ajitesh.Bubble.Car.Wash.exception.NoEntryFoundException;
import com.ajitesh.Bubble.Car.Wash.repo.CarWashRepository;
import com.ajitesh.Bubble.Car.Wash.util.FormatDate;
import com.ajitesh.Bubble.Car.Wash.util.GenerateUUID;
import com.ajitesh.Bubble.Car.Wash.util.ValidateRegistration;




@Component
public class CarWashService {

	@Autowired
	private CarWashRepository carWashRepository;
	private static final Logger logger = LogManager.getLogger(CarWashService.class);
	@Autowired
	private FormatDate formatDate;
	@Autowired
	private ValidateRegistration validateRegistration;
	@Autowired
	private GenerateUUID generateUUID;
	
	public List<Wash> allData(){
		logger.info("Service - All Entries");
		List<Wash> result = carWashRepository.findAll();
		if(result.isEmpty())
			throw new NoEntryFoundException("No Data Found in Database");
		return result;
	}
	
	public JSONObject addEntry(Wash wash) {
		logger.info("Service - Add New Entry");
		JSONObject json = new JSONObject();
		wash.setUuid(generateUUID.genUUID());
		carWashRepository.save(wash);
		json.put("uuid", wash.getUuid());
		return json;
	}
	
	public void updateEntry(String uuid, Wash wash) {
		logger.info("Service - Update Entry By UUID");
		Wash toUpdate = carWashRepository.getOne(uuid);
		toUpdate = wash;
		toUpdate.setUuid(uuid);
		carWashRepository.save(toUpdate);
	}
	
	public void deleteEntry(String uuid) {
		logger.info("Service - Delete Entry By UUID");
		carWashRepository.deleteById(uuid);
	}
	
	public List<Wash> searchByDate(String date) {
		logger.info("Service - Search Entry By Date");
		
		LocalDate date1 = formatDate.formatRegularDate(date);
		List<Wash> filteredList = new ArrayList<Wash>();
		filteredList = carWashRepository.findByDate(date1);
		
		if(filteredList.isEmpty())
			throw new NoEntryForDateException("No Data found for specified date");
		return filteredList;
	}
	
	public List<Wash> searchByEpochDate(long date) {
		logger.info("Service - Search Entry By Epoch Date");
		
		LocalDate localDate = formatDate.formatEpochDate(date);
		List<Wash> filteredList = new ArrayList<Wash>();
		
		filteredList = carWashRepository.findByDate(localDate);
		if(filteredList.isEmpty())
			throw new NoEntryForDateException("No Data found for specified epoch date");
		return filteredList;
	}
	
	public List<Wash> getHistoryByRegistration(String registration){
		logger.info("Service - Search Entry By Registration");
		boolean matchFound = validateRegistration.isValidRegistration(registration);
		List<Wash> filteredList = new ArrayList<Wash>();
		System.out.println(registration);
		if(matchFound) {
			System.out.println(matchFound);
			filteredList = carWashRepository.findByRegistration(registration);
			if(filteredList.isEmpty())
				throw new InvalidRegistrationException("No Data found for specified Registration");
		}else
			throw new InvalidRegistrationException("Invalid Registration Format");
		return filteredList;
	}
	
	public List<Wash> getCarTypeByDate(Wash wash) {
		logger.info("Service - Get Car Type By Date");
		LocalDate finalDate = formatDate.formatRegularDate(wash.getDate().toString());
		List<Wash> myWash = carWashRepository.findByDate(finalDate);
		List<Wash> finalList = new ArrayList<Wash>();
		for (Wash wash1 : myWash) {
			if(wash1.getCarDetails().getBody().equals(wash.getCarDetails().getBody())) {
				finalList.add(wash1);
			}
		}
		return finalList;
	}
}
