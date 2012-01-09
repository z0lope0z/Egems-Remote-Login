package com.tsl.example.cars.view;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.tsl.example.cars.dao.CarDao;
import com.tsl.example.cars.dao.dummy.DummyCarDao;
import com.tsl.example.cars.model.Car;

/**
 * Spring MVC controller for Car operations. 
 * 
 * @author Kevin McCormack (The Server Labs)
 *
 */ 
@Controller
public class CarController {
    
    private static final String FORM_VIEW_KEY = "/cars/car";
    private static final String LIST_VIEW_KEY = "/cars/list";
    private static final String REDIRECT_LIST_VIEW_KEY = 
        "redirect:" + LIST_VIEW_KEY + ".html";
    private static final String FORM_MODEL_KEY = "car";
    private static final String LIST_MODEL_KEY = "cars";
    
    private static CarDao carDao = new DummyCarDao();
    
    /**
    * Show the 'create car' page. We add a new Car object to the ModelAndView
    * for display in the JSP.  
    * 
    * @return the create car page
    */
    @RequestMapping(value="/cars/create.html")
    public ModelAndView create() {
        return new ModelAndView(FORM_VIEW_KEY, FORM_MODEL_KEY, new Car());
    }
    
    
    /**
     * Show a car by it's ID. 
     * 
     * @param id the ID of the car.
     * @return the edit car page
     */
    @RequestMapping(value="/cars/info.html")
    public ModelAndView info(@RequestParam("id") Long id) {
        Car result = carDao.findById(id);
        return new ModelAndView(FORM_VIEW_KEY, FORM_MODEL_KEY, result);
    }

    /**
     * Save a car. It can either be new or for editing it. 
     * 
     * @param car the Car to save. 
     * @return the list cars page (redirected)  
     */
    @RequestMapping(value="/cars/save.html")
    public ModelAndView save(Car car) {
        carDao.merge(car);
        return new ModelAndView(REDIRECT_LIST_VIEW_KEY, list());
    }

    /**
     * Delete a Car.
     * 
     * @param id the Id of the car to remove.
     * @return the list cars page (redirected)  
     */
    @RequestMapping(value="/cars/delete.html")
    public ModelAndView delete(@RequestParam("id") Long id) {
        Car car = new Car();
        car.setId(id);
        carDao.remove(car);
        return new ModelAndView(REDIRECT_LIST_VIEW_KEY, list());
    }
    
    /**
     * List the cars in the system by name.
     *  
     * @return the list cars page.
     */
    @RequestMapping(value="/cars/list.html")
    public ModelMap list() {
        return new ModelMap(LIST_MODEL_KEY, 
                carDao.findAllOrderByName());
    }

	public void setCarDao(CarDao carDao) {
		this.carDao = carDao;
	}    

}
