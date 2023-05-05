package org.qaautomation.base;

public class TestCases {

    /*Registration test case array
first name, last name, phone, email, password, repeat password, terms, gdpr, marketing
terms, gdpr and marketing strings are converted to booleans in the method that uses array data */
     public static final String[][] registration = {
            //valid credentials
            {"Vardenis", "Pavardenis", "+37060000000", "email@mail.com", "Test123!", "Test123!", "true", "true", "false"},
            //repeat password mismatch
            {"Vardenis", "Pavardenis", "+37060000000", "email@mail.com", "Test123!", "Test123", "true", "true", "false"},
            //password does not meet security requirements
            {"Vardenis", "Pavardenis", "+37060000000", "email@mail.com", "Test", "Test", "true", "true", "false"},
    };

}
