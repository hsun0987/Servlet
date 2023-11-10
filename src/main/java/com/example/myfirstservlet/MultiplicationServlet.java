package com.example.myfirstservlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "MultiplicationServlet", value = "/multiplication-servlet")
public class MultiplicationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // GET 메소드 요청 처리
        // 쿼리 스트링을 추출 해야 함
        resp.setContentType("text/plain;charset=UTF-8"); // 한글로 바꿔줌
        PrintWriter out = resp.getWriter();

        int num = Integer.parseInt(req.getParameter("num"));

        out.println(req.getParameter("num") + "단 결과 \n");

        for (int i = 1; i < 10;i++){
            out.println("");
            out.println(num + " * " + i + " = " + (num * i));
        }
    }
}
