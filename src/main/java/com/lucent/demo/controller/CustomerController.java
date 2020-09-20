package com.lucent.demo.controller;

import com.lucent.demo.response.APIResponse;
import com.lucent.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CustomerController {

    @Autowired
    CustomerService customerService;

    // To fetch customers from shopify and to store them in db
    @PostMapping("shopify/customers")
    ResponseEntity<String> fetchCustomerFromShopify() {
        customerService.fetchCustomersFromShopify();
        return new ResponseEntity<>("customers saved successfully in database", HttpStatus.OK);
    }
}
