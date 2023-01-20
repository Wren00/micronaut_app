package com.example.api.v1;

import com.example.services.SubscriberCountService;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Produces;
import io.micronaut.scheduling.TaskExecutors;
import io.micronaut.scheduling.annotation.ExecuteOn;

import static com.example.api.v1.Api.SUBSCRIBER_PATH;
import static com.example.api.v1.Api.V1_PATH;

@Controller(V1_PATH)
class SubscriberCountController {

    private final SubscriberCountService subscriberCountService;

    public SubscriberCountController(SubscriberCountService subscriberCountService) {
        this.subscriberCountService = subscriberCountService;
    }

    @ExecuteOn(TaskExecutors.IO)
    @Get(SUBSCRIBER_PATH + "/count")
    @Produces(MediaType.TEXT_PLAIN)
    Integer count() {
       return subscriberCountService.countConfirmedSubscribers();
    }
}
