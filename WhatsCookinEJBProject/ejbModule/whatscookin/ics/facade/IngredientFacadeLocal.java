package whatscookin.ics.facade;

import java.util.List;

import jakarta.ejb.Local;
import whatscookin.ics.ejb.Ingredient;

@Local
public interface IngredientFacadeLocal {
    public Ingredient getIngredientById(long id);
    public List<Ingredient> getAllIngredients();
    public void addIngredient(Ingredient ingredient);
    public Ingredient updateIngredient(Ingredient ingredient);
    public void removeIngredient(Ingredient ingredient);
}
