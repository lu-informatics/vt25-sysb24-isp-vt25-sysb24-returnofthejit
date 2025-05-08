package se.ics.whatscookin.facade;

import java.util.List;

import jakarta.ejb.Local;
import se.ics.whatscookin.ejb.Ingredient;

@Local
public interface IngredientFacadeLocal {
    public Ingredient getIngredientById(long id);
    public List<Ingredient> getAllIngredients();
    public void addIngredient(Ingredient ingredient);
    public Ingredient updateIngredient(Ingredient ingredient);
    public void removeIngredient(Ingredient ingredient);
}
