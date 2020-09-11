package com.example.demo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.CustomerDTO;
import com.example.demo.model.Customer;
import com.example.demo.service.CustomerService;

@RestController
@RequestMapping("customers")
public class CustomerManageController {
	
	@Autowired
	CustomerService custService ;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET,
			produces = "application/json"
	)
	public CustomerDTO getCustomer(@PathVariable Integer id) {
		Customer c = custService.get(id);
		CustomerDTO custDTO = new CustomerDTO();
		custDTO.setId(c.getId());
		custDTO.setName(c.getName());
		custDTO.setPhone(c.getPhone());
		return custDTO;
	}
	
	@RequestMapping(method = RequestMethod.POST,
			produces = "application/json"
	)
	public Map<String,String>  createCustomer(@RequestBody CustomerDTO custDTO) {
		Customer customer = new Customer();
		customer.setId(custDTO.getId());
		customer.setName(custDTO.getName());
		customer.setPhone(custDTO.getPhone());
		System.out.println("customer: " + customer.getName() + " phone: " + customer.getPhone());
		Customer cust = custService.save(customer);
		
		Map<String,String> response = new HashMap<>();
		
		response.put("retStat", "0");
		response.put("id", "" + cust.getId());
		
		return response;
	}
	
	@RequestMapping(method = RequestMethod.PUT,
			produces = "application/json"
	)
	public Map<String,String>  updateCustomer(@RequestBody CustomerDTO custDTO) {
		Customer customer = new Customer();
		customer.setId(custDTO.getId());
		customer.setName(custDTO.getName());
		customer.setPhone(custDTO.getPhone());
		System.out.println("customer: " + customer.getName() + " phone: " + customer.getPhone());
		Customer cust = custService.update(customer);
		
		Map<String,String> response = new HashMap<>();
		
		response.put("retStat", "0");
		response.put("id", "" + cust.getId());
		
		return response;
	}
	
	@RequestMapping(method = RequestMethod.DELETE,
			produces = "application/json"
	)
	public Map<String,String> deleteCustomer(@RequestParam Integer id ) {
		custService.deleteById(id);
		
		Map<String,String> response = new HashMap<>();
		response.put("retStat", "0");
		
		return response;
	}
	
}
