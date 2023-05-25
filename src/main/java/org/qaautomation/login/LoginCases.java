package org.qaautomation.login;

class LoginCases {

    /*Login test case array

    login[][][0] contains test case information that is used for reference and error handling

    login[][][1] contains input information
    email, password

    login[][][2] contains expected error information, null indicates no error is expected
    */

     protected static final String[][][] cases = {
        {
            //valid login
                {"LOG001"},
                {"yhgasp@gmail.com","Testas123!"},
                {}
        },
         {
             //form submitted blank
                 {"LOG002"},
                 {"", ""},
                 {"Nenurodytas el. pašto adresas", "Nenurodytas slaptažodis"}

         },
        {
            //invalid credentials entered
                {"LOG003"},
                {"sazdgf","asgf"},
                {"Neteisingas el. pašto adresas arba / ir slaptažodis."}
        }
    };

}