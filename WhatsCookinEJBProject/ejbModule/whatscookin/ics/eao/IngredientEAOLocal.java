package whatscookin.ics.eao;

import java.util.List;

import jakarta.ejb.Local;
import whatscookin.ics.ejb.Ingredient;

@Local
public interface IngredientEAOLocal {
    public Ingredient findIngredientById(long id);
    public List<Ingredient> findAllIngredient();
    public void createIngredient(Ingredient ingredient);
    public Ingredient updateIngredient(Ingredient ingredient);
    public void deleteIngredient(Ingredient ingredient);
}
