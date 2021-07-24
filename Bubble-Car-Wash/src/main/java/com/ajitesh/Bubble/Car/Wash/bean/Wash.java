package com.ajitesh.Bubble.Car.Wash.bean;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name="bcw")
@ApiModel(description="Details for WashList")
public class Wash {

	public Wash(CarDetails carDetails, LocalDate date) {
		super();
		this.carDetails = carDetails;
		this.date = date;
	}
	@Override
	public String toString() {
		return "WashList [uuid=" + uuid + ", carDetails=" + carDetails + ", washType=" + washType + ", date=" + date
				+ ", time=" + time + "]";
	}
	@Size(min=36, max=36, message="UUID should have minimum of 3 characters")
	@ApiModelProperty(notes="UUID should have minimum of 3 characters")
	@Id
	private String uuid;
	@NotNull
	private CarDetails carDetails;
	@NotNull
	private WashType washType;
	@NotNull
	private LocalDate date;
	@NotNull
	private LocalTime time;
	
	
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public CarDetails getCarDetails() {
		return carDetails;
	}
	public void setCarDetails(CarDetails carDetails) {
		this.carDetails = carDetails;
	}
	public WashType getWashType() {
		return washType;
	}
	public void setWashType(WashType washType) {
		this.washType = washType;
	}
	
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public LocalTime getTime() {
		return time;
	}
	public void setTime(LocalTime time) {
		this.time = time;
	}
	
	public Wash(String uuid, CarDetails carDetails, WashType washType, LocalDate date, LocalTime time) {
		super();
		this.uuid = uuid;
		this.carDetails = carDetails;
		this.washType = washType;
		this.date = date;
		this.time = time;
	}
	public Wash() {
		super();
	}
	public Wash(CarDetails carDetails, WashType washType, LocalDate date, LocalTime time) {
		super();
		this.carDetails = carDetails;
		this.washType = washType;
		this.date = date;
		this.time = time;
	}
}
