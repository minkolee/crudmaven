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

        //AS 查询同一张表与自身的查询
        String sql = "SELECT T1.name, T1.salary, T1.dept_name\n" +
                "FROM test.instructor as T1,\n" +
                "     test.instructor as T2\n" +
                "WHERE T1.salary > T2.salary and T2.dept_name='Biology' and T1.dept_name<>'Physics' and T1.dept_name<>'Biology';";
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            System.out.print(resultSet.getString(1)+"\t");
            System.out.print(resultSet.getString(2)+"\t");
            System.out.print(resultSet.getString(3)+"\n");
        }
    }
}
