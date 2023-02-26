package com.mscompra.compra.utils;

import java.util.Arrays;

public class CleanValues {

    public static String cleanStringNumberOnly(String value) {
        var numbers = Arrays.asList('1','2','3','4','5','6','7','8','9','0');
        var response = new StringBuilder();
        for (char c: value.toCharArray()) {
            if (!numbers.contains(c))
                continue;
            response.append(c);
        }
        return response.toString();
    }

}
