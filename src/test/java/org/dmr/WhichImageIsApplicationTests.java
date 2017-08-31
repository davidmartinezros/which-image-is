package org.dmr;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by davidmartinezros on 22/04/2017.
 * 
 * email: davidnezan@gmail.com
 * 
 * web: http://davidmartinezros.com
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class WhichImageIsApplicationTests {

	@Before
	public void setUp(){
		
	}

	@Test
	public void test_proves(){

		assertEquals(true, true);
	}

}
