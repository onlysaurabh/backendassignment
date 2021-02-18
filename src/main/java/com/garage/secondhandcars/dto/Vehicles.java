package com.garage.secondhandcars.dto;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Vehicles {
	private int vid;
	private String make;
	private String model;
	private int yearModel;
	private double price;
	private boolean licensed;
	private String dateAdded;
	
	

}
