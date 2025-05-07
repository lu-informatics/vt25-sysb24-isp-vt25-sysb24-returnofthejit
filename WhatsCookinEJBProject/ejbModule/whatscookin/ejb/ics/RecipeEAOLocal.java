package whatscookin.ejb.ics;

import jakarta.ejb.Local;

@Local
public interface RecipeEAOLocal {
	public Recipe findByRecipeId(long id);

}
