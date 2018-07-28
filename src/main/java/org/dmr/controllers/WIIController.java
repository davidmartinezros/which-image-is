package org.dmr.controllers;

import java.util.List;

import org.dmr.model.Intent;
import org.dmr.services.WIIService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by davidmartinezros on 31/08/2017.
 * 
 * email: davidnezan@gmail.com
 * 
 * web: http://davidmartinezros.com
 */
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class WIIController {
	
	@Autowired
    private WIIService wiiService;
	
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    
    // La url a crida es http://localhost:8080/wii/view/form
    
    public WIIController() {
        
    }
    
    @RequestMapping(value="/askForImageOneLabel", method=RequestMethod.POST)
    public @ResponseBody String askForImageOneLabel(@RequestParam("file") MultipartFile file) throws Exception {
    	
        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();
                
                log.debug(bytes.toString());
                
                return wiiService.askForImageOneLabel(bytes);
            } catch (Exception e) {
            	throw e;
            }
        } else {
        	throw new Exception("You failed to upload because the file was empty.");
        }
        
    }
    
    @RequestMapping(value="/askForImageAllLabels", method=RequestMethod.POST)
    public @ResponseBody List<Intent> askForImageAllLabels(@RequestParam("file") MultipartFile file) throws Exception {
    	
        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();
                
                log.debug(bytes.toString());
                
                return wiiService.askForImageAllLabels(bytes);
            } catch (Exception e) {
                throw e;
            }
        } else {
            throw new Exception("You failed to upload because the file was empty.");
        }
        
    }
    
    @RequestMapping(value = "/state", method = RequestMethod.GET)
    public String getState() throws Exception {
    	
    	return "OK";
    	
    }
    
}
