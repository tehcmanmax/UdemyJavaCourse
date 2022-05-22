package com.practice;

import java.sql.*;

/*IMPLEMENT
 *1. CRUD operations
 * 2. LEARN DB browser
 * 3. Remove the repetitive code
 */

public class Main {

    //FIXING HARDCODED SQL
    public static String CONNECTION_CONTACTS = "jdbc:sqlite:/home/max/IdeaProjects/Udemy Course/19thSection/3JDBCWithContacts/Contacts.db\n";
    public static String TABLE_CONTACTS = "Contacts";
    public static String COLUMN_NAME = "Name";
    public static String COLUMN_LASTNAME = "LastName";
    public static String COLUMN_AGE = "Age";


    public static void main(String[] args){
        // write your code here
        try(Connection conn = DriverManager.getConnection(CONNECTION_CONTACTS);
            Statement statement = conn.createStatement()){
            conn.setAutoCommit(true);

            //CREATE, INSERT, UPDATE, DELETE
            statement.execute("DROP TABLE IF EXISTS " + TABLE_CONTACTS);
            statement.execute("CREATE TABLE IF NOT EXISTS  Contacts ( " + COLUMN_NAME + " TEXT, " +
                                      COLUMN_LASTNAME + " TEXT, " +
                                      COLUMN_AGE + " INTEGER)");
            statement.execute("INSERT INTO " + TABLE_CONTACTS +
                                      " VALUES (\"Max\", \"D\", 21)");

            statement.execute("INSERT INTO " +TABLE_CONTACTS +
                                      " (" +
                                      COLUMN_NAME + ", " +
                                      COLUMN_NAME +
                                      ") VALUES ('John', 'Wick')");
            statement.execute("UPDATE " + TABLE_CONTACTS + " SET " +
                                      COLUMN_NAME + " = 'James', " +
                                      COLUMN_LASTNAME + " = 'Bond', " +
                                      COLUMN_AGE + " = 36 WHERE " +
                                      COLUMN_LASTNAME + " = 'Wick'");

            statement.execute("INSERT INTO " + TABLE_CONTACTS +
                                        "(" + COLUMN_NAME +", " + COLUMN_LASTNAME +
                                      " ) VALUES ('Бомж', 'Евгений')");
            statement.execute("DELETE FROM "+ TABLE_CONTACTS
                                      + " WHERE " +
                                      COLUMN_NAME + " = 'Бомж'"); // DELETING A ROW!
            statement.execute("INSERT INTO " + TABLE_CONTACTS +
                                      "(" +
                                      COLUMN_NAME + ") " +
                                      "VALUES ('Batman')");

            //statement.execute("select * from Contacts");
            //ResultSet result = statement.getResultSet();

            ResultSet result = statement.executeQuery("select * from " + TABLE_CONTACTS);
            while(result.next()){
                System.out.print(result.getString(1) + " ");
                System.out.print(result.getString(2) + " ");
                System.out.print(result.getString(3) + " ");
                System.out.println();
            }
            result.close();

        }
        catch(SQLException e){
            System.out.println("Error occurred\n" + e); //without this, my program would appear working fine
            e.printStackTrace();
        }
    }

}
