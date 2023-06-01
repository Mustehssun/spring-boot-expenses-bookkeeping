package com.mustehssuniqbal.expensesbookkeeping.utils;

public class BooleanUtils {
    public static Boolean defaultIfNull(Boolean flag, boolean defaultValue) {
        return flag == null? defaultValue: flag;
    }
}
