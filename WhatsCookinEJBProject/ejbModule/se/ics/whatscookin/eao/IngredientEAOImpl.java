package se.ics.whatscookin.eao;

import java.util.List;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import se.ics.whatscookin.ejb.Ingredient;

/**
 * Session Bean implementation class IngredientEAOImpl
 */
@Stateless
public class IngredientEAOImpl implements IngredientEAOLocal {
	
	@PersistenceContext(unitName = "WhatsCookinPersistenceUnit")
	private EntityManager em;

    /**
     * Default constructor. 
     */
    public IngredientEAOImpl() {
        // TODO Auto-generated constructor stub
    }
    
    public Ingredient findIngredientById(long id) {
        return em.find(Ingredient.class, id);
    }

    public List<Ingredient> findAllIngredient() {
        return em.createQuery("SELECT i FROM Ingredient i", Ingredient.class).getResultList();
    }

    public void createIngredient(Ingredient ingredient) {
        em.persist(ingredient);
    }

    public Ingredient updateIngredient(Ingredient ingredient) {
        return em.merge(ingredient);
    }

    public void deleteIngredient(Ingredient ingredient) {
        Ingredient managedIngredient = em.merge(ingredient); // Ensure managed
        em.remove(managedIngredient);
    }
}
