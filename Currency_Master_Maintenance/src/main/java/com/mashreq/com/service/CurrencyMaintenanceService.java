package com.mashreq.com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mashreq.com.entity.CurrencyMaintenanceEntity;
import com.mashreq.com.exception.NoCountyAvaillableInourRecord;
import com.mashreq.com.exception.UserIdNotAvailableInOutRecord;

@Service
public interface CurrencyMaintenanceService {

	public CurrencyMaintenanceEntity addCurrencyCustmer(CurrencyMaintenanceEntity currencyMaintenanceEntity);

	public CurrencyMaintenanceEntity getId(int id) throws UserIdNotAvailableInOutRecord;

	public List<CurrencyMaintenanceEntity> getallCustomer();

	public void deleteCurrencyMaintenance(int CurrencyMaintenanceid) throws UserIdNotAvailableInOutRecord;

	public boolean isCurrencyMaintenanceEntityExist(Integer id);

	public void updateCurrencyMaintenanceEntity(CurrencyMaintenanceEntity currencyMaintenanceEntity);

	public List<CurrencyMaintenanceEntity> featchBassedOnCountryCurrencyMaintenanceEntity(String country)
			throws NoCountyAvaillableInourRecord;
	
	public List<CurrencyMaintenanceEntity> getValueGratterThen(int id);
	
	public List<CurrencyMaintenanceEntity> getValueLessThen(int id);

}
