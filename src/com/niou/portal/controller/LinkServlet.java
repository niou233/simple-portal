package com.niou.portal.controller;

import com.alibaba.fastjson.JSON;
import com.niou.portal.bean.Data;
import com.niou.portal.bean.Message;
import com.niou.portal.service.LinkService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * <pre>
 * @Description:
 * </pre>
 * @Auther: Niou
 * @Date: 2021/6/19 15:00
 * @Description:
 */
@WebServlet("/links")
public class LinkServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.描述双方的沟通格式
        resp.setContentType("text/json;charset=utf-8");
        //2.通过service获取数据
        List<Data> link = LinkService.findAll();
        //3.将数据组装成消息
        Message message = new Message();
        message.setData(link);
        message.setMsg("查询成功");
        message.setStatus(1);
        //4.将JSON化的数据传递给前端
        resp.getWriter().append(JSON.toJSONString(message));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
