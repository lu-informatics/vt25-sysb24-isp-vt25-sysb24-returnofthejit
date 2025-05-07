package whatscookin.facade.ics;

import jakarta.ejb.Local;
import whatscookin.ejb.ics.Recipe;

@Local
public interface FacadeLocal {
	public Recipe findByRecipeId(long id);

}
