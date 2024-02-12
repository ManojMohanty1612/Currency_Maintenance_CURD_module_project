package com.mashreq.com.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mashreq.com.entity.CurrencyMaintenanceEntity;
import com.mashreq.com.exception.NoCountyAvaillableInourRecord;
import com.mashreq.com.exception.UserIdNotAvailableInOutRecord;
import com.mashreq.com.service.CurrencyMaintenanceServiceImpl;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/rest")
@OpenAPIDefinition(info = @Info(version = "1.0.2", title = "CurrencyMangement"))
public class CurrencyMaintenanceController {

	private final Logger logger = LoggerFactory.getLogger((CurrencyMaintenanceController.class));

	@Autowired
	@Qualifier("currencyMaintenanceServiceImpl")
	CurrencyMaintenanceServiceImpl serviceImpl;

	@PostMapping
	@Operation(summary = "*****For create Object*****")
	public ResponseEntity<String> getAddCurrency(@Valid CurrencyMaintenanceEntity currencyMaintenanceEntity ,@RequestBody CurrencyMaintenanceEntity entity) {

		logger.info("CurrencyMaintenanceEntity"+entity.getId()+"object created in DB");
		CurrencyMaintenanceEntity currencyCustmer = serviceImpl.addCurrencyCustmer(entity);

		return new ResponseEntity<>("Record Saved" + currencyCustmer.getId(), HttpStatus.OK);
	}

	@GetMapping("/user/{id}")
	public ResponseEntity<CurrencyMaintenanceEntity> getCurrencyMaintenanceDataId(@PathVariable int id)
			throws UserIdNotAvailableInOutRecord {
		
		CurrencyMaintenanceEntity value = serviceImpl.getId(id);
		logger.info("record fatched method getCurrencyMaintenanceDataId "+ value+" from DB");
		return new ResponseEntity<CurrencyMaintenanceEntity>(value, HttpStatus.OK);

	}

	@GetMapping("/all")
	public ResponseEntity<List<CurrencyMaintenanceEntity>> getAllCurrencyMaintenanceEntity() {

		List<CurrencyMaintenanceEntity> getallCustomer = serviceImpl.getallCustomer();

		return new ResponseEntity<List<CurrencyMaintenanceEntity>>(getallCustomer, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteCustomerCurrencyMaintenance(@PathVariable int id)
			throws UserIdNotAvailableInOutRecord {

		serviceImpl.deleteCurrencyMaintenance(id);

		return new ResponseEntity<String>("user " + id + " deleted", HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<String> updateCurrencyMaintenanceEntity(@PathVariable Integer id,
			@RequestBody CurrencyMaintenanceEntity currencyMaintenanceEntity) throws UserIdNotAvailableInOutRecord {
		if (serviceImpl.isCurrencyMaintenanceEntityExist(id)) {
			serviceImpl.updateCurrencyMaintenanceEntity(currencyMaintenanceEntity);

			return new ResponseEntity<String>("id is updated", HttpStatus.OK);
		} else {
			throw new UserIdNotAvailableInOutRecord("Record is not updated");
		}

	}

	@GetMapping("/country/{coun}")
	public List<CurrencyMaintenanceEntity> featchCountryControllerCurrencyMaintenanceEntity(

			@PathVariable String coun) throws NoCountyAvaillableInourRecord {

		return serviceImpl.featchBassedOnCountryCurrencyMaintenanceEntity(coun);
	}

	@GetMapping("/gettter/{value}")
	public List<CurrencyMaintenanceEntity> getcurrencyMaintenanceEntityallGatterthenValue(@PathVariable int value) {

		return serviceImpl.getValueGratterThen(value);
	}
	@GetMapping("/setter/{value}")
	public List<CurrencyMaintenanceEntity> getcurrencyMaintenanceEntityallsetterthenValue(@PathVariable int value) {

		return serviceImpl.getValueLessThen(value);
	}

}
