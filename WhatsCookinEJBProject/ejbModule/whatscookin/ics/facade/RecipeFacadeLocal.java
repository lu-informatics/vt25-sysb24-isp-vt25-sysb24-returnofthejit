package whatscookin.ics.facade;

import java.util.List;

import jakarta.ejb.Local;
import whatscookin.ics.ejb.Recipe;

@Local
public interface RecipeFacadeLocal {
    public Recipe getRecipeById(long id);
    public List<Recipe> getAllRecipes();
    public void addRecipe(Recipe recipe);
    public Recipe updateRecipe(Recipe recipe);
    public void removeRecipe(Recipe recipe);
}
