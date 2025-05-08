package whatscookin.ics.eao;

import java.util.List;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import whatscookin.ics.ejb.RecipeIngredient;
import whatscookin.ics.ejb.RecipeIngredientId;

/**
 * Session Bean implementation class RecipeIngredientEAOImpl
 */
@Stateless
public class RecipeIngredientEAOImpl implements RecipeIngredientEAOLocal {

   
	@PersistenceContext(unitName = "WhatsCookinPersistenceUnit")
    private EntityManager em;
	
	/**
     * Default constructor. 
     */
    public RecipeIngredientEAOImpl() {
        // TODO Auto-generated constructor stub
    }

    public RecipeIngredient findRecipeIngredientById(RecipeIngredientId id) {
        return em.find(RecipeIngredient.class, id);
    }

    public List<RecipeIngredient> findAllRecipeIngredient() {
        return em.createQuery("SELECT ri FROM RecipeIngredient ri", RecipeIngredient.class)
                 .getResultList();
    }

    public void createRecipeIngredient(RecipeIngredient recipeIngredient) {
        em.persist(recipeIngredient);
    }

    public RecipeIngredient updateRecipeIngredient(RecipeIngredient recipeIngredient) {
        return em.merge(recipeIngredient);
    }

    public void deleteRecipeIngredient(RecipeIngredient recipeIngredient) {
        RecipeIngredient managed = em.merge(recipeIngredient); // Ensure it's managed
        em.remove(managed);
    }
}
