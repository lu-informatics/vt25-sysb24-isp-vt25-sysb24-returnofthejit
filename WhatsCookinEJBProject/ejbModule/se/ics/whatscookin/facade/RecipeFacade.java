package se.ics.whatscookin.facade;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import se.ics.whatscookin.eao.IngredientEAOLocal;
import se.ics.whatscookin.eao.RecipeEAOLocal;
import se.ics.whatscookin.ejb.AppUser;
import se.ics.whatscookin.ejb.Ingredient;
import se.ics.whatscookin.ejb.Recipe;
import se.ics.whatscookin.ejb.RecipeIngredient;
import se.ics.whatscookin.ejb.RecipeIngredientId;

@Stateless
public class RecipeFacade implements RecipeFacadeLocal {

    @EJB
    private RecipeEAOLocal recipeEAO;
    
    @EJB
    private IngredientEAOLocal ingredientEAO;
    
    @EJB
    private AppUserFacadeLocal appUserFacade;

    /**
     * Default constructor. 
     */
    public RecipeFacade() {
        // TODO Auto-generated constructor stub
    }
    
    public Recipe getRecipeById(long id) {
        return recipeEAO.findRecipeById(id);
    }

    public List<Recipe> getAllRecipes() {
        return recipeEAO.findAllRecipe();
    }
    
    public void addRecipe(Recipe recipe) {
    	recipeEAO.createRecipe(recipe);
    }
    

    public void createRecipe(Recipe recipe, Map<Long, String> ingredientIdQuantityMap) {
        // Assign hardcoded WebUser
        AppUser webUser = appUserFacade.getUserById(14L);
        recipe.setUser(webUser);

        // Assign RecipeNo
        String nextRecipeNo = recipeEAO.getNextRecipeNo();
        recipe.setRecipeNo(nextRecipeNo);

        // Persist recipe
        recipeEAO.createRecipe(recipe);  // ID generated here

        // Build RecipeIngredient relations
        List<RecipeIngredient> riList = new ArrayList<>();

        for (Map.Entry<Long, String> entry : ingredientIdQuantityMap.entrySet()) {
            Long ingredientId = entry.getKey();
            String quantity = entry.getValue();

            Ingredient ingredient = ingredientEAO.findIngredientById(ingredientId);
            if (ingredient != null) {
                RecipeIngredient ri = new RecipeIngredient();
                ri.setRecipe(recipe);
                ri.setIngredient(ingredient);
                ri.setQuantity(quantity);

                RecipeIngredientId id = new RecipeIngredientId();
                id.setRecipeID(recipe.getRecipeID());
                id.setIngredientID(ingredient.getIngredientID());
                ri.setId(id);

                riList.add(ri); // collect it
            }
        }

        // Attach to recipe for cascading persist
        recipe.setRecipeIngredients(riList);
    }


    public Recipe updateRecipe(Recipe recipe) {
        return recipeEAO.updateRecipe(recipe);
    }

    public void removeRecipe(Recipe recipe) {
        recipeEAO.deleteRecipe(recipe);
    }
}
