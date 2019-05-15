package com.example.lazyinitializationdemo.dto;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ADDRESS")
public class Address {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "ADDRESS_ID")
    protected Long id;
	
	@Column(name="address_name")
	private String addressName;
	
	@Column(name="full_address")
	private String fullAddress;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, targetEntity = Customer.class, optional=false)
    @JoinColumn(name = "CUSTOMER_ID")
    protected Customer customer;

	public String getAddressName() {
		return addressName;
	}

	public void setAddressName(String addressName) {
		this.addressName = addressName;
	}

	public String getFullAddress() {
		return fullAddress;
	}

	public void setFullAddress(String fullAddress) {
		this.fullAddress = fullAddress;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	

}
