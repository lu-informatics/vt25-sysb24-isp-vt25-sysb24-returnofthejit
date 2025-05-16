package se.ics.whatscookin.eao;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
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
    
    public int nbrOfRecipesToday() {
        LocalDate today = LocalDate.now();
        LocalDateTime startOfDay = today.atStartOfDay();
        LocalDateTime endOfDay = today.plusDays(1).atStartOfDay().minusNanos(1);

        TypedQuery<Long> query = em.createQuery(
            "SELECT COUNT(r) FROM Recipe r WHERE r.date BETWEEN :start AND :end", Long.class);
        query.setParameter("start", startOfDay);
        query.setParameter("end", endOfDay);

        return query.getSingleResult().intValue();
    }

    public List<Recipe> findAllRecipe() {
        return em.createQuery("SELECT r FROM Recipe r ORDER BY r.date DESC", Recipe.class).getResultList();
    }

    public void createRecipe(Recipe recipe) {
    	recipe.setRecipeNo(getNextRecipeNo());
        em.persist(recipe);
    }

    public Recipe updateRecipe(Recipe recipe) {
        return em.merge(recipe);
    }

    public void deleteRecipe(Recipe recipe) {
        Recipe managed = em.find(Recipe.class, recipe.getRecipeID());
        if (managed != null) {
            em.remove(managed);
        }
    }
    
    public String getNextRecipeNo() {
        String jpql = "SELECT r.recipeNo FROM Recipe r ORDER BY r.recipeNo DESC";
        List<String> result = em.createQuery(jpql, String.class)
                                .setMaxResults(1)
                                .getResultList();

        if (result.isEmpty()) {
            return "R001";
        }

        String last = result.get(0);  // e.g. "R027"
        int nextNumber = Integer.parseInt(last.substring(1)) + 1;
        return String.format("R%03d", nextNumber);  // pads with zeros to 3 digits
    }

}
