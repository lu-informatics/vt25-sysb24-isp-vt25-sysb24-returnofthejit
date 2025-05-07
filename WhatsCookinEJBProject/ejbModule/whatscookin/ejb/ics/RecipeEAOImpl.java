package whatscookin.ejb.ics;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

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
    
    public Recipe findByRecipeId(long id) {
    	return em.find(Recipe.class, id);
    }

}
