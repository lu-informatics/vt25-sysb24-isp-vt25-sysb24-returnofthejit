package org.ics.ejb.whatscookin;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import whatscookin.ejb.ics.Recipe;
import whatscookin.facade.ics.FacadeLocal;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class WhatsCookinServlet
 */
@WebServlet("/WhatsCookinServlet")
public class WhatsCookinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	FacadeLocal facade;
       
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
		
		Recipe recipe = facade.findByRecipeId(1);
		if (recipe != null) {
			out.println("<h3>Recipe ID: " + recipe.getTitle() + "</h3>");
			out.println("<p>Recipe Name: " + recipe.getCost() + "</p>");
			out.println("<p>Recipe Description: " + recipe.getDescription() + "</p>");
		} else {
			out.println("<h3>No recipe found</h3>");
		}
		out.println("</body></html>");
		out.close();

	}

}
