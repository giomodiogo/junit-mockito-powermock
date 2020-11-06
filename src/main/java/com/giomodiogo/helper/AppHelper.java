package com.giomodiogo.helper;

import java.util.Arrays;

public class AppHelper {

    public static String removeLetter(String text, String letterToRemove) {
        return text.replaceAll(letterToRemove, "");
    }

    public static Integer[] returnsEven(Integer[] numbers) {
        return Arrays.stream(numbers).filter(number -> number % 2 == 0).toArray(Integer[]::new);
    }
}
