package com.example.demo.service;

import com.example.demo.model.Customer;

public interface CustomerService {

	public Customer get(Integer id) ;	
	public Customer save(Customer cust) ;
	public Customer update(Customer cust) ;
	public void delete(Customer cust) ;
	public void deleteById(Integer id) ;
}
