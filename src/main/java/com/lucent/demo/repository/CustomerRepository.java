package com.lucent.demo.repository;

import com.lucent.demo.model.Customer;
import com.lucent.demo.model.Subscriber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
