package whatscookin.ics.eao;

import java.util.List;

import jakarta.ejb.Local;
import whatscookin.ics.ejb.RecipeIngredient;
import whatscookin.ics.ejb.RecipeIngredientId;

@Local
public interface RecipeIngredientEAOLocal {
	public RecipeIngredient findRecipeIngredientById(RecipeIngredientId id);
	public List<RecipeIngredient> findAllRecipeIngredient();
	public void createRecipeIngredient(RecipeIngredient recipeIngredient);
	public RecipeIngredient updateRecipeIngredient(RecipeIngredient recipeIngredient);
	public void deleteRecipeIngredient(RecipeIngredient recipeIngredient);
}
