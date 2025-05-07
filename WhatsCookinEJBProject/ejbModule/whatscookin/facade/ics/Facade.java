package whatscookin.facade.ics;

import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import whatscookin.ejb.ics.Recipe;
import whatscookin.ejb.ics.RecipeEAOLocal;

/**
 * Session Bean implementation class Facade
 */
@Stateless
public class Facade implements FacadeLocal {
	
	@EJB
	private RecipeEAOLocal recipeEAO;
    /**
     * Default constructor. 
     */
    public Facade() {
        // TODO Auto-generated constructor stub
    }
    public Recipe findByRecipeId(long id) {
    	return recipeEAO.findByRecipeId(id);
    }

}
