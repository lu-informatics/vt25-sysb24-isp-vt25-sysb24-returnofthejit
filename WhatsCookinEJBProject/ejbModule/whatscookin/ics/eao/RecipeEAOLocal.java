package whatscookin.ics.eao;

import java.util.List;

import jakarta.ejb.Local;
import whatscookin.ics.ejb.Recipe;

@Local
public interface RecipeEAOLocal {
	public Recipe findRecipeById(long id);
	public List<Recipe> findAllRecipe();
	public void createRecipe(Recipe recipe);
	public Recipe updateRecipe(Recipe recipe);
	public void deleteRecipe(Recipe recipe);
}
