package org.example.controller;

import jdbc.NeedHomeworkJdbc;
import model.NeedHomework;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet("/needhomework")
public class NeedHomeworkServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<NeedHomework> list = NeedHomeworkJdbc.selectAllNeed();
        req.setCharacterEncoding("UTF-8");

        req.setAttribute("list", list);//在请求里面放了一个list,里面的值是list

        if(null == list || list.size() <= 0)
        {
            req.setAttribute("error", "没有查询到指定数据");//在请求里面放了一个list,里面的值是list
        }
        else
        {
            req.setAttribute("error", "");//在请求里面放了一个list,里面的值是list
        }

        req.getRequestDispatcher("JSP/Teacher/ShowNeedSub.jsp").forward(req, resp);//将请求分发到index.jsp,重定向到index.jsp
    }
}
