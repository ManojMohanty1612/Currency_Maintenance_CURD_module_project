package com.mashreq.com.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mashreq.com.entity.CurrencyMaintenanceEntity;

import jakarta.transaction.Transactional;
@Repository
public interface CurrencyMaintenancerepo extends JpaRepository< CurrencyMaintenanceEntity,Integer> {

	
	@Transactional
	@Modifying
	@Query("select u FROM CurrencyMaintenanceEntity u WHERE u.country=:country")
	public List<CurrencyMaintenanceEntity> getCountryCurrencyMaintenanceEntity(@Param("country")String country); 
	
	
}
