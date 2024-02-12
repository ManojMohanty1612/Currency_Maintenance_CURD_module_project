package com.mashreq.com.testservice;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.mashreq.com.entity.CurrencyMaintenanceEntity;
import com.mashreq.com.exception.NoCountyAvaillableInourRecord;
import com.mashreq.com.exception.UserIdNotAvailableInOutRecord;
import com.mashreq.com.repo.CurrencyMaintenancerepo;
import com.mashreq.com.service.CurrencyMaintenanceService;

@SpringBootTest
public class TestCurrencyMaintenanceService {

	@Autowired
	private CurrencyMaintenanceService service;
	@MockBean
	private CurrencyMaintenancerepo repo;

	// @Test
	public void testSave() {

		CurrencyMaintenanceEntity currencyMaintenanceEntity = new CurrencyMaintenanceEntity();
		currencyMaintenanceEntity.setCountry("IND");
		currencyMaintenanceEntity.setCurr_code("IN");
		currencyMaintenanceEntity.setDesc("aaa");
		currencyMaintenanceEntity.setId(111);
		currencyMaintenanceEntity.setLocaldate(LocalDate.now());
		currencyMaintenanceEntity.setValue(121);
		Mockito.when(repo.save(currencyMaintenanceEntity)).thenReturn(currencyMaintenanceEntity);

		assertEquals(currencyMaintenanceEntity, service.addCurrencyCustmer(currencyMaintenanceEntity));

	}

	// @Test
	public void getAllRecordTest() {

		List<CurrencyMaintenanceEntity> list = new ArrayList<>();
		list.add(new CurrencyMaintenanceEntity(121, "ind", "from indai", "India", LocalDate.now(), 12000));
		list.add(new CurrencyMaintenanceEntity(121, "ind", "from indai", "India", LocalDate.now(), 12000));

		Mockito.when(repo.findAll()).thenReturn(list);
		assertEquals(2, service.getallCustomer().size());

	}

	// @Test
	public void GetIdTest() throws UserIdNotAvailableInOutRecord {

		int id = 101;
		Mockito.when(repo.findById(id)).thenReturn(
				Optional.of(new CurrencyMaintenanceEntity(101, "ind", "from indai", "India", LocalDate.now(), 12000)));

		assertEquals(id, service.getId(id).getId());

	}


	//@Test
	public void countryCurrencyMaintenanceTest() throws NoCountyAvaillableInourRecord {
		String str = "India";
		List<CurrencyMaintenanceEntity> list = new ArrayList<>();
		list.add(new CurrencyMaintenanceEntity(121, "ind", "from indai", "India", LocalDate.now(), 12000));
		list.add(new CurrencyMaintenanceEntity(121, "ind", "from indai", "India", LocalDate.now(), 12000));

		Mockito.when(repo.getCountryCurrencyMaintenanceEntity(str))
	                                                  	.thenReturn(list);

		assertEquals(str, service.featchBassedOnCountryCurrencyMaintenanceEntity(str));
	}
	
	@Test
	public void testGatthernValue() {
		
		int value=5000;
		List<CurrencyMaintenanceEntity> list = new ArrayList<>();
		list.add(new CurrencyMaintenanceEntity(121, "ind", "from indai", "India", LocalDate.now(), 12000));
		list.add(new CurrencyMaintenanceEntity(121, "ind", "from indai", "India", LocalDate.now(), 15870));

		
		Mockito.when(repo.findAll()).thenReturn(list);
		
		assertEquals(list, service.getValueGratterThen(value));
	}
	
	@Test
	public void testLessThernValue() {
		
		int value=5000;
		List<CurrencyMaintenanceEntity> list = new ArrayList<>();
		list.add(new CurrencyMaintenanceEntity(121, "ind", "from indai", "India", LocalDate.now(), 3000));
		list.add(new CurrencyMaintenanceEntity(121, "ind", "from indai", "India", LocalDate.now(), 1870));

		
		Mockito.when(repo.findAll()).thenReturn(list);
		
		assertEquals(list, service.getValueLessThen(value));
	}

}
