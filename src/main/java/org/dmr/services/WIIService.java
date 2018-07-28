package org.dmr.services;

import java.util.List;

import org.dmr.model.Intent;

/**
 * Created by davidmartinezros on 31/08/2017.
 * 
 * email: davidnezan@gmail.com
 * 
 * web: http://davidmartinezros.com
 */
public interface WIIService {
	
	// CRUD USER
	
	public String askForImageOneLabel(byte[] imageBytes);
    
	public List<Intent> askForImageAllLabels(byte[] imageBytes) ;
	
}
