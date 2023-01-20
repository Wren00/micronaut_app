package com.example.services;

import com.example.Subscriber;
import io.micronaut.core.annotation.NonNull;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Optional;

public interface SubscriberSaveService {
    Optional<String> save(@NonNull @NotNull @Valid Subscriber subscriber);
}
