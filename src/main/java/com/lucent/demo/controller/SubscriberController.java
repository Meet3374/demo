package com.lucent.demo.controller;

import com.lucent.demo.model.Subscriber;
import com.lucent.demo.service.SubscriberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class SubscriberController {

    @Autowired
    SubscriberService subscriberService;

    @GetMapping("/subscribers")
    public List<Subscriber> retrieveAllSubscribers() {
        return subscriberService.retrieveAllSubscribers();
    }

    @GetMapping("/subscribers/{id}")
    public Subscriber retrieveSubscriber(@PathVariable Long id) {
        return subscriberService.getSubscriber(id);
    }

    @DeleteMapping("/subscribers/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable long id) {
        subscriberService.deleteSubscriber(id);
        return new ResponseEntity<>("Subscriber deleted successfully", HttpStatus.OK);
    }

    @PostMapping("/subscriber")
    public ResponseEntity<Object> createSubscriber(@RequestBody Subscriber subscriber) {
        Subscriber subscriberDb = subscriberService.createSubscriber(subscriber);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(subscriberDb.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping("/subscriber/{id}")
    public ResponseEntity<String> updatesubscriber(@RequestBody Subscriber subscriber, @PathVariable long id) {
        subscriberService.updateSubscriber(id, subscriber);
        return new ResponseEntity<>("Subscriber updated successfully", HttpStatus.OK);
    }
}
