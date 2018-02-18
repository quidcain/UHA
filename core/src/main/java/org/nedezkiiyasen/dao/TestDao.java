package org.nedezkiiyasen.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TestDao {
    private static String SELECT_QUERY = "SELECT * from eptituders";
    private static final String DB_URL = "jdbc:mysql://localhost/uha";

    private static final String USER = "USER";
    private static final String PASS = "PASS";
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public List<String> select() {
        Connection conn = null;
        Statement stmt = null;
        List<String> eptitiders = new ArrayList<>();
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(SELECT_QUERY);
            while(rs.next()){
                String name = rs.getString("name");
                String side = rs.getString("side");
                eptitiders.add(String.format("Name: %s. Side: %s", name, side));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    //ignore
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    //ignore
                }
            }
        }
        return eptitiders;
    }

    public static void main(String[] args) {
        TestDao testDao = new TestDao();
        List<String> select = testDao.select();
        select.stream().forEach(System.out::println);
    }
}
