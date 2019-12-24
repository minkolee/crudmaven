package cc.conyli.pgsql;

import java.io.*;
import java.sql.*;
import java.util.Properties;

public class Test {

    public static void main(String[] args) throws IOException, SQLException {

//        String url = "jdbc:postgresql://106.54.215.164/mydb";
//        Properties props = new Properties();
//        props.setProperty("user","minkolee");
//        props.setProperty("password","fflym0709");
//        props.setProperty("currentSchema","test");
//        Connection conn = DriverManager.getConnection(url, props);

        String url = "jdbc:postgresql://106.54.215.164/mydb?user=minkolee&password=fflym0709&currentSchema=test";
        Connection conn = DriverManager.getConnection(url);

        System.out.println(conn);

        String sql = "SELECT * FROM test.department";
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            System.out.println(resultSet.getString(1));
        }
    }
}
