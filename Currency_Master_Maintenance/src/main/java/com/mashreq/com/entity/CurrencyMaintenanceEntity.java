package com.mashreq.com.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "CURR_MAIN")
public class CurrencyMaintenanceEntity {

	
	
/*	DB : Curr_code, Desc, Country, Date, Value 
	
	(INR, Indian rupees, 9-Nov-23, 80)*/
	
	@Id
	@GeneratedValue
	private int id;

	
	private  String curr_code;
	
	private String desc;
	
	private String country;
	
	private LocalDate localdate;
	
	private long value;

	public CurrencyMaintenanceEntity() {
		super();
	}

	
	public CurrencyMaintenanceEntity(int id, String curr_code, String desc, String country, LocalDate localdate,
			long value) {
		super();
		this.id = id;
		this.curr_code = curr_code;
		this.desc = desc;
		this.country = country;
		this.localdate = localdate;
		this.value = value;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCurr_code() {
		return curr_code;
	}

	public void setCurr_code(String curr_code) {
		this.curr_code = curr_code;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public LocalDate getLocaldate() {
		return localdate;
	}

	public void setLocaldate(LocalDate localdate) {
		this.localdate = localdate;
	}

	public long getValue() {
		return value;
	}

	public void setValue(long value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "CurrencyMaintenanceEntity [id=" + id + ", curr_code=" + curr_code + ", desc=" + desc + ", country="
				+ country + ", localdate=" + localdate + ", value=" + value + "]";
	}
	

	
	
	
}
