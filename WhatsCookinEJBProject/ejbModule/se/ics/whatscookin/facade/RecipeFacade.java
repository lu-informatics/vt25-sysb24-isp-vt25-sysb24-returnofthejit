package se.ics.whatscookin.facade;

import java.util.List;

import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import se.ics.whatscookin.eao.RecipeEAOLocal;
import se.ics.whatscookin.ejb.Recipe;

@Stateless
public class RecipeFacade implements RecipeFacadeLocal {

    @EJB
    private RecipeEAOLocal recipeEAO;

    /**
     * Default constructor. 
     */
    public RecipeFacade() {
        // TODO Auto-generated constructor stub
    }
    
    public Recipe getRecipeById(long id) {
        return recipeEAO.findRecipeById(id);
    }

    public List<Recipe> getAllRecipes() {
        return recipeEAO.findAllRecipe();
    }

    public void addRecipe(Recipe recipe) {
        recipeEAO.createRecipe(recipe);
    }

    public Recipe updateRecipe(Recipe recipe) {
        return recipeEAO.updateRecipe(recipe);
    }

    public void removeRecipe(Recipe recipe) {
        recipeEAO.deleteRecipe(recipe);
    }
}
