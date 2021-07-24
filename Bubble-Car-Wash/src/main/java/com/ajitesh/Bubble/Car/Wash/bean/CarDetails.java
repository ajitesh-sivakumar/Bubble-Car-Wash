package com.ajitesh.Bubble.Car.Wash.bean;


import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Embeddable
@ApiModel(description="Details for CarDetails")
public class CarDetails {

	@NotNull
	private Make make;
	@Size(min=3, max=15, message="Car Model should have minimum of 3 and maximum of 15 characters")
	@ApiModelProperty(notes="Car Model should have minimum of 3 and maximum of 15 characters")
	@NotNull
	private String carModel;
	@NotNull
	private Body body;
	@NotNull
	@Size(min=9, max=10, message="Registration should have minimum of 9 and maximum of 10 characters")
	@ApiModelProperty(notes="Registration should have minimum of 9 and maximum of 10 characters")
	private String registration;
	@NotNull
	@Size(min=3, max=15, message="Color should have minimum of 3 and maximum of 15 characters")
	@ApiModelProperty(notes="Color should have minimum of 3 and maximum of 15 characters")
	private String color;
	
	public Make getMake() {
		return make;
	}
	public void setMake(Make make) {
		this.make = make;
	}
	public String getCarModel() {
		return carModel;
	}
	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}
	public Body getBody() {
		return body;
	}
	public void setBody(Body body) {
		this.body = body;
	}
	public String getRegistration() {
		return registration;
	}
	public void setRegistration(String registration) {
		this.registration = registration;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public CarDetails(Make make, String carModel, Body body, String registration, String color) {
		super();
		this.make = make;
		this.carModel = carModel;
		this.body = body;
		this.registration = registration;
		this.color = color;
	}
	public CarDetails() {
		super();
	}
	public CarDetails(Body body) {
		super();
		this.body = body;
	}
	@Override
	public String toString() {
		return "CarDetails [make=" + make + ", carModel=" + carModel + ", body=" + body + ", registration="
				+ registration + ", color=" + color + "]";
	}
}
