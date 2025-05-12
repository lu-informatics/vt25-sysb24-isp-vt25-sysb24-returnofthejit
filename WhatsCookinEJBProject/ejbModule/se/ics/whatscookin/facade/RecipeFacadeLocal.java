package se.ics.whatscookin.facade;

import java.util.List;

import jakarta.ejb.Local;
import se.ics.whatscookin.ejb.Recipe;

@Local
public interface RecipeFacadeLocal {
    public Recipe getRecipeById(long id);
    public List<Recipe> getAllRecipes();
    public void addRecipe(Recipe recipe);
    public Recipe updateRecipe(Recipe recipe);
    public void removeRecipe(Recipe recipe);
    void testLog();
}
