package com.example.services;

import com.example.data.Ksuid;
import io.micronaut.context.annotation.Bean;
import io.micronaut.core.annotation.NonNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

@Bean
public class KsuidGenerator implements IdGenerator {

    private static final Logger LOG = LoggerFactory.getLogger(KsuidGenerator.class);

    @Override
    @NonNull
    public Optional<String> generate() {
        try {
            return Optional.of(new Ksuid().generate());
        } catch(Exception e) {
                if(LOG.isErrorEnabled()) {
                    LOG.error("Exception occurred when generating ID");
                }
                return Optional.empty();
        }

    }

}
