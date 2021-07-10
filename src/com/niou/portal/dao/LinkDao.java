package com.niou.portal.dao;

import com.niou.portal.bean.Data;
import com.niou.portal.bean.Link;
import com.niou.portal.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 * @Description:
 * </pre>
 * @Auther: Niou
 * @Date: 2021/6/19 15:00
 */
public class LinkDao implements BaseLinkDao {
    private static final String SQL_FIND_ALL = "select * from kkb_link l,kkb_type t order by t.sort,l.sort";
    private static final String SQL_FIND_BY_ID = "select content from kkb_link l where l.id=?";

    @Override
    public List<Data> findALl() {
        //1.准备一个集合存储查询结果
        List<Data> data = new ArrayList<>();
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            //2.数据库连接
            conn = DBUtil.getConn();
            //3.预编译数据库的SQL
            statement = conn.prepareStatement(SQL_FIND_ALL);
            //4.执行查询
            resultSet = statement.executeQuery();
            int tempSort = 0;
            Data d1 = null;
            List<Link> links = null;
            //5.取出查询结果
            while (resultSet.next()){
                //6.遍历查询结果，并放入集合中
                int sort = resultSet.getInt("t.sort");
                if(tempSort != sort ) {
                    d1 = new Data();
                    d1.setType(resultSet.getString("name"));
                    links = new ArrayList<>();
                    d1.setLinks(links);
                    data.add(d1);
                }
                String content = resultSet.getString("content");
                String description = resultSet.getString("description");
                String title = resultSet.getString("title");
                int count = resultSet.getInt("count");
                int icon = resultSet.getInt("icon");
                int id = resultSet.getInt("l.id");
                int sort1 = resultSet.getInt("sort");
                int typeId = resultSet.getInt("t.id");
                Link link = new Link(content, count, description, icon, id, sort1, title, typeId);
                links.add(link);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            //7.关闭连接
            DBUtil.close(conn, statement, resultSet);
        }
        return data;
    }

    @Override
    public String findById(int id) {
        //1.准备一个集合存储查询结果
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            //2.数据库连接
            conn = DBUtil.getConn();
            //3.预编译数据库的SQL
            statement = conn.prepareStatement(SQL_FIND_BY_ID);
            statement.setInt(1, id);
            //4.执行查询
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                //6.查询结果
                String content = resultSet.getString("content");
                return content;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            //7.关闭连接
            DBUtil.close(conn, statement, resultSet);
        }
        return null;
    }
}
