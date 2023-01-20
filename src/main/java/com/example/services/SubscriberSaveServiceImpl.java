package com.example.services;

import com.example.Subscriber;
import com.example.data.SubscriberDataRepository;
import com.example.data.SubscriberEntity;
import io.micronaut.context.annotation.Bean;
import io.micronaut.core.annotation.NonNull;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Optional;

@Bean
public class SubscriberSaveServiceImpl implements SubscriberSaveService {
        private final IdGenerator idGenerator;
        private final SubscriberDataRepository subscriberDataRepository;


    public SubscriberSaveServiceImpl(IdGenerator idGenerator, SubscriberDataRepository subscriberDataRepository) {
        this.idGenerator = idGenerator;
        this.subscriberDataRepository = subscriberDataRepository;
    }

    @Override
    public Optional<String> save(@NonNull @NotNull @Valid Subscriber subscriber) {
        return idGenerator.generate().map(id -> {
            SubscriberEntity entity = new SubscriberEntity(id, subscriber.getEmail(), subscriber.getName(), false);
            subscriberDataRepository.save(entity);
            return id;
        });
    }
}
