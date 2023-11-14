package com.example.myfirstservlet.state;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "DispatcherServlet1", value = "/dispatcher1")
public class DispatcherServlet1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.println("<h3> Dispatcher1 수행결과 </h3>");

        // forward(전달)
        ServletContext sc = this.getServletContext();
        RequestDispatcher rd = sc.getRequestDispatcher("/dispatcher2");

        req.setAttribute("name", "키트리");
        rd.forward(req, resp);  // 전달하는 것
        //rd.include(req,resp); // 포함시키는 것

    }
}
