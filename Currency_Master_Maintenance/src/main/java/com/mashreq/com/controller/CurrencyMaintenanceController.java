package com.mashreq.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.mashreq.com.exception.UserIdNotAvailableInOutRecord;
import com.mashreq.com.service.CurrencyMaintenanceServiceImpl;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/rest")
@OpenAPIDefinition(info = @Info(version = "1.0.2",title = "CurrencyMangement"))
public class CurrencyMaintenanceController {

	@Autowired
	CurrencyMaintenanceServiceImpl serviceImpl;

	@PostMapping
	@Operation(summary = "*****For create Object*****")
	public ResponseEntity<String> getAddCurrency(@RequestBody CurrencyMaintenanceEntity entity) {

		CurrencyMaintenanceEntity currencyCustmer = serviceImpl.addCurrencyCustmer(entity);

		return new ResponseEntity<>("Record Saved" + currencyCustmer.getId(), HttpStatus.OK);
	}

	@GetMapping("/user/{id}")
	public ResponseEntity<CurrencyMaintenanceEntity> getCurrencyMaintenanceDataId(@PathVariable int id)
			throws UserIdNotAvailableInOutRecord {
		CurrencyMaintenanceEntity value = serviceImpl.getId(id);
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
			
			return new ResponseEntity<String>("id is updated",HttpStatus.OK);
		} else {
			throw new UserIdNotAvailableInOutRecord("Record is not updated");
		}
		

	}

}
