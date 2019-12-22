package com.boot;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;

import com.boot.controller.ShipwreckController;
import com.boot.model.Shipwreck;
import com.boot.repository.ShipwreckRepository;

import static org.junit.Assert.assertEquals;

public class ShipwreckControllerTest {
	@InjectMocks
	private ShipwreckController sc;
	
	@Mock
	private ShipwreckRepository sr;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testShipwreckGet() {
		Shipwreck sw= new Shipwreck();
		sw.setId(1l);
		when(sr.findOne(1l)).thenReturn(sw);
		Shipwreck wreck=sc.get(1l);
		assertEquals(wreck.getId().longValue(),1l);
		
	}

}
