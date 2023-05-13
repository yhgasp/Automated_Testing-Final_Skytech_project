package org.qaautomation.utilities.ExceptionHandling;

import org.junit.Assert;
import java.util.List;

public class AssertEquals {

    //assertEquals to compare strings
    public static void AssertEquals(
            String testCaseName,
            String comparisonObject,
            String expected,
            String actual){

        try {
            Assert.assertEquals(expected, actual);
        } catch (AssertionError e){
            System.out.println("\nProgram encountered an error in test case: " +
                    "\"" + testCaseName + "\"" +
                    "\nExpected " + comparisonObject +
                    " (" + expected + ")" +
                    " does not match actual " + comparisonObject +
                    " (" + actual + ")");
        }
    }

    //assertEquals overloaded to compare floats
    public static void AssertEquals(
            String testCaseName,
            String comparisonObject,
            float expected,
            float actual){

        try {
            Assert.assertEquals(expected, actual, 0);
        } catch (AssertionError e){
            System.out.println("\nProgram encountered an error in test case: " +
                    "\"" + testCaseName + "\"" +
                    "\nExpected " + comparisonObject +
                    " (" + expected + ")" +
                    " does not match actual " + comparisonObject +
                    " (" + actual + ")");
        }
    }

    //assertEquals overloaded to compare int
    public static void AssertEquals(
            String testCaseName,
            String comparisonObject,
            int expected,
            int actual){

        try {
            Assert.assertEquals(expected, actual);
        } catch (AssertionError e){
            System.out.println("\nProgram encountered an error in test case: " +
                    "\"" + testCaseName + "\"" +
                    "\nExpected " + comparisonObject +
                    " (" + expected + ")" +
                    " does not match actual " + comparisonObject +
                    " (" + actual + ")");
        }
    }

    //assertEquals overloaded to compare lists
    public static void AssertEquals(
            String testCaseName,
            String comparisonObject,
            List<String> expected,
            List<String> actual){

        try {
            Assert.assertEquals(expected, actual);
        } catch (AssertionError e){
            System.out.println("\nProgram encountered an error in test case: " +
                    "\"" + testCaseName + "\"" +
                    "\nExpected " + comparisonObject +
                    " (" + expected + ")" +
                    " does not match actual " + comparisonObject +
                    " (" + actual + ")");
        }
    }
}
