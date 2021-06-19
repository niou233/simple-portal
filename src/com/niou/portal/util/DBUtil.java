package com.niou.portal.util;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * <pre>
 * @Description: 数据连接工具
 * </pre>
 * @author 董珊珊<br>
 * <b>mail</b> dongshanshan@syncsoft.com<br>
 * <b>date</b> 2021/06/19 13:50<br>
 * @version 1.0.0
 * <pre>
 * 修改记录
 *  版本号		修订日期		修改人		bug编号		修改内容
 *  1.0.0		2021/06/19 	董珊珊		    		新建
 * </pre>
 */
public class DBUtil {
    private static String url = "";
    private static String user = "";
    private static String password = "";

    static {
        Properties props = new Properties();
        InputStream in = DBUtil.class.getClassLoader().getResourceAsStream("db.properties");
        try {
            props.load(in);
            url = props.getProperty("url");
            user = props.getProperty("user");
            password = props.getProperty("password");
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * <pre>
     * 获取数据库连接
     * </pre>
     * @author 董珊珊
     * @return java.sql.Connection
     * @throws
     */
    public static Connection getConn() {
        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            return  conn;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * <pre>
     * 关闭数据库连接
     * </pre>
     * @author 董珊珊
     * @param conn
     * @param statement
     * @param resultSet
     * @return void
     * @throws
     */
    public static void close(Connection conn, Statement statement, ResultSet resultSet) {
        if(conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
