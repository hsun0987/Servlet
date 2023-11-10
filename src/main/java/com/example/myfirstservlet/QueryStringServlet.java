package com.example.myfirstservlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "QueryStringServlet", value = "/query-string-servlet")
public class QueryStringServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // GET 메소드 요청 처리
        // 쿼리 스트링을 추출 해야 함
        resp.setContentType("text/plain;charset=UTF-8"); // 한글로 바꿔줌
        PrintWriter out = resp.getWriter();

        out.println("Get 요청\n");
        out.println(req.getParameter("name") + "\n");
        out.println(req.getParameter("city") + "\n");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/plain;charset=UTF-8"); // 한글로 바꿔줌
        req.setCharacterEncoding("UTF-8");

        PrintWriter out = resp.getWriter();

        out.println("Post 요청\n");
        out.println(req.getParameter("name") + "\n");
        out.println(req.getParameter("city") + "\n");
    }
}
