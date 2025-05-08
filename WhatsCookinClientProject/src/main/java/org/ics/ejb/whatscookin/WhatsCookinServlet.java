package org.ics.ejb.whatscookin;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class WhatsCookinServlet 
 * 
 * http://localhost:8080/WhatsCookin/WhatsCookinServlet
 */
@WebServlet("/WhatsCookinServlet")
public class WhatsCookinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WhatsCookinServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html><html><head>");
		out.println("<title>WhatsCookin</title>");
		out.println("<meta charset=\"ISO-8859-1\">");
		out.println("</head><body>");
		out.println("<h2>Amelie</h2>");
		out.println("</body></html>");
		out.close();

	}

}
