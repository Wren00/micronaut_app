package com.example

import io.micronaut.http.HttpRequest
import io.micronaut.http.client.BlockingHttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.test.extensions.spock.annotation.MicronautTest
import jakarta.inject.Inject
import spock.lang.Specification
import io.micronaut.http.client.HttpClient

@MicronautTest
class HealthSpec extends Specification {

    @Inject
    @Client("/")
    HttpClient httpClient

    void"/health endpoint is exposed"() {
        given:
        BlockingHttpClient client = httpClient.toBlocking()

        when:
        client.exchange(HttpRequest.GET("/health"))

        then:
        noExceptionThrown()
    }

}
