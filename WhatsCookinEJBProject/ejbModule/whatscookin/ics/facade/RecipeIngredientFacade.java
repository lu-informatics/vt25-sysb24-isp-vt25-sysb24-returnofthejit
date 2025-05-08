package whatscookin.ics.facade;

import java.util.List;

import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import whatscookin.ics.eao.RecipeIngredientEAOLocal;
import whatscookin.ics.ejb.RecipeIngredient;
import whatscookin.ics.ejb.RecipeIngredientId;

@Stateless
public class RecipeIngredientFacade implements RecipeIngredientFacadeLocal {

    @EJB
    private RecipeIngredientEAOLocal recipeIngredientEAO;

    /**
     * Default constructor. 
     */
    public RecipeIngredientFacade() {
        // TODO Auto-generated constructor stub
    }
    
    public RecipeIngredient getRecipeIngredientById(RecipeIngredientId id) {
        return recipeIngredientEAO.findRecipeIngredientById(id);
    }

    public List<RecipeIngredient> getAllRecipeIngredient() {
        return recipeIngredientEAO.findAllRecipeIngredient();
    }

    public void addRecipeIngredient(RecipeIngredient recipeIngredient) {
        recipeIngredientEAO.createRecipeIngredient(recipeIngredient);
    }

    public RecipeIngredient updateRecipeIngredient(RecipeIngredient recipeIngredient) {
        return recipeIngredientEAO.updateRecipeIngredient(recipeIngredient);
    }

    public void removeRecipeIngredient(RecipeIngredient recipeIngredient) {
        recipeIngredientEAO.deleteRecipeIngredient(recipeIngredient);
    }
}
