package whatscookin.ics.facade;

import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import whatscookin.ics.eao.IngredientEAOLocal;
import whatscookin.ics.ejb.Ingredient;

import java.util.List;

/**
 * Session Bean implementation class IngredientFacade
 */
@Stateless
public class IngredientFacade implements IngredientFacadeLocal {
	
	@EJB
    private IngredientEAOLocal ingredientEAO;

    /**
     * Default constructor. 
     */
    public IngredientFacade() {
        // TODO Auto-generated constructor stub
    }
    
    public Ingredient getIngredientById(long id) {
        return ingredientEAO.findIngredientById(id);
    }

    public List<Ingredient> getAllIngredients() {
        return ingredientEAO.findAllIngredient();
    }

    public void addIngredient(Ingredient ingredient) {
        ingredientEAO.createIngredient(ingredient);
    }

    public Ingredient updateIngredient(Ingredient ingredient) {
        return ingredientEAO.updateIngredient(ingredient);
    }

    public void removeIngredient(Ingredient ingredient) {
        ingredientEAO.deleteIngredient(ingredient);
    }
}
