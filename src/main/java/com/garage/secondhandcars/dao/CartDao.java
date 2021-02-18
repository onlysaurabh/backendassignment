package com.garage.secondhandcars.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@Table(name="cart")
public class CartDao {
	
	@Id 
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
	       toString(); 
	}

}
