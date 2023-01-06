package com.example

import io.micronaut.test.extensions.spock.annotation.MicronautTest
import jakarta.inject.Inject
import spock.lang.Specification
import spock.lang.Unroll

import javax.validation.Validator

@MicronautTest(startApplication = false)
class SubscriberSpec extends Specification {

    @Inject
    Validator validator

    void "no constraint violations for valid subscriber"() {
        given:
        Subscriber subscriber = new Subscriber("dorfman@gmail.com", null)
        expect:
        validator.validate(subscriber).isEmpty()
    }

    @Unroll("Subscriber email with value #email is not valid")
    void "subscriber email is required"(String email) {
        given:
        Subscriber subscriber = new Subscriber(email, null)
        expect:
        !validator.validate(subscriber).isEmpty()
        where:
        email << [null, ""]
    }

    @Unroll("Subscriber::email must be an email address")
    void "subscriber email must be a valid email"(String email) {
        given:
        Subscriber subscriber = new Subscriber("dorfman", null)
        expect:
        !validator.validate(subscriber).isEmpty()
        where:
        email << [null, ""]
    }
}
