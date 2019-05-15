package com.example.lazyinitializationdemo.repo;

import org.springframework.data.repository.CrudRepository;

import com.example.lazyinitializationdemo.dto.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

}
