package com.ajitesh.Bubble.Car.Wash.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.ajitesh.Bubble.Car.Wash.bean.Body;
import com.ajitesh.Bubble.Car.Wash.bean.CarDetails;
import com.ajitesh.Bubble.Car.Wash.bean.Make;
import com.ajitesh.Bubble.Car.Wash.bean.Wash;
import com.ajitesh.Bubble.Car.Wash.bean.WashType;
import com.ajitesh.Bubble.Car.Wash.service.CarWashService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest
class CarWashRestControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private ObjectMapper objectMapper;

	@MockBean
	private CarWashService carWashService;
	
	@Test
	public void allDataTest() throws Exception {
		
		List<Wash> alldata = new ArrayList<Wash>();
		CarDetails carDetails = new CarDetails(Make.Ford,"Camry",Body.Sedan, "TN59BE6669", "White");
		Wash wash = new Wash("",carDetails,WashType.Machine_Wash,LocalDate.of(2020, 11, 10), LocalTime.of(12, 13));
		alldata.add(wash);
		
		Mockito.when(carWashService.allData()).thenReturn(alldata);
		
		String url = "/all";
		
		MvcResult mvcResult = mockMvc.perform(get(url)).andExpect(status().isOk()).andReturn();
		
		String actualJson = mvcResult.getResponse().getContentAsString();
		String expectedJson = objectMapper.writeValueAsString(alldata);
		
		assertThat(actualJson).isEqualTo(expectedJson);
	}
	
	
	//Check UUID 
	@Test
	public void addEntryTest() throws JsonProcessingException, Exception {
		CarDetails inputCd = new CarDetails(Make.Toyota, "Camry", Body.SUV, "KA51RK1829", "Red");
		Wash inputWash = new Wash(UUID.randomUUID().toString(), inputCd, WashType.Machine_Wash, LocalDate.of(2018, 06, 12), LocalTime.of(12, 34));
		
		CarDetails outputCd = new CarDetails(Make.Toyota, "Camry", Body.SUV, "KA51RK1829", "Red");
		Wash outputWash = new Wash(inputWash.getUuid(), outputCd, WashType.Machine_Wash, LocalDate.of(2018, 06, 12), LocalTime.of(12, 34));
		String outputJsonStr = objectMapper.writeValueAsString(outputWash);
		JSONObject outputJson = new JSONObject(outputJsonStr);
		
		Mockito.when(carWashService.addEntry(inputWash)).thenReturn(outputJson);
		
		String url = "/add";
		
		mockMvc.perform(post(url).contentType("application/json").content(objectMapper.writeValueAsString(inputWash))).andExpect(status().is(201)).andExpect(content().string(outputJsonStr));
	}
	
	@Test
	public void updateEntryTest() throws JsonProcessingException, Exception {
		String uuid = UUID.randomUUID().toString();
		CarDetails inputCd = new CarDetails(Make.Toyota, "Camry", Body.SUV, "KA51RK1829", "Red");
		Wash inputWash = new Wash(uuid, inputCd, WashType.Machine_Wash, LocalDate.of(2018, 06, 12), LocalTime.of(1, 10, 28));
		String url = "/update/" + uuid;
		System.out.println(objectMapper.writeValueAsString(inputWash));
		mockMvc.perform(put(url).contentType("application/json").content(objectMapper.writeValueAsString(inputWash))).andExpect(status().isOk());
	}
	
	@Test
	public void deleteEntryTest() throws Exception {
		String uuid = UUID.randomUUID().toString();
		String url = "/delete/" + uuid;
		mockMvc.perform(delete(url)).andExpect(status().isOk());
	}
	
	@Test
	public void getDetailsByDateTest() throws Exception {
		String date = "2020-11-10";
		String url = "/search/date/" + date;
		
		CarDetails cd = new CarDetails(Make.Ford, "Some Model", Body.Sedan, "TN59BE6669", "Redish");
		Wash w = new Wash(UUID.randomUUID().toString(), cd, WashType.Full_Wash, LocalDate.of(2020, 11, 10), LocalTime.of(12, 30));
		
		List<Wash> list = new ArrayList<Wash>();
		list.add(w);
		list.add(w);
		list.add(w);
		list.add(w);
		
		Mockito.when(carWashService.searchByDate(date)).thenReturn(list);
		
		MvcResult mvcResult = mockMvc.perform(get(url)).andExpect(status().isOk()).andReturn();
		
		String actual = mvcResult.getResponse().getContentAsString();
		String expected = objectMapper.writeValueAsString(list);
		
		assertThat(actual).isEqualTo(expected);
	}
	
	@Test
	public void getDetailsByEpochDateTest() throws Exception {
		long epochDate = 1604946600;
		String url = "/search/date/epoch/" + epochDate;
		
		CarDetails cd = new CarDetails(Make.Ford, "Some Model", Body.Sedan, "TN59BE6669", "Redish");
		Wash w = new Wash(UUID.randomUUID().toString(), cd, WashType.Full_Wash, LocalDate.of(2020, 11, 10), LocalTime.of(12, 30));
		
		List<Wash> list = new ArrayList<Wash>();
		list.add(w);
		list.add(w);
		list.add(w);
		list.add(w);
		
		Mockito.when(carWashService.searchByEpochDate(epochDate)).thenReturn(list);
		
		MvcResult mvcResult = mockMvc.perform(get(url)).andExpect(status().isOk()).andReturn();
		
		String actual = mvcResult.getResponse().getContentAsString();
		String expected = objectMapper.writeValueAsString(list);
		
		assertThat(actual).isEqualTo(expected);
	}
	
	@Test
	public void getHistoryByRegistrationTest() throws Exception {
		String registration = "TN59BE6669";
		String url = "/search/registration/" + registration;


		CarDetails cd = new CarDetails(Make.Ford, "Some Model", Body.Sedan, "TN59BE6669", "Redish");
		Wash w = new Wash(UUID.randomUUID().toString(), cd, WashType.Full_Wash, LocalDate.of(2020, 11, 10), LocalTime.of(12, 30));
		
		List<Wash> list = new ArrayList<Wash>();
		list.add(w);
		list.add(w);
		list.add(w);
		list.add(w);
		
		Mockito.when(carWashService.getHistoryByRegistration(registration)).thenReturn(list);
		
		MvcResult mvcResult = mockMvc.perform(get(url)).andExpect(status().isOk()).andReturn();
		
		String actual = mvcResult.getResponse().getContentAsString();
		String expected = objectMapper.writeValueAsString(list);
		
		assertThat(actual).isEqualTo(expected);
	}
	
	@Test
	public void searchByCarTypeAndDateTest() throws JsonProcessingException, Exception {
		
		String url = "/search/cartypeanddate";
		
		CarDetails cd = new CarDetails();
		cd.setBody(Body.Sedan);
		Wash wash = new Wash();
		wash.setCarDetails(cd);
		wash.setDate(LocalDate.of(2020, 11, 10));
		
		CarDetails cd1 = new CarDetails(Make.Ford, "Some Model", Body.Sedan, "TN59BE6669", "Redish");
		Wash w = new Wash(UUID.randomUUID().toString(), cd1, WashType.Full_Wash, LocalDate.of(2020, 11, 10), LocalTime.of(12, 30));

				
		List<Wash> myWash = new ArrayList<Wash>();
		myWash.add(w);
		myWash.add(w);
		
		Mockito.when(carWashService.getCarTypeByDate(wash)).thenReturn(myWash);
		
		MvcResult mvcResult = mockMvc.perform(get(url).contentType("application/json").content(objectMapper.writeValueAsString(wash))).andReturn();
		
		System.out.println("Expected = " + objectMapper.writeValueAsString(myWash));
		System.out.println("Actual = " + mvcResult.getResponse().getContentAsString());
	}
}
