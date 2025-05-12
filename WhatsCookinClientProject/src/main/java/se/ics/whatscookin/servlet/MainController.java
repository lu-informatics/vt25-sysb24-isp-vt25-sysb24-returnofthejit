package se.ics.whatscookin.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class MainController
 * 
 * http://localhost:8080/WhatsCookin/Controller
 */
@WebServlet("/controller")
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String action = request.getParameter("action");

        if (action == null || action.equals("home")) {
            request.getRequestDispatcher("/jsp/home.jsp").forward(request, response);
        } else if (action.equals("about")) {
            request.getRequestDispatcher("/jsp/about.jsp").forward(request, response);
        } else if (action.equals("recipefeed")) {
            request.getRequestDispatcher("/jsp/recipe-feed.jsp").forward(request, response);
        } else if (action.equals("addrecipe")) {
            request.getRequestDispatcher("/jsp/add-recipe.jsp").forward(request, response);
        } else {
            // fallback/error page
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "Page not found for action: " + action);
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
