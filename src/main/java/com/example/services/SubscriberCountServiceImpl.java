package com.example.services;

import com.example.data.SubscriberDataRepository;
import jakarta.inject.Singleton;

@Singleton
public class SubscriberCountServiceImpl implements SubscriberCountService{

    private final SubscriberDataRepository subscriberDataRepository;

    public SubscriberCountServiceImpl(SubscriberDataRepository subscriberDataRepository) {
        this.subscriberDataRepository = subscriberDataRepository;
    }

    @Override
    public Integer countConfirmedSubscribers() {
        return subscriberDataRepository.countByConfirmed(true);
    }
}
