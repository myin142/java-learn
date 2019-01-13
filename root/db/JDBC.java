package root.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

import java.sql.Timestamp;
import java.sql.Time;
import java.sql.Date;

/* Java Database Connectivity Language */
public class JDBC{

    // Basic SQL Statements:
    //      INSERT: Add new row
    //      SELECT: Retrieve data
    //      UPDATE: Change rows
    //      DELETE: Remove rows

    // JDBC Interfaces: (in java.sql)
    //      Driver: how to get a connection
    //      Connection: how to communicate
    //      Statement: how to run SQL
    //      ResultSet: What was returned by SELECT query

    public static void init(){

        // JDBC URL Format: (separated by colon)
        //  1. Protocol:            always jdbc protocol
        //  2. Product/Vendor:      mysql, sqlite, ...
        //  3. Connection details:  (localhost | ip-address | domain)? + database name
        //
        // Examples:
        //      jdbc:postgresql://localhost/db
        //      jdbc:mysql://localhost:3306/db
        //      jdbc:oracle:thin:@192.168.0.123:321:db
        String url = "jdbc:derby:db";

        // Connecting Database:
        // Normally: Use DataSource Factory
        //
        // Used for exam:
        // Connection DriverManager.getConnection(String url) throws SQLException
        // Connection DriverManager.getConnection(String url, String user, String pw) throws SQLException
        //
        // Class.forName(String) throws ClassNotFoundException - loads class
        // Needed when JDBC <= 3.0 and Driver not specified in .jar file (META-INF/service/Driver)
        try(Connection conn = DriverManager.getConnection(url)){

            // Creating Statement:
            // Statement conn.createStatement() throws SQLException
            // Statement conn.createStatement(ResultSet type, ResultSet concur) throws SQLException
            //
            // ResultSet Type: (downgrade if not available)
            //      ResultSet.TYPE_FORWARD_ONLY (default)
            //      ResultSet.TYPE_SCROLL_INSENSITIVE
            //      ResultSet.TYPE_SCROLL_SENSITIVE
            //
            // ResultSet Concurrency: (downgrade if not available)
            //      ResultSet.CONCUR_READ_ONLY (default)
            //      ResultSet.CONCUR_UPDATABLE
            Statement stmt = conn.createStatement();

            // Execute Statement: (wrong sql statement in method -> SQLException)
            // int executeUpdate(String sql) throws SQLException            for changing data
            // ResultSet executeQuery(String sql) throws SQLException       for querying data
            // boolean execute(String sql) throws SQLException              true -> getResultSet(), false -> getUpdateCount()
            ResultSet result = stmt.executeQuery("SELECT * FROM table");

            // Getting Data: (column index starts with 1)
            // boolean next() throws SQLException               true if data is valid
            //
            // Only in Scrolling ResultSet: (when TYPE_FORWARD_ONLY -> SQLException)
            // void afterLast() throws SQLException
            // void beforeFirst() throws SQLException
            // boolean absolute(int) throws SQLException        / negative values -> start from end
            // boolean relative(int) throws SQLException        / if position beyond table rows -> before/after first/last row
            // boolean first() throws SQLException
            // boolean last() throws SQLException
            // boolean previous() throws SQLException
            //
            // Methods: (all accept String/int parameter and throws SQLException)
            // boolean getBoolean()             BOOLEAN
            // double getDouble()               DOUBLE
            // int getInt()                     INTEGER
            // long getLong()                   BIGINT
            // Object getObject()               Any type
            // String getString()               CHAR, VARCHAR
            // Date getDate()                   DATE                toLocalDate()
            // Time getTime()                   TIME                toLocalTime()
            // Timestamp getTimestamp()         TIMESTAMP           toLocalDateTime()
            while(result.next()){
                int id = result.getInt("id");
                String name = result.getString("name");
            }

        // Resources get closed in reverse order:
        //      ResultSet -> Statement -> Connection
        //
        // Closing Connection -> also closing Statement and ResultSet
        // Closing Statement -> also closing ResultSet
        // Running another SQL statement -> closes ResultSet
        } catch (SQLException e){

            // Printing SQL Exception Messages
            System.out.println(e.getMessage());
            System.out.println(e.getSQLState());
            System.out.println(e.getErrorCode());

        }

    }

}