package se.ics.whatscookin.eao;

import java.util.List;

import jakarta.ejb.Local;
import se.ics.whatscookin.ejb.RecipeIngredient;
import se.ics.whatscookin.ejb.RecipeIngredientId;

@Local
public interface RecipeIngredientEAOLocal {
	public RecipeIngredient findRecipeIngredientById(RecipeIngredientId id);
	public List<RecipeIngredient> findAllRecipeIngredient();
	public void createRecipeIngredient(RecipeIngredient recipeIngredient);
	public RecipeIngredient updateRecipeIngredient(RecipeIngredient recipeIngredient);
	public void deleteRecipeIngredient(RecipeIngredient recipeIngredient);
}
