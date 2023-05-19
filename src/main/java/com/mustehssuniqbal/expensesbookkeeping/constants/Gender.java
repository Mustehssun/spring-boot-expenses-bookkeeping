package com.mustehssuniqbal.expensesbookkeeping.constants;

public enum Gender {
    MALE("M"),
    FEMALE("F"),
    UNSPECIFIED("U");

    private String val;

    private Gender(String val) {
        this.val = val;
    }

    public String toString() {
        return this.val;
    }
}
