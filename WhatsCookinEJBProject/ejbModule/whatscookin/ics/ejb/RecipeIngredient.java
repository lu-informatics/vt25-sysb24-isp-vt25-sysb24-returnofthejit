package whatscookin.ics.ejb;

import java.io.Serializable;

import jakarta.persistence.*;

@Entity
@Table(name = "RecipeIngredient")
public class RecipeIngredient implements Serializable {

    @EmbeddedId
    private RecipeIngredientId id = new RecipeIngredientId();

    @ManyToOne
    @MapsId("recipeID")
    @JoinColumn(name = "RecipeID")
    private Recipe recipe;

    @ManyToOne
    @MapsId("ingredientID")
    @JoinColumn(name = "IngredientID")
    private Ingredient ingredient;

    @Column(name = "Quantity")
    private String quantity;

    // Getters and Setters

    public RecipeIngredientId getId() {
        return id;
    }

    public void setId(RecipeIngredientId id) {
        this.id = id;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
}
