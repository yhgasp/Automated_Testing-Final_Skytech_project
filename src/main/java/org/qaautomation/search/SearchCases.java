package org.qaautomation.search;

class SearchCases {

    /*Search test case array
    search[][0] contains input information
    search[][1] contains expected error/message information, null means no error is expected
     */

    protected static final String[] casesInput = {
            //all latin characters, uppercase and lowercase
            "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz",
            //all lithuanian characters, uppercase and lowercase,
            "ĄČĘĖĮŠŲŪŽąčęėįšųūž",
            //common symbols
            "} { ] [ ) ( ~ ! @ # $ % ^ & ` | \\ : \" ; ' < > ? , . ⁄ - +",
            //numbers as search key
            "0123456789",
            //500 character long search term
            "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
            "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
            "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
            "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
            "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"

    };

    protected static final String[][] casesResults = {

            //regular string input
            {"Kompiuteris",null},

            //regular string input with irregular case
            {"kOmPIuTeRiS",null},

            //regular string with leading and trailing spaces
            {" kompiuteris ",null},

            //blank input - too many matches
            {"","Paieškos sistema aptiko per daug paieškos kriterijus atitinkančių rezultatų. Prašome patikslinti paieškos kriterijus."},

            //input that has no matches
            {"sadgasdzgfasdgazdf","Nėra prekių, atitinkančių užduotus paieškos kriterijus."}

    };
}
