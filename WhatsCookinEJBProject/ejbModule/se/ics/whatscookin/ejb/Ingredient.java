package se.ics.whatscookin.ejb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="Ingredient")
public class Ingredient implements Serializable{
	private long ingredientID;
	private String ingredientNo;
	private String ingredientName;
	
	public Ingredient(String ingredientNo, String ingredientName) {
		this.ingredientNo = ingredientNo;
		this.ingredientName = ingredientName; 
	}
	
	@Id
	@Column(name = "IngredientID")
	public long getIngredientID() {
	    return ingredientID;
	}
	public void setIngredientID(long ingredientID) {
	    this.ingredientID = ingredientID;
	}
	
	@Column(name = "IngredientNo")
	public String getIngredientNo() {
        return ingredientNo;
    }
	
	public void setIngredientNo(String ingredientNo) {
        this.ingredientNo = ingredientNo;
    }
	
	@Column(name = "IngredientName")
	public String getIngredientName() {
        return ingredientName;
    }
	
	public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }
	
	@OneToMany(mappedBy = "ingredient")
	private List<RecipeIngredient> recipeIngredients = new ArrayList<>();

	public List<RecipeIngredient> getRecipeIngredients() {
	    return recipeIngredients;
	}

	public void setRecipeIngredients(List<RecipeIngredient> recipeIngredients) {
	    this.recipeIngredients = recipeIngredients;
	}

	
}