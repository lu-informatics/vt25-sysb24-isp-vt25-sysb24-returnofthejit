package whatscookin.ics.ejb;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embeddable;

@Embeddable
public class RecipeIngredientId implements Serializable {
    private long recipeID;
    private long ingredientID;

    // Getters, Setters, hashCode and equals

    public long getRecipeID() {
        return recipeID;
    }

    public void setRecipeID(long recipeID) {
        this.recipeID = recipeID;
    }

    public long getIngredientID() {
        return ingredientID;
    }

    public void setIngredientID(long ingredientID) {
        this.ingredientID = ingredientID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RecipeIngredientId)) return false;
        RecipeIngredientId that = (RecipeIngredientId) o;
        return recipeID == that.recipeID &&
               ingredientID == that.ingredientID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(recipeID, ingredientID);
    }
}

