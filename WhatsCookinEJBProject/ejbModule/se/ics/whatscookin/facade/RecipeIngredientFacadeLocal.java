package se.ics.whatscookin.facade;

import java.util.List;

import jakarta.ejb.Local;
import se.ics.whatscookin.ejb.RecipeIngredient;
import se.ics.whatscookin.ejb.RecipeIngredientId;

@Local
public interface RecipeIngredientFacadeLocal {
    public RecipeIngredient getRecipeIngredientById(RecipeIngredientId id);
    public List<RecipeIngredient> getAllRecipeIngredient();
    public void addRecipeIngredient(RecipeIngredient recipeIngredient);
    public RecipeIngredient updateRecipeIngredient(RecipeIngredient recipeIngredient);
    public void removeRecipeIngredient(RecipeIngredient recipeIngredient);
}
