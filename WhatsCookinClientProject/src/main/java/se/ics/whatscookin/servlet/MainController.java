package se.ics.whatscookin.servlet;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import se.ics.whatscookin.ejb.Recipe;
import se.ics.whatscookin.facade.RecipeFacade;
import se.ics.whatscookin.facade.RecipeFacadeLocal;

import java.io.IOException;
import java.time.LocalDate;

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
    @EJB
    private RecipeFacadeLocal recipeFacade; 
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		recipeFacade.testLog();
		
		String action = request.getParameter("action");

        if (action == null || action.equals("home")) {
            request.getRequestDispatcher("/jsp/home.jsp").forward(request, response);
        } else if (action.equals("about")) {
            request.getRequestDispatcher("/jsp/about.jsp").forward(request, response);
        } else if (action.equals("recipefeed")) {
            request.getRequestDispatcher("/jsp/recipefeed.jsp").forward(request, response);
        } else if (action.equals("addrecipe")) {
            request.getRequestDispatcher("/jsp/addrecipe.jsp").forward(request, response);
        } else if (action.equals("testcallback")) {
            // TESTKOD: Används för att verifiera Entity Callbacks i Recipe.java

            Recipe testRecipe = new Recipe();
            testRecipe.setRecipeNo("R1234");
            testRecipe.setTitle("Testrecept med callback");
            testRecipe.setCost(99.0);
            testRecipe.setTime(45.0);
            testRecipe.setInstructions("Testinstruktioner");
            testRecipe.setDescription("Testbeskrivning");
            testRecipe.setDate(LocalDate.now());

            recipeFacade.addRecipe(testRecipe); // Triggar @PrePersist och @PostPersist i Recipe

            response.setContentType("text/plain");
            response.getWriter().println("testcallback körd – kontrollera console-logg");
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
