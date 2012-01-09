package com.tsl.example.cars.model;

import java.io.Serializable;

/**
 * Class that represents a Car.  
 * 
 * @author Kevin McCormack (The Server Labs)
 *
 */ 
public class Car implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String make;
	private String model;
	
	public Car() { }
	
	public Car(Long id, String make, String model) {
		super();
		this.id = id;
		this.make = make;
		this.model = model;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((make == null) ? 0 : make.hashCode());
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Car other = (Car) obj;
		if (make == null) {
			if (other.make != null)
				return false;
		} else if (!make.equals(other.make))
			return false;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		return true;
	}

}
