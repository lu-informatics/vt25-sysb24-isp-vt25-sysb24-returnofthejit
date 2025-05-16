package se.ics.whatscookin.servlet;

import jakarta.ejb.EJB;
import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;
import jakarta.json.JsonValue;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import se.ics.whatscookin.ejb.Recipe;
import se.ics.whatscookin.facade.IngredientFacadeLocal;
import se.ics.whatscookin.facade.RecipeFacadeLocal;

import java.io.IOException;
import java.io.StringReader;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Servlet implementation class MainController
 * 
 * http://localhost:8080/WhatsCookin/Controller
 */
@WebServlet("/controller")
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private RecipeFacadeLocal recipeFacade;
	
	@EJB
	private IngredientFacadeLocal ingredientFacade;
       
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
        	int nbrOfRecipesToday = recipeFacade.nbrOfRecipesToday();
        	request.setAttribute("nbrOfRecipesToday", nbrOfRecipesToday);
            request.getRequestDispatcher("/jsp/home.jsp").forward(request, response);
        } else if (action.equals("about")) {
            request.getRequestDispatcher("/jsp/about.jsp").forward(request, response);
        } else if (action.equals("recipefeed")) {
        	List<Recipe> recipes = recipeFacade.getAllRecipes(); // Inject the facade
            request.setAttribute("recipes", recipes);
            request.getRequestDispatcher("/jsp/recipe-feed.jsp").forward(request, response);
        } else if (action.equals("addrecipe")) {
        	List<?> ingredients = ingredientFacade.getAllIngredients();
			request.setAttribute("ingredients", ingredients);
            request.getRequestDispatcher("/jsp/add-recipe.jsp").forward(request, response);
        } else if (action.equals("recipedetails")) {
            String idParam = request.getParameter("id");
            if (idParam != null) {
                try {
                    long id = Long.parseLong(idParam);
                    Recipe recipe = recipeFacade.getRecipeById(id);
                    request.setAttribute("recipe", recipe);
                    request.getRequestDispatcher("/jsp/recipe-details.jsp").forward(request, response);
                } catch (NumberFormatException e) {
                    response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid recipe ID");
                }
            } else {
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Missing recipe ID");
            }
        }else {
            // fallback/error page
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "Page not found for action: " + action);
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");

		if (action != null && action.equals("saverecipe")) {
			String name = request.getParameter("recipeName");
			String description = request.getParameter("description");
			String instructions = request.getParameter("instructions");

			double time = Double.parseDouble(request.getParameter("time"));
			double cost = Double.parseDouble(request.getParameter("cost"));

			String ingredientsJson = request.getParameter("ingredientsData");
			Map<Long, String> ingredientMap = new HashMap<>();

			if (ingredientsJson != null && !ingredientsJson.isEmpty()) {
				try (JsonReader reader = Json.createReader(new StringReader(ingredientsJson))) {
					JsonArray jsonArray = reader.readArray();

					for (JsonValue val : jsonArray) {
						JsonObject obj = val.asJsonObject();
						Long id = Long.valueOf(obj.getString("id"));
						String qty = obj.getString("quantity");
						ingredientMap.put(id, qty);
					}
				}
			}

			Recipe recipe = new Recipe();
			recipe.setTitle(name);
			recipe.setDescription(description);
			recipe.setInstructions(instructions);
			recipe.setTime(time);
			recipe.setCost(cost);
			recipe.setDate(LocalDateTime.now());

			recipeFacade.createRecipe(recipe, ingredientMap);
			response.sendRedirect("controller?action=recipefeed");

		} else {
			doGet(request, response); // fallback
		}
	}
}
