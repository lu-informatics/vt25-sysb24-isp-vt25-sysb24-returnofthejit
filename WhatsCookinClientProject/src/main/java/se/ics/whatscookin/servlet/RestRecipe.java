
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
import se.ics.whatscookin.ejb.Recipe;
import se.ics.whatscookin.facade.RecipeFacadeLocal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/Recipes/*")
public class RestRecipe extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @EJB
    RecipeFacadeLocal facade;

    public RestRecipe() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pathInfo = request.getPathInfo();
        response.getWriter().append("Served at: ").append(request.getContextPath());

        if (pathInfo == null || pathInfo.equals("/")) {
            System.out.println("Alla");
            List<Recipe> allRecipes = facade.getAllRecipes();
            sendAsJson(response, allRecipes);
            return;
        }

        String[] splits = pathInfo.split("/");
        if (splits.length != 2) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        long id = Long.parseLong(splits[1]);
        Recipe recipe = facade.getRecipeById(id);
        sendAsJson(response, recipe);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pathInfo = request.getPathInfo();

        if (pathInfo == null || pathInfo.equals("/")) {
            BufferedReader reader = request.getReader();
            Recipe recipe = parseJsonRecipe(reader);
            try {
                facade.addRecipe(recipe);
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
            recipe = facade.updateRecipe(recipe);
        } catch (Exception e) {
            System.out.println("facade Update Error");
        }
        sendAsJson(response, recipe);
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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

        long id = Long.parseLong(splits[1]);
        Recipe recipe = facade.getRecipeById(id);
        if (recipe != null) {
            facade.removeRecipe(recipe);
        }
        sendAsJson(response, recipe);
    }

    private void sendAsJson(HttpServletResponse response, Recipe recipe) throws IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("application/json");

        if (recipe != null) {
            JsonObjectBuilder obj = Json.createObjectBuilder();
            obj.add("id", recipe.getRecipeID());
            obj.add("no", recipe.getRecipeNo());
            obj.add("title", recipe.getTitle());
            obj.add("cost", String.valueOf(recipe.getCost())); // eller .add("cost", recipe.getCost());
            obj.add("time", String.valueOf(recipe.getTime())); // eller .add("time", recipe.getTime());

            JsonObject jsonObject = obj.build();
            System.out.println("Single Recipe JSON response: " + jsonObject);
            out.print(jsonObject);
        } else {
            out.print("{}");
        }
        out.flush();
    }

    private void sendAsJson(HttpServletResponse response, List<Recipe> recipes) throws IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("application/json");

        if (recipes != null && !recipes.isEmpty()) {
            JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
            for (Recipe recipe : recipes) {
                JsonObjectBuilder obj = Json.createObjectBuilder();
                obj.add("id", recipe.getRecipeID());
                obj.add("no", recipe.getRecipeNo());
                obj.add("title", recipe.getTitle());
                obj.add("cost", String.valueOf(recipe.getCost())); // alternativ: obj.add("cost", recipe.getCost());
                obj.add("time", String.valueOf(recipe.getTime())); // alternativ: obj.add("time", recipe.getTime());
                arrayBuilder.add(obj);
            }
            JsonArray jsonArray = arrayBuilder.build();
            System.out.println("Recipes JSON response: " + jsonArray);
            out.print(jsonArray);
        } else {
            out.print("[]");
        }
        out.flush();
    }
 

    private Recipe parseJsonRecipe(BufferedReader br) {
        JsonReader jsonReader = Json.createReader(br);
        JsonObject jsonRoot = jsonReader.readObject();

        Recipe recipe = new Recipe();
        recipe.setRecipeNo(jsonRoot.getString("no"));
        recipe.setTitle(jsonRoot.getString("title"));
        recipe.setCost(Double.parseDouble(jsonRoot.getString("cost")));
        recipe.setTime(Double.parseDouble(jsonRoot.getString("time")));
        return recipe;
    }
}