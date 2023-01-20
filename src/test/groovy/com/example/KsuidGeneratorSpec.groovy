package com.example

import com.example.services.KsuidGenerator
import io.micronaut.test.extensions.spock.annotation.MicronautTest
import jakarta.inject.Inject
import spock.lang.Specification


@MicronautTest(startApplication = false)
class KsuidGeneratorSpec extends Specification{

    @Inject
    KsuidGenerator ksuidGenerator

    void "Each time you invoke KsuidGenerator::generate you get a different id"() {

        given:
        Set<String> result = [] as HashSet

        when:
        20.times {
            result.add(ksuidGenerator.generate())
        }

        then:
        20 == result.size()
    }
}
