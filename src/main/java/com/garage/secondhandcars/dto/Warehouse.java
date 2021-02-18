package com.garage.secondhandcars.dto;

import org.springframework.stereotype.Component;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Warehouse {
	private String wid;
	private String name;
	private Location location;
	private Cars cars;


}
