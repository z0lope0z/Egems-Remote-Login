package com.tsl.example.cars.dao.dummy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.tsl.example.cars.dao.CarDao;
import com.tsl.example.cars.model.Car;

public class DummyCarDao implements CarDao {

	private static long nextId = 3;
	private static final List<Car> CARS_LIST = new ArrayList<Car>();
	private static final Map<Long, Car> CARS_HASH = new HashMap<Long, Car>();
	
	private static final Logger LOG = Logger.getLogger(DummyCarDao.class);
	
	static {
		Car audiTT = new Car(1l, "Audi", "TT");
		Car bmwM3 = new Car(2l, "BMW", "M3");
		addCar(audiTT);
		addCar(bmwM3);	
	}
	
	public List<Car> findAllOrderByName() { 
		return CARS_LIST;
	}

	public Car findById(Long id) {
		return CARS_HASH.get(id);
	}

	public void merge(Car car) {
		if (car.getId() == null) {
			car.setId(nextId++);
			addCar(car);
		} else {
			Car existing = CARS_HASH.get(car.getId());
			existing.setMake(car.getMake());
			existing.setModel(car.getModel());
		}
	}

	public void remove(Car car) {
		Car persisted = findById(car.getId());
		removeCar(persisted);
	}

	private static void addCar(Car c) {
		CARS_LIST.add(c);
		CARS_HASH.put(c.getId(), c);
	}	
	
	private static void removeCar(Car c) {
		LOG.debug("removing car with ID " + c.getId());
		boolean removed = CARS_LIST.remove(c);
		LOG.debug("Car found in list? " + removed);
		Car removedHash = CARS_HASH.remove(c.getId());
		LOG.debug("Car found in hash? " + (removedHash != null));
	}	
	
}
