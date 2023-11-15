package com.example.myfirstservlet.userjoin;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

@WebServlet(name = "JoinServlet", value = "/userjoin/join")
public class JoinServlet extends HttpServlet {
    HashMap<String, Member>  mList = new HashMap<String, Member>();
    static ServletContext sc = null;

    @Override
    public void init(ServletConfig config) throws ServletException {
        sc = config.getServletContext();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();

        String id = req.getParameter("id");
        String pwd1 = req.getParameter("pwd1");
        String pwd2 = req.getParameter("pwd2");

        if(sc.getAttribute(id) == null){
            if (pwd1.equals(pwd2)) {
                sc.setAttribute(id, new Member(id, pwd1));
                out.println("회원가입을 완료하였습니다.");
                out.println("<hr><a href=/userjoin/loginout.html>로그인</a></hr>");
               // resp.sendRedirect("http://localhost:8080/");
            }else {
                out.println("비밀번호가 일치하지 않습니다.");
            }
        } else{
            out.println("이미 존재하는 회원입니다.");
        }
    }
}
