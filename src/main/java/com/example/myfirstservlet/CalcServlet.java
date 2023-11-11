package com.example.myfirstservlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CalcServlet", value = "/calc-servlet")
public class CalcServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        int val1 = Integer.parseInt(req.getParameter("val1"));
        int val2 = Integer.parseInt(req.getParameter("val2"));

        String op = req.getParameter("op");
        switch (op){
            case "plus":
                out.println(val1 + " + " +  val2 + " 결과");
                out.println(val1 + val2);
                break;
            case "minus":
                out.println(val1 + " - " +  val2 + " 결과");
                out.println(val1 - val2);
                break;
            case "mul":
                out.println(val1 + " * " +  val2 + " 결과");
                out.println(val1 * val2);
                break;
            case "div":
                out.println(val1 + " / " +  val2 + " 결과");
                out.println(val1 / val2);
                break;
            case "mod":
                out.println(val1 + " % " +  val2 + " 결과");
                out.println(val1 % val2);
                break;
            default:
                out.println("결과 없음");
                break;
        }
    }
}
