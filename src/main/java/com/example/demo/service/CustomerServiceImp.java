package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;

@Service
@Transactional
public class CustomerServiceImp implements CustomerService {
	
	@Autowired
	CustomerRepository customerRepo;
	
	public Customer get(Integer id) {
		return customerRepo.getOne(id);
	}
	
	public Customer save(Customer cust) {
		Customer c = customerRepo.saveAndFlush(cust);
		return c;
	}
	
	public Customer update(Customer cust) {
		Customer c = customerRepo.getOne(cust.getId());
		c.setName(cust.getName());
		c.setPhone(cust.getPhone());
		customerRepo.save(c);
		return c;
	}
	
	public void delete(Customer cust) {
		customerRepo.deleteById(cust.getId());
	}
	
	public void deleteById(Integer id) {
		customerRepo.deleteById(id);
	}
 
}
