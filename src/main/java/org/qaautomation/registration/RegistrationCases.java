package org.qaautomation.registration;

public class RegistrationCases {

    //the message(s) that indicate(s) registration success (expected)
    public static final String successMsgExpected = "Jūsų paskyra sėkmingai sukurta!";

    /*Registration test case array

    registration[][][0] contains input information
    first name, last name, phone, email, password, repeat password, terms, gdpr, marketing
    terms, gdpr and marketing strings are converted to booleans in the method that uses array data

    registration[][][1] contains expected error information, null indicates no error is expected
 */
     public static final String[][][] cases = {

//            {
//                    //valid credentials
//                    {"Vardenis", "Pavardenis", "+37060000000", "email1234536456@mail.com", "Test123!", "Test123!", "true", "true", "false"},
//                    {null}
//            },

            {
                    //repeat password mismatch
                    {"Vardenis", "Pavardenis", "+37060000000", "email@mail.com", "Test123!", "Test123", "true", "true", "false"},
                    {"Slaptažodžio patvirtinimas turi sutapti su slaptažodžiu."}
            },

            {
                    //password does not meet security requirements
                    {"Vardenis", "Pavardenis", "+37060000000", "email@mail.com", "Test", "Test", "true", "true", "false"},
                    {"Slaptažodį turi sudaryti ne mažiau 8 ženklų."}
            },
            {
                    //valid credentials BUT terms and gdpr checkboxes not ticked
                    {"Vardenis", "Pavardenis", "+37060000000", "email1234536456@mail.com", "Test123!", "Test123!", "false", "false", "false"},
                    {"Susipažinkite ir sutikite su svetainės www.skytech.lt taisyklėmis",
                    "Nesutikus su Privatumo apsaugos taisyklėmis, registracija negalima"}
            },

            {
                    //form submitted without any info
                    {"", "", "", "", "", "", "", "", ""},
                    {"Vardas mažiausiai iš 2 raidžių.",
                    "Pavardė mažiausiai iš 2 raidžių.",
                    "Neįvestas telefono numeris.",
                    "Neįvestas arba neteisingas el. pašto adresas.",
                    "Slaptažodį turi sudaryti ne mažiau 8 ženklų.",
                    "Susipažinkite ir sutikite su svetainės www.skytech.lt taisyklėmis",
                    "Nesutikus su Privatumo apsaugos taisyklėmis, registracija negalima"}
            }
    };



}
