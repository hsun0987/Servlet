<%@ page import="static java.time.LocalTime.now" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World </title>
</head>
<body>
<h1><%= "서블릿 BASIC"%></h1>
<br/>
<a href="hello-servlet">Hello Servlet</a>
<br>
<a href="currentTime-servlet">현재 시각</a>
<br>
<a href="korean-servlet">한글 응답</a>
<br>
<a href="request-info-servlet">요청 정보</a>
<br>
<a href="memberInfo.html">쿼리 스트링</a>
<br>
<a href="multiplication.html">실습 1: 구구단</a>
<br>
<a href="calc.html">실습2 : 계산기</a>
<br>
<a href="/state-store">상태정보 유지 기술</a>
<br>
<a href="/user-visit.html">상태정보 유지 기술 : 유저 방문 정보 페이지[세션]</a>
<br>
<a href="/cookie">상태정보 유지 기술 : 쿠키 만들기</a>
<br>
<a href="/cookie-read">상태정보 유지 기술 : 쿠키 읽어오기</a>
<br>
<a href="/site.html">상태정보 유지 기술 : 요청 단위</a>
<br>
<a href="/dispatcher1">포워드</a>
</body>
</html>