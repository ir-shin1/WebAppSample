
package com.sample.webapp2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;

public class ServletApp extends HttpServlet {
    private static int count = 0;

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        count++;
        try {
            resp.setContentType("text/xml; charset=UTF-8");
            resp.setStatus(200);

            PrintWriter out = resp.getWriter();
            out.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
            out.println("<xsd:schema xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\">");
            out.println("    <xsd:element name=\"webapp2\" type=\"xsd:string\"/>");
            out.println("</xsd:schema>");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
