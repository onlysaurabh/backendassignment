package com.garage.secondhandcars.service;

import com.garage.secondhandcars.dao.WarehouseDao;
import com.garage.secondhandcars.dto.Vehicles;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;
import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
public class GarageServiceTest {

    @Autowired
    private GarageService garageService;
    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void getWareHouseDetailsTest() {

        WarehouseDao warehouseDao = new WarehouseDao();
        warehouseDao.setName("Warehouse A");
        warehouseDao.setLocationLat("1239729");
        warehouseDao.setLocationLong("-1298392");
        warehouseDao.setCarLocation("West wing");
        warehouseDao.setCarId(2);
        warehouseDao.setCarMake("Maserati");
        warehouseDao.setCarModel("Coupe");
        warehouseDao.setCarPrice(1234.678);
        warehouseDao.setLicensed(true);
        warehouseDao.setCarYear(2005);
        warehouseDao.setCarDateAdded("2018-01-03");

        entityManager.persist(warehouseDao);

        Assertions.assertThat(garageService.getWarehouseDetails()).isNotEmpty();
    }

    @Test
    public void getVehiclesFromCartTest() {
        Vehicles vehicles = new Vehicles();
        List<Vehicles> listOfVehicles = Collections.singletonList(vehicles);
        List<Vehicles> response = garageService.getVehiclesFromCart(listOfVehicles);

        Assertions.assertThat(response).isNotEmpty();
    }

    @TestConfiguration
    static class GarageServiceImplTestContextConfiguration {

        @Bean
        public GarageService garageService() {
            return new GarageService();
        }
    }

}
