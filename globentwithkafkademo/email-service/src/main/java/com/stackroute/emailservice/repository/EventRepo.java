package com.stackroute.emailservice.repository;

import com.stackroute.emailservice.model.EventDetails;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EventRepo extends MongoRepository<EventDetails,Integer> {
}
