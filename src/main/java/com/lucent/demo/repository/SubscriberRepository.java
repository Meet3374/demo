package com.lucent.demo.repository;

import com.lucent.demo.model.Subscriber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriberRepository extends JpaRepository<Subscriber, Long> {

    Subscriber findByEmail(String email);

}
