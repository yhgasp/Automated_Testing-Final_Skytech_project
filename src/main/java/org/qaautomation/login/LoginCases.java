package org.qaautomation.login;

class LoginCases {

    //the message(s) that indicate(s) login success (expected)
    protected static final String successMsgExpected = "Mano paskyra";


    /*Login test case array

    login[][][0] contains input information
    email, password

    login[][][1] contains expected error information, null indicates no error is expected
    */

     protected static final String[][][] cases = {
        {
            //valid login
                {"",""},
                {null}
        },
         {
             //form submitted blank
                 {"", ""},
                 {"Nenurodytas el. pašto adresas", "Nenurodytas slaptažodis"}

         },
        {
            //invalid credentials entered
                {"sazdgf","asgf"},
                {"Neteisingas el. pašto adresas arba / ir slaptažodis."}
        }
    };

}