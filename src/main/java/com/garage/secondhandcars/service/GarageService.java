package com.garage.secondhandcars.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.garage.secondhandcars.dao.CartDao;
import com.garage.secondhandcars.dao.WarehouseDao;
import com.garage.secondhandcars.dto.Cars;
import com.garage.secondhandcars.dto.Location;
import com.garage.secondhandcars.dto.Vehicles;
import com.garage.secondhandcars.dto.Warehouse;
import com.garage.secondhandcars.repository.CartRepository;
import com.garage.secondhandcars.repository.WarehouseRepository;

import lombok.RequiredArgsConstructor;

@Service
public class GarageService {
	@Autowired
    WarehouseRepository warehouserepository;
	@Autowired
	CartRepository cartRepository;
	
	
	public List<Warehouse> getWarehouseDetails()
	{	
		List<Warehouse> warehouseList=new ArrayList<>();
		//get details from Database
		List<WarehouseDao> warehousedaoList=getAll();
		//sort the details on date added
		sortOnDateAdded(warehousedaoList);
			for(WarehouseDao warehousedao:warehousedaoList)
				{	
					Warehouse warehouse=convertDAOtoDTO(warehousedao);
					warehouseList.add(warehouse);
				}
			//return the sorted DTO list
		return warehouseList;
	}
	
	// Get all cars from the h2 warehouse database.
    private List<WarehouseDao> getAll() {
        final List<WarehouseDao> warehouseDaoList = new ArrayList<>();
        warehouserepository.findAll().forEach(warehouseDaoList::add);
        return warehouseDaoList;
    }
    
    private Warehouse convertDAOtoDTO(WarehouseDao dao){
    	Warehouse warehouse=new Warehouse();
    	
    	warehouse.setWid(String.valueOf(dao.getWarehouse_id()));
    	warehouse.setName(dao.getName());
    	
    	Location location=new Location();
    	location.setLatitude(dao.getLocationLat());
    	location.setLongitude(dao.getLocationLong());
    	warehouse.setLocation(location);
    	
    	Cars cars=new Cars();
    	cars.setLocation(dao.getCarLocation());
    	List <Vehicles> vehicleLst=new ArrayList<>();
    	Vehicles vehicle=new Vehicles();
    	vehicle.setVid(dao.getCarId());
    	vehicle.setYearModel(dao.getCarYear());
    	vehicle.setDateAdded(dao.getCarDateAdded());
    	vehicle.setLicensed(dao.isLicensed());
    	vehicle.setMake(dao.getCarMake());
    	vehicle.setModel(dao.getCarModel());
    	vehicle.setPrice(dao.getCarPrice());
    	vehicleLst.add(vehicle);
    	
    	cars.setVehicles(vehicleLst);
    	
    	warehouse.setCars(cars);
    	
    	return warehouse;
    }
    private List<WarehouseDao> sortOnDateAdded(List<WarehouseDao> warehouseList){
    	warehouseList.sort(Comparator.comparing(WarehouseDao::getCarDateAdded));
    	
    	return warehouseList;
    }

	public List<Vehicles> getVehiclesFromCart(List<Vehicles> vehicleList) {
		List<CartDao> cartList= new ArrayList<>(); 
		for(Vehicles veh:vehicleList){
			CartDao cart=convertDTOtoDAO(veh);
			cartList.add(cart);
		}
		List<CartDao> savedCartList;
		savedCartList=getAllItems(cartList);
		List<Vehicles> finalVehicleLst= new ArrayList<Vehicles>();
		for(CartDao cart:savedCartList){
			Vehicles veh=convertDAOtoDTO(cart);
			finalVehicleLst.add(veh);
		}

		return finalVehicleLst;
	}
	
	private List<CartDao> getAllItems(List<CartDao> cartList) {
        final List<CartDao> cartDaoList = new ArrayList<>();
        cartRepository.saveAll(cartList).forEach(cartDaoList::add);
        return cartDaoList;
    }
    private CartDao convertDTOtoDAO(Vehicles vehicle)
    {
    	CartDao cartDao=new CartDao();
    	cartDao.setCarId(vehicle.getVid());
    	cartDao.setCarMake(vehicle.getMake());
    	cartDao.setCarModel(vehicle.getModel());
    	cartDao.setCarPrice(vehicle.getPrice());
    	cartDao.setCarYear(vehicle.getYearModel());
    	cartDao.setLicensed(vehicle.isLicensed());
    	cartDao.setCarDateAdded(vehicle.getDateAdded());
    	return cartDao;
    }
    
    private Vehicles convertDAOtoDTO(CartDao cartDao){
    	Vehicles vehicle=new Vehicles();
    	vehicle.setVid(cartDao.getCarId());
    	vehicle.setMake(cartDao.getCarMake());
    	vehicle.setModel(cartDao.getCarModel());
    	vehicle.setPrice(cartDao.getCarPrice());
    	vehicle.setYearModel(cartDao.getCarYear());
    	vehicle.setLicensed(cartDao.isLicensed());
    	vehicle.setDateAdded(cartDao.getCarDateAdded());
    	return vehicle;
    }

}
