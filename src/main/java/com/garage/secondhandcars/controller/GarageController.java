package com.garage.secondhandcars.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.garage.secondhandcars.dto.Vehicles;
import com.garage.secondhandcars.dto.Warehouse;
import com.garage.secondhandcars.service.GarageService;

@CrossOrigin(origins="*",allowedHeaders="*")
@RestController
public class GarageController {
	
	@Autowired
	private  GarageService garageService;
	
		//get call to get Car and warehouse details to display on overview page
	 	@GetMapping("/warehouse")
	    public ResponseEntity<List<Warehouse>> getWarehouseDetails() {
	        List<Warehouse> warehouseList = garageService.getWarehouseDetails();
	        return new ResponseEntity<>(warehouseList, HttpStatus.OK);
	    }
	 	//post call to store in cart
	    @PostMapping(value = "/addToCart", consumes = "application/json", produces = "application/json")
	    public ResponseEntity<List<Vehicles>> addToCart(@RequestBody List<Vehicles> vehicleList) {
	        List<Vehicles> vehicleListResp = garageService.getVehiclesFromCart(vehicleList);
	        return new ResponseEntity<>(vehicleListResp, HttpStatus.OK);
	    }

}
