
package se.ics.whatscookin.servlet;

import jakarta.ejb.EJB;
import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonArrayBuilder;
import jakarta.json.JsonObject;
import jakarta.json.JsonObjectBuilder;
import jakarta.json.JsonReader;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import se.ics.whatscookin.ejb.AppUser;
import se.ics.whatscookin.ejb.Recipe;
import se.ics.whatscookin.facade.AppUserFacadeLocal;
import se.ics.whatscookin.facade.RecipeFacadeLocal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/Recipes/*")
public class RestRecipe extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @EJB
    RecipeFacadeLocal recipeFacade;
    
    @EJB
    AppUserFacadeLocal appUserFacade;

    public RestRecipe() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setContentType("application/json");

        String pathInfo = request.getPathInfo();

        if (pathInfo == null || pathInfo.equals("/")) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Recipe ID is required in URL, e.g. /Recipes/1");
            return;
        }

        String[] splits = pathInfo.split("/");
        if (splits.length != 2) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid URL format");
            return;
        }

        try {
            long id = Long.parseLong(splits[1]);

            Recipe recipe = recipeFacade.getRecipeById(id);

            if (recipe == null) {
                response.sendError(HttpServletResponse.SC_NOT_FOUND, "Recipe not found");
            } else {
                sendAsJson(response, recipe);
            }
        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid ID format");
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	response.setHeader("Access-Control-Allow-Origin", "*");
        response.setContentType("application/json");
        String pathInfo = request.getPathInfo();

        if (pathInfo == null || pathInfo.equals("/")) {
            BufferedReader reader = request.getReader();
            Recipe recipe = parseJsonRecipe(reader);
            try {
                recipeFacade.addRecipe(recipe);
            } catch (Exception e) {
                System.out.println("duplicate key");
            }
            sendAsJson(response, recipe);
        } else {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST);
        }
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	response.setHeader("Access-Control-Allow-Origin", "*");
        response.setContentType("application/json");
        String pathInfo = request.getPathInfo();

        if (pathInfo == null || pathInfo.equals("/")) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        String[] splits = pathInfo.split("/");
        if (splits.length != 2) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        BufferedReader reader = request.getReader();
        Recipe recipe = parseJsonRecipe(reader);
        try {
            recipe = recipeFacade.updateRecipe(recipe);
        } catch (Exception e) {
            System.out.println("facade Update Error");
        }
        sendAsJson(response, recipe);
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	response.setHeader("Access-Control-Allow-Origin", "*");

        String pathInfo = request.getPathInfo();

        if (pathInfo == null || pathInfo.equals("/")) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        String[] splits = pathInfo.split("/");
        if (splits.length != 2) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        try {
            long id = Long.parseLong(splits[1]);
            Recipe recipe = recipeFacade.getRecipeById(id);
            if (recipe != null) {
                recipeFacade.removeRecipe(recipe);
                response.setStatus(HttpServletResponse.SC_NO_CONTENT); 
            } else {
                response.sendError(HttpServletResponse.SC_NOT_FOUND); 
            }
        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid ID format");
        }
    }


    private void sendAsJson(HttpServletResponse response, Recipe recipe) throws IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("application/json");

        if (recipe != null) {
            JsonObjectBuilder obj = Json.createObjectBuilder();
            obj.add("id", recipe.getRecipeID());
            obj.add("no", recipe.getRecipeNo());
            obj.add("title", recipe.getTitle());
            obj.add("cost", String.valueOf(recipe.getCost())); 
            obj.add("time", String.valueOf(recipe.getTime()));
            obj.add("instructions", recipe.getInstructions());
            obj.add("description", recipe.getDescription());

            JsonObject jsonObject = obj.build();
            System.out.println("Single Recipe JSON response: " + jsonObject);
            out.print(jsonObject);
        } else {
            out.print("{}");
        }
        out.flush();
    }

    private Recipe parseJsonRecipe(BufferedReader br) {
        JsonReader jsonReader = Json.createReader(br);
        JsonObject jsonRoot = jsonReader.readObject();

        Recipe recipe = new Recipe();

        // Parse and set Recipe ID if it exists
        if (jsonRoot.containsKey("id")) {
            try {
                String idStr = jsonRoot.get("id").toString().replaceAll("\"", "");
                long id = Long.parseLong(idStr);
                recipe.setRecipeID(id);
            } catch (NumberFormatException e) {
                System.out.println("Invalid recipe ID format in JSON");
            }
        }

        recipe.setRecipeNo(jsonRoot.getString("no"));
        recipe.setTitle(jsonRoot.getString("title"));
        recipe.setCost(Double.parseDouble(jsonRoot.getString("cost")));
        recipe.setTime(Double.parseDouble(jsonRoot.getString("time")));
        recipe.setDescription(jsonRoot.getString("description"));
        recipe.setInstructions(jsonRoot.getString("instructions"));

        // Set a fixed AppUser to avoid DB error on update
        AppUser webUser = appUserFacade.getUserById(14L);
        recipe.setUser(webUser);

        return recipe;
    }

}