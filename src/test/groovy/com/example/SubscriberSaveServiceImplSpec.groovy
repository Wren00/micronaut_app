package com.example

import com.example.data.SubscriberDataRepository
import com.example.services.SubscriberSaveService
import com.example.services.SubscriberSaveServiceImpl
import io.micronaut.test.extensions.spock.annotation.MicronautTest
import jakarta.inject.Inject
import spock.lang.Specification


@MicronautTest(startApplication = false)
class SubscriberSaveServiceImplSpec extends Specification {

    @Inject
    SubscriberSaveServiceImpl subscriberSaveService

    @Inject
    SubscriberDataRepository dataRepository

    void "SubscriberSaveService saves a subscriber to the database"() {
        given:
        Subscriber subscriber = new Subscriber("tcook@apple.com", "TC")
        when:
        Optional<String> idOptional = subscriberSaveService.save(subscriber)
        then:
        dataRepository.count() == old(dataRepository.count()) + 1
        idOptional.isPresent()
        cleanup:
        dataRepository.deleteById(idOptional.get())
    }
}
