package com.example.myfirstservlet.userjoin;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

import static com.example.myfirstservlet.userjoin.JoinServlet.sc;

@WebServlet(name = "LoginServlet", value = "/userjoin/loginout")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();

        HttpSession session = req.getSession();   // 세션 ID 추출

        String id = req.getParameter("id");
        String pw = req.getParameter("pw");
        Member m = (Member) sc.getAttribute(id);

        if (session.getAttribute("id") == null) {
            if (m != null) {
                if (m.getPwd().equals(pw)) {
                    out.println("로그인 성공 했습니다.");
                    session.setAttribute("id", m);
                    out.println("<hr><a href=/>홍으로 돌아가기</a></hr>");
                } else {
                    out.println("비밀번호가 틀렸습니다.");
                    out.println("<hr><a href=loginout.html>로그인 화면으로 돌아가기</a></hr>");
                }
            } else {
                out.println("해당 회원 ID는 존재하지 않습니다.");
                out.println("<hr><a href=loginout.html>로그인 화면으로 돌아가기</a></hr>");
            }
        } else
            out.println("현재 로그인 상태입니다.");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();
        HttpSession session = req.getSession();

        if (session.getAttribute("id") != null) {
            session.invalidate();
            out.println("로그아웃 되었습니다.");
            out.println("<hr><a href=/>홍으로 돌아가기</a></hr>");
        }else
            out.println("현재 로그인 상태가 아닙니다.");
        out.close();
    }

}

//세션 제거
// session.removeAttribute(id);
// session.invalidate();