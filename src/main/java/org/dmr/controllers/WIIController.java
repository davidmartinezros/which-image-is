package org.dmr.controllers;

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
import org.springframework.web.servlet.ModelAndView;

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
    
    // La url a crida es http://localhost:8080/wii/view/form
    
    public WIIController() {
        
    }
    
    @RequestMapping(value="/askForImage", method=RequestMethod.POST)
    public @ResponseBody String handleFileUpload(@RequestParam("file") MultipartFile file) {
    	
        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();
                
                log.debug(bytes.toString());
                
                return wiiService.askForImage(bytes);
            } catch (Exception e) {
                return "You failed to upload => " + e.getMessage();
            }
        } else {
            return "You failed to upload because the file was empty.";
        }
        
    }
    
    @RequestMapping(value = "/state", method = RequestMethod.GET)
    public String getState() throws Exception {
    	
    	return "OK";
    	
    }
    
}
