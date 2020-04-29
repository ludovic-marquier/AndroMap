package com.example.utils;

import java.security.SecureRandom;
import java.util.Random;

public class RandomGenerator {

    private static final String CHAR_LOWER = "abcdefghijklmnopqrstuvwxyz";
    private static final String CHAR_UPPER = CHAR_LOWER.toUpperCase();
    private static final String NUMBER = "0123456789";
    private static final String DATA_FOR_RANDOM_STRING = CHAR_LOWER + CHAR_UPPER + NUMBER;
    private static SecureRandom random = new SecureRandom();
    private static final int MARKER_KEY_LENGTH = 23;

    public RandomGenerator(){

    }

    public String generateMarkerKey() {
        if (MARKER_KEY_LENGTH< 1) throw new IllegalArgumentException();
        Random random = new Random();
        StringBuilder sb = new StringBuilder(MARKER_KEY_LENGTH);
        for (int i = 0; i < MARKER_KEY_LENGTH; i++) {

            // 0-62 (exclusive), random returns 0-61
            int rndCharAt = random.nextInt(DATA_FOR_RANDOM_STRING.length());
            char rndChar = DATA_FOR_RANDOM_STRING.charAt(rndCharAt);

            // debug
            System.out.format("%d\t:\t%c%n", rndCharAt, rndChar);

            sb.append(rndChar);

        }

        return sb.toString();

    }

}
