package com.lucent.demo.service;

import com.lucent.demo.model.Subscriber;

import java.util.List;

public interface SubscriberService {

    List<Subscriber> retrieveAllSubscribers();

    Subscriber getSubscriber(Long id);

    void deleteSubscriber(Long id);

    Subscriber createSubscriber(Subscriber subscriber);

    void updateSubscriber(Long id, Subscriber subscriber);
}
