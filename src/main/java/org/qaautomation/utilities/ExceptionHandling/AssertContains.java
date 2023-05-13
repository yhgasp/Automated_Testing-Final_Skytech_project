package org.qaautomation.utilities.ExceptionHandling;

import org.junit.Assert;

public class AssertContains {

    public static void AssertContains(
            String testCaseName,
            String comparisonObject,
            String partialStr,
            String fullStr){

        try {
            Assert.assertTrue(fullStr.contains(partialStr));
        } catch (AssertionError e){
            System.out.println("\nProgram encountered an error in test case: " +
                    testCaseName +
                    "\nFull " + comparisonObject +
                    " (" + fullStr + ") " +
                    "does not contain expected (partial) " + comparisonObject +
                    "(" + partialStr + ").");
        }
    }
}
