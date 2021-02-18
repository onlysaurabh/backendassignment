package com.garage.secondhandcars.controller;

import com.garage.secondhandcars.dto.Vehicles;
import com.garage.secondhandcars.dto.Warehouse;
import com.garage.secondhandcars.service.GarageService;
import org.hamcrest.core.Is;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class GarageControllerTest {

    @InjectMocks
    private GarageController garageController;

    @Mock
    private GarageService garageService;

    @Test
    public void getWareHouseDetails() {

        Warehouse warehouse = new Warehouse();
        List<Warehouse> warehouses = Collections.singletonList(warehouse);

        when(garageService.getWarehouseDetails()).thenReturn(warehouses);
        ResponseEntity<List<Warehouse>> response =
                garageController.getWarehouseDetails();
        assertThat(response.getStatusCodeValue(), Is.is(200));
        assertFalse(response.getBody().isEmpty());
    }

    @Test
    public void addtoCartTest() {
        Vehicles vehicles = new Vehicles();
        List<Vehicles> vehiclesList = Collections.singletonList(vehicles);

        when(garageService.getVehiclesFromCart(vehiclesList)).thenReturn(vehiclesList);
        ResponseEntity<List<Vehicles>> response = garageController.addToCart(vehiclesList);
        assertThat(response.getStatusCodeValue(), Is.is(200));
        assertFalse(response.getBody().isEmpty());

    }

}
