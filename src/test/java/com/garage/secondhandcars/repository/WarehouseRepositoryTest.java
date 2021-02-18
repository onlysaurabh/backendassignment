package com.garage.secondhandcars.repository;

import com.garage.secondhandcars.dao.WarehouseDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class WarehouseRepositoryTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private WarehouseRepository warehouseRepository;

    @Test
    public void findAllTest() {
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

        int id = (int) entityManager.persistAndGetId(warehouseDao);
        entityManager.flush();

        WarehouseDao warehouseDaoTest = warehouseRepository.findById(id).get();

        assertThat(warehouseDaoTest.getName()).isEqualTo(warehouseDao.getName());

    }

}
