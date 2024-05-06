package org.fwx.servlet;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName MyServlet
 * @Description TODO
 * @Author Fwx
 * @Date 2024/4/27 19:44
 * @Version 1.0
 */
@Slf4j
//@WebServlet({"/myservlet01","/myservlet02"})
public class MyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      log.info("*** MyServlet doGet ***");
      resp.getWriter().write("MyServlet doGet");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
}
