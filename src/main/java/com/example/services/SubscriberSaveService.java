package com.example.services;

import com.example.Subscriber;
import io.micronaut.core.annotation.NonNull;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public interface SubscriberSaveService {
    void save(@NonNull @NotNull @Valid Subscriber subscriber);
}
