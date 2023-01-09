package com.example

import com.example.services.SubscriberSaveService
import io.micronaut.context.annotation.Property
import io.micronaut.context.annotation.Replaces
import io.micronaut.context.annotation.Requires
import io.micronaut.core.annotation.NonNull;
import io.micronaut.test.extensions.spock.annotation.MicronautTest
import jakarta.inject.Inject
import jakarta.inject.Singleton;
import spock.lang.Specification

import javax.validation.ConstraintViolationException
import javax.validation.Valid
import javax.validation.constraints.NotNull;


@MicronautTest(startApplication = false)
@Property(name = "spec.name", value = "SubscriberSaveServiceSpec")
class SubscriberSaveServiceSpec extends Specification {

    @Inject
    SubscriberSaveService subscriberSaveService

    Subscriber subscriber


    void "SubscriberSaveService parameter cannot be null"() {
        when:
        subscriberSaveService.save(null)
        then:
        thrown(ConstraintViolationException)
    }

    void "SubscriberSaveService::save parameter must include valid email address"() {
        given:
        subscriber = new Subscriber("bad-email", null)

        when:
        subscriberSaveService.save(subscriber)

        then:
        thrown(ConstraintViolationException)
    }


    @Requires(property = "spec.name", value = "SubscriberSaveServiceSpec")
    @Replaces(SubscriberSaveService)
    @Singleton
    static class SubscriberSaveServiceReplacement implements SubscriberSaveService {

        @Override
        void save(@NonNull @NotNull @Valid Subscriber subscriber) {

        }
    }
}

