package se.ics.whatscookin.eao;

import java.util.List;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import se.ics.whatscookin.ejb.Recipe;

/**
 * Session Bean implementation class RecipeEAOImpl
 */
@Stateless
public class RecipeEAOImpl implements RecipeEAOLocal {
	
	@PersistenceContext(unitName="WhatsCookinPersistenceUnit")
	private EntityManager em;

    /**
     * Default constructor. 
     */
    public RecipeEAOImpl() {
        // TODO Auto-generated constructor stub
    }
    
    public Recipe findRecipeById(long id) {
        return em.find(Recipe.class, id);
    }

    public List<Recipe> findAllRecipe() {
        return em.createQuery("SELECT r FROM Recipe r", Recipe.class).getResultList();
    }

    public void createRecipe(Recipe recipe) {
        em.persist(recipe);
    }

    public Recipe updateRecipe(Recipe recipe) {
        return em.merge(recipe);
    }

    public void deleteRecipe(Recipe recipe) {
        Recipe managed = em.merge(recipe); // Ensure it's managed
        em.remove(managed);
    }
}
