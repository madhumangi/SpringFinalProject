package com.hotelapp.controllers;

import com.hotelapp.model.Address;
import com.hotelapp.service.ICustomerService;
import com.hotelapp.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("customer-api")
public class CustomerController {

    private ICustomerService customerService;
    @Autowired
    public void setCustomerService(ICustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/customers")
    ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
//        customer.setAddress(customer.getAddress());
        Customer customer1 = customerService.addCustomer(customer);
        return ResponseEntity.ok(customer1);
    }
    @PutMapping("/customers")
    ResponseEntity<Void> updateCustomer(@RequestBody Customer customer){
        customerService.updateCustomer(customer);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    @DeleteMapping("/customers/id/{customerId}")
    ResponseEntity<Void> deleteCustomer(@PathVariable("customerId")int customerId){
        customerService.deleteCustomer(customerId);
        HttpHeaders headers=new HttpHeaders();
        headers.add("desc","Deleting customer by id.");
        return ResponseEntity.status(HttpStatus.OK).headers(headers).build();
    }

    @GetMapping("/customers/id/{customerId}")
    ResponseEntity<Customer> showCustomerById(@PathVariable("customerId")int customerId){
        HttpHeaders headers=new HttpHeaders();
        headers.add("desc","Getting one customer by id.");
        return ResponseEntity.status(HttpStatus.OK).headers(headers).body(customerService.getCustomerById(customerId));
    }

    @GetMapping("/customers")
    ResponseEntity<List<Customer>> showAllCustomers(){
        HttpHeaders headers=new HttpHeaders();
        headers.add("desc","Getting all customers.");
        return ResponseEntity.status(HttpStatus.OK).headers(headers).body(customerService.getAllCustomers());
    }
}
