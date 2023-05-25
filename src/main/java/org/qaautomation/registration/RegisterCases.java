package org.qaautomation.registration;

class RegisterCases {

    //the message(s) that indicate(s) registration success (expected)
    protected static final String successMsgExpected = "Jūsų paskyra sėkmingai sukurta!";

    /*Registration test case array

    registration[][][0] contains test case information that is used for reference and error handling

    registration[][][1] contains input information
    first name, last name, phone, email, password, repeat password, terms, gdpr, marketing
    terms, gdpr and marketing strings are converted to booleans in the method that uses array data

    registration[][][2] contains expected error information, null indicates no error is expected
 */
    protected static final String[][][] cases = {

//            {
//                    //valid credentials
                        // {"REG001"},
//                    {"Vardenis", "Pavardenis", "+37060000000", "email1234536456@mail.com", "Test123!", "Test123!", "true", "true", "false"},
//                    {null}
//            },

            {
                    //repeat password mismatch
                    {"REG002"},
                    {"Vardenis", "Pavardenis", "+37060000000", "email@mail.com", "Test123!", "Test123", "true", "true", "false"},
                    {"Slaptažodžio patvirtinimas turi sutapti su slaptažodžiu."}
            },

            {
                    //password does not meet security requirements
                    {"REG003"},
                    {"Vardenis", "Pavardenis", "+37060000000", "email@mail.com", "Test", "Test", "true", "true", "false"},
                    {"Slaptažodį turi sudaryti ne mažiau 8 ženklų."}
            },
            {
                    //valid credentials BUT terms and gdpr checkboxes not ticked
                    {"REG004"},
                    {"Vardenis", "Pavardenis", "+37060000000", "email1234536456@mail.com", "Test123!", "Test123!", "false", "false", "false"},
                    {"Susipažinkite ir sutikite su svetainės www.skytech.lt taisyklėmis",
                    "Nesutikus su Privatumo apsaugos taisyklėmis, registracija negalima"}
            },

            {
                    //form submitted without any info
                    {"REG004"},
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
