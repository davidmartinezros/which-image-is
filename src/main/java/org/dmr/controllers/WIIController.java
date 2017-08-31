package org.dmr.controllers;

import org.dmr.services.WIIService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by davidmartinezros on 31/08/2017.
 * 
 * email: davidnezan@gmail.com
 * 
 * web: http://davidmartinezros.com
 */
@RestController
@RequestMapping("/api")
@CrossOrigin
public class WIIController {
	
	@Autowired
    private WIIService wiiService;
	
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    
    public WIIController() {
        
    }
    
    @RequestMapping(value = "/wii/askForImage", method = RequestMethod.POST)
    public String askForImage(@RequestParam("image") byte[] image) throws Exception {
    	
    	return wiiService.askForImage(image);
        
    }
    
    @RequestMapping(value = "/howdyl/state", method = RequestMethod.GET)
    public String getState() throws Exception {
    	
    	return "OK";
    	
    }
    
}
