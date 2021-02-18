package com.garage.secondhandcars.dto;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Cars {
	
	private String location;
	private List<Vehicles> vehicles;

}
