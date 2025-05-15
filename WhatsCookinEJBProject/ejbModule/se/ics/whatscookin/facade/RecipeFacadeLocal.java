package se.ics.whatscookin.facade;

import java.util.List;
import java.util.Map;

import jakarta.ejb.Local;
import se.ics.whatscookin.ejb.Recipe;

@Local
public interface RecipeFacadeLocal {
    public Recipe getRecipeById(long id);
    public List<Recipe> getAllRecipes();
    public void createRecipe(Recipe recipe, Map<Long, String> ingredientIdQuantityMap);
    public Recipe updateRecipe(Recipe recipe);
    public void removeRecipe(Recipe recipe);
    public void addRecipe(Recipe recipe);
    public int nbrOfRecipesToday();
}
