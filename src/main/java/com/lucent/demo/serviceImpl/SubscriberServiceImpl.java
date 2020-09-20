package com.lucent.demo.serviceImpl;

import com.lucent.demo.exception.BusinessValidationException;
import com.lucent.demo.exception.EntityNotFoundException;
import com.lucent.demo.model.Subscriber;
import com.lucent.demo.repository.SubscriberRepository;
import com.lucent.demo.service.SubscriberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class SubscriberServiceImpl implements SubscriberService {

    Logger logger = LoggerFactory.getLogger(SubscriberServiceImpl.class);

    @Autowired
    SubscriberRepository subscriberRepository;


    public List<Subscriber> retrieveAllSubscribers() {
        return subscriberRepository.findAll();
    }

    public Subscriber getSubscriber(Long id) {
        Optional<Subscriber> subscriber = subscriberRepository.findById(id);
        if (subscriber.isPresent()) {
            return subscriber.get();
        } else {
            throw new EntityNotFoundException("No subscriber exists for given id" + id);
        }
    }

    public Subscriber createSubscriber(Subscriber subscriber) {
        if (Objects.isNull(subscriberRepository.findByEmail(subscriber.getEmail()))) {
            return subscriberRepository.save(subscriber);
        } else {
            throw new BusinessValidationException("Subscriber exists with given emailId");
        }
    }

    public void deleteSubscriber(Long id) {
        subscriberRepository.deleteById(id);
    }

    public void updateSubscriber(Long id, Subscriber subscriber) {
        Optional<Subscriber> subscriberDb = subscriberRepository.findById(id);
        if (!subscriberDb.isPresent()) {
            throw new EntityNotFoundException("No subscriber exists for given id" + id);
        } else {
            subscriber.setId(id);
            subscriberRepository.save(subscriber);
        }
    }
}

