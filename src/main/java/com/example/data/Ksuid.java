package com.example.data;

import io.micronaut.core.annotation.NonNull;

import java.util.Optional;
import java.util.Random;

public class Ksuid {

    String id;

    public String getId() {
        return id;
    }

    public String generate() {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int)
                    (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        System.out.println(buffer);
        return id = buffer.toString();
    }

}
