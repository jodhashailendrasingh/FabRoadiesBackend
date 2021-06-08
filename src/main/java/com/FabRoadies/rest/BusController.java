package com.FabRoadies.rest;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.FabRoadies.entity.Bus;
import com.FabRoadies.service.BusService;
@RestController
@CrossOrigin(origins= {"*"})
public class BusController {
	
	  @Autowired
	   BusService busService;

	    @GetMapping("/findBuses/{source}/{destination}/{departDate}")
	    public List<Bus> findFLights(@PathVariable("source") String source, @PathVariable("destination") String destination,@PathVariable("departDate") @DateTimeFormat(pattern = "yyyy-mm-dd") Date departDate) 
	    {

	        //List <Bus> buses = busService.findBuses(source,destination,departDate);
	       
	        //return  buses;
	    	System.out.println(departDate);
	    	return null;
	    	
	    }
	   
	     
	    @GetMapping("/admin/showAllBuses")
	    @RequestMapping("/admin/showAllBuses")
	    public List<Bus> showAddFlightPage(){
	        return busService.findBuses();
	    }

	    @PostMapping("/admin/addBus")
	    public void addBus(@RequestBody Bus bus){
	    	 busService.save(bus);   
	      
	      
	    }
	    @PostMapping("/admin/deleteBus")
	    public void deleteBus(@RequestBody Bus bus){
	    	 busService.delete(bus);   
	      
	      
	    }
	    
	    

}      
