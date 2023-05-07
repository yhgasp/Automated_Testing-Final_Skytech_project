package org.qaautomation.base;

public class LoginCases {

    //the message(s) that indicate(s) login success (expected)
    public static final String logSuccessExpected = "Mano paskyra";


    /*Login test case array

    login[][][0] contains input information
    email, password

    login[][][1] contains expected error information, null indicates no error is expected
    */

     public static final String[][][] login = {
            {
                    //form submitted blank
                    {"", ""},
                    {"Nenurodytas el. pašto adresas","Nenurodytas slaptažodis"}
            },
             {
                 //invalid credentials entered
                     {"sazdgf","asgf"},
                     {"Neteisingas el. pašto adresas arba / ir slaptažodis."}
             }
    };

}