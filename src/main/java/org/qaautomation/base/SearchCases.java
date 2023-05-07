package org.qaautomation.base;

public class SearchCases {

    /*Search test case array
    search[][0] contains input information
    search[][1] contains expected error/message information, null means no error is expected
     */

    public static final String[][] basicSearch = {
            {"Kompiuteris",null},
            {"","Paieškos sistema aptiko per daug paieškos kriterijus atitinkančių rezultatų. Prašome patikslinti paieškos kriterijus."},
            {"sadgasdzgfasdgazdf","Nėra prekių, atitinkančių užduotus paieškos kriterijus."},
            {"Televizorius",null}
    };
}
