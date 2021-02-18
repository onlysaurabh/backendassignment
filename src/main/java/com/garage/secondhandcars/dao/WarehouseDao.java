package com.garage.secondhandcars.dao;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@Table(name="warehouse")
public class WarehouseDao {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int warehouse_id;
	@Column(name="name") 
	private String name;
	@Column(name="location_lat")  
	private String locationLat;
	@Column(name="location_long")  
	private String locationLong;
	@Column(name="car_location") 
	private String carLocation;
	@Column(name="car_id")  
	private int carId;
	@Column(name="car_make") 
	private String carMake;
	@Column(name="car_model")  
	private String carModel;
	@Column(name="car_year")  
	private int carYear;
	@Column(name="car_price")  
	private double carPrice;
	@Column(name="licensed")  
	private boolean licensed;
	@Column(name="car_date_added")  
	private String carDateAdded;

	
	@Override
	public String toString() {
	     return new StringBuilder().
	    append("\ncarId "+ carId).
		append(" carModel"+ carModel).
	     append(" car_date_added "+ carDateAdded).
	     append(" carPrice "+ carPrice).
	       append(" name "+ name).
	       append(" locationLat "+ locationLat).
	       append(" location_long "+ locationLong).
	       append(" location_long "+ locationLong).
	       	       
	       toString(); 
	}
	

}
