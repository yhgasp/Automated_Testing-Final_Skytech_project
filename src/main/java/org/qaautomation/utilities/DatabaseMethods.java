package org.qaautomation.utilities;

import org.qaautomation.utilities.TimestampGenerator;

import java.sql.*;

public class DatabaseMethods {

    //Database credentials
    private static final String url = "jdbc:postgresql://localhost/seleniumTests";
    private static final String user = "postgres";
    private static final String password = "password";

    private static String uniqueDatabaseName;


    //method to establish db connection
    public static PreparedStatement databaseConnection(String sql){
        try {
            Connection dbConn = DriverManager.getConnection(url, user, password);
            return dbConn.prepareStatement(sql);
        } catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }




    //method to create a new table for test results
    public static void createTable() {

        //generate and record a unique table name for test results (based on start time)
        uniqueDatabaseName = "testresults_" + TimestampGenerator.getTimestamp("yyyyMMdd_HHmmss");

        try {
            //create SQL string for a new table
            String testResultTable =
                    "CREATE TABLE " +
                    uniqueDatabaseName +

                    //table properties
                    "(id SERIAL PRIMARY KEY, " +
                    "test_title VARCHAR(250)," +
                    "test_result INT," +
                    "exception VARCHAR(250))";


            //execute the string above
            databaseConnection(testResultTable).executeUpdate();

            System.out.println("Table " + uniqueDatabaseName + " created successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    } //createDb

    public static void writeDb() throws SQLException {

        String writeDbLine = "INSERT INTO " +
                uniqueDatabaseName +
                " (test_title, test_result, exception) VALUES(?, ?, ?)";

        PreparedStatement pstmt = databaseConnection(writeDbLine);

        pstmt.setString(1,"whatever1");
        pstmt.setInt(2, 1);
        pstmt.setString(3,"whatever3");
        pstmt.executeUpdate();

    } //writeDb

} //class
