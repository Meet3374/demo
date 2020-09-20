package com.lucent.demo.serviceImpl;

import com.lucent.demo.model.Customer;
import com.lucent.demo.repository.CustomerRepository;
import com.lucent.demo.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);

    @Autowired
    HttpServiceImpl httpService;

    @Autowired
    CustomerRepository customerRepository;

    public void fetchCustomersFromShopify() {
        try {
            List<Customer> customerList = httpService.fetchCustomerFromShopify();
            customerRepository.saveAll(customerList);
        } catch(Exception e) {
            logger.error(e.getMessage());
        }
    }
}
