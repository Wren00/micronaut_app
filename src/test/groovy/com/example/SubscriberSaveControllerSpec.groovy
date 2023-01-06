package com.example

import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpStatus
import io.micronaut.http.client.BlockingHttpClient
import io.micronaut.http.client.HttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.http.client.exceptions.HttpClientResponseException
import io.micronaut.test.extensions.spock.annotation.MicronautTest
import jakarta.inject.Inject
import spock.lang.Specification

@MicronautTest
class SubscriberSaveControllerSpec  extends Specification {

    @Inject
    @Client("/")
    HttpClient httpClient

    void "missing subscriber returns 400"() {
        given:
        BlockingHttpClient client = httpClient.toBlocking()

        when:
        client.exchange(HttpRequest.POST('/api/v1/subscriber', '{}' ))

        then:
        HttpClientResponseException e = thrown()
        HttpStatus.BAD_REQUEST ==  e.status
        e.response.contentType.isPresent()
        'application/problem+json' == e.response.contentType.get().toString()
    }
}
