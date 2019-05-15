package com.example.lazyinitializationdemo.api;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.lazyinitializationdemo.dto.Address;
import com.example.lazyinitializationdemo.dto.Customer;
import com.example.lazyinitializationdemo.repo.CustomerRepository;

@RestController
@RequestMapping(value="/customer")
public class CustomerEndpoint {
	
	@Autowired
	private CustomerRepository customerRepository;

	@GetMapping
	public void addCustomer() {
		Customer c = new Customer();
		c.setName("Manjit");
		Address address = new Address();
		address.setAddressName("Manjit Address 1");
		address.setFullAddress("Discovery Garden");
		address.setCustomer(c);
		c.getAddress().add(address);
		customerRepository.save(c);
		
	}
	
	@GetMapping(value="/all")
	public List<Customer> getCustomer() {
		List<Customer> customers = new ArrayList<>();
		Iterator<Customer> itr = customerRepository.findAll().iterator();
		while(itr.hasNext()) {
			Customer customer = itr.next();
			System.out.println(customer.getAddress().get(0).getAddressName());
			customer.getAddress().get(0).setAddressName("Hello Address");
			customerRepository.save(customer);
			customers.add(customer);
		}
		return customers;
		
	}
}
