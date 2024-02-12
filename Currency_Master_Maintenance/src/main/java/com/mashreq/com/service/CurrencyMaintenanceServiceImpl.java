package com.mashreq.com.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mashreq.com.entity.CurrencyMaintenanceEntity;
import com.mashreq.com.exception.NoCountyAvaillableInourRecord;
import com.mashreq.com.exception.UserIdNotAvailableInOutRecord;
import com.mashreq.com.repo.CurrencyMaintenancerepo;

@Service
public class CurrencyMaintenanceServiceImpl implements CurrencyMaintenanceService {

	@Autowired
	private CurrencyMaintenancerepo repo;

	@Override
	public CurrencyMaintenanceEntity addCurrencyCustmer(CurrencyMaintenanceEntity currencyMaintenanceEntity) {

		LocalDate date = LocalDate.now();
		currencyMaintenanceEntity.setLocaldate(date);
		CurrencyMaintenanceEntity currencyMaintenanceData = repo.save(currencyMaintenanceEntity);

		return currencyMaintenanceData;
	}

//get by id
	@Override
	public CurrencyMaintenanceEntity getId(int id) throws UserIdNotAvailableInOutRecord {
		Optional<CurrencyMaintenanceEntity> byId = repo.findById(id);
		if (byId.isPresent()) {
			CurrencyMaintenanceEntity currencyMaintenanceEntity = byId.get();
			return currencyMaintenanceEntity;
		} else {
			throw new UserIdNotAvailableInOutRecord("Id not exist" + id);
		}

	}

	@Override
	public List<CurrencyMaintenanceEntity> getallCustomer() {

		List<CurrencyMaintenanceEntity> allEntity = repo.findAll();

		return allEntity;
	}

	@Override
	public void deleteCurrencyMaintenance(int CurrencyMaintenanceId) throws UserIdNotAvailableInOutRecord {
		CurrencyMaintenanceEntity id = getId(CurrencyMaintenanceId);

		repo.delete(id);

	}

	@Override
	public boolean isCurrencyMaintenanceEntityExist(Integer id) {

		return repo.existsById(id);
	}

	@Override
	public void updateCurrencyMaintenanceEntity(CurrencyMaintenanceEntity currencyMaintenanceEntity) {
		repo.save(currencyMaintenanceEntity);

	}

	@Override
	public List<CurrencyMaintenanceEntity> featchBassedOnCountryCurrencyMaintenanceEntity(String country)
			throws NoCountyAvaillableInourRecord {

		List<CurrencyMaintenanceEntity> countrybasedonCurrencyMaintenanceEntity = repo
				.getCountryCurrencyMaintenanceEntity(country);
		if (countrybasedonCurrencyMaintenanceEntity.isEmpty()) {

			throw new NoCountyAvaillableInourRecord("no "+"+"+country+"+"+"country found in our record");
		}

		else {

			return countrybasedonCurrencyMaintenanceEntity;
		}

	}

	@Override
	public List<CurrencyMaintenanceEntity> getValueGratterThen(int id) {

		List<CurrencyMaintenanceEntity> currencyMaintenanceEntityall = repo.findAll();
		
		List<CurrencyMaintenanceEntity> currencyMaintenanceEntityallGetGatterThen = currencyMaintenanceEntityall.stream().filter(filterValue -> filterValue.getValue()>id).collect(Collectors.toList());
		
		return currencyMaintenanceEntityallGetGatterThen;
	}
	@Override
	public List<CurrencyMaintenanceEntity> getValueLessThen(int id) {

		List<CurrencyMaintenanceEntity> currencyMaintenanceEntityall = repo.findAll();
		
		List<CurrencyMaintenanceEntity> currencyMaintenanceEntityallGetsetterThen = 
				currencyMaintenanceEntityall.stream().filter(filterValue -> filterValue.getValue()<id)
				                                                    .collect(Collectors.toList());
		
		return currencyMaintenanceEntityallGetsetterThen;
	}

}
