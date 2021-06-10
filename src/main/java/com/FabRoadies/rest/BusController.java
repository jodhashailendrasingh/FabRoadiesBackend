package com.FabRoadies.rest;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.FabRoadies.dto.BookingRequest;
import com.FabRoadies.entity.Bus;
import com.FabRoadies.entity.Busquery;
import com.FabRoadies.entity.Ticket;
import com.FabRoadies.service.BusBookService;
import com.FabRoadies.service.BusService;
@RestController
@CrossOrigin(origins= {"*"})
public class BusController {
	
	  @Autowired
	   BusService busService;


		@RequestMapping(value = "/findbus",method = RequestMethod.POST)
		 public String completeReservation(@RequestBody Busquery query){
	      
	       // Ticket reservation=reservationService.bookBus(reservationRequest);
			System.out.println(query.getSource()+" "+query.getDestination()+" "+query.getDateofDeparture());
			
	         return null;
	      
	    }  

	  /*
	  @GetMapping("/findBuses/{source}/{destination}/{departDate}")
	    public List<Bus> findFLights(@PathVariable("source") String source, @PathVariable("destination") String destination, @PathVariable("departDate") String departDate) throws ParseException 
	    {

	    	//,@RequestBody @DateTimeFormat(pattern = "yyyy-mm-dd") Date departDate
	        //List <Bus> buses = busService.findBuses(source,destination,departDate);
	       
	        //return  buses;
	    //	System.out.println(departDate);
	    	
	    	 //String testDateString = "02/04/2014";
	    	 DateFormat df = new SimpleDateFormat("yyyy-mm-dd"); 
	    	 Date d1 = df.parse(departDate);
	    	 System.out.println("Date in dd/MM/yyyy format is: "+df.format(d1)+d1);
	    	// List <Bus> buses = busService.findBuses(source,destination,df.format(d1));
	    	
	    	return null;
	    	
	    }   */
	   
	
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
