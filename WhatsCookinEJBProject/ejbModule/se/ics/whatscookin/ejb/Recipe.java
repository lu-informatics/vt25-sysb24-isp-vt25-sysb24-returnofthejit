package se.ics.whatscookin.ejb;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@NamedQueries({
    @NamedQuery(name = "Recipe.findAll", query = "SELECT r FROM Recipe r")
})

@Entity
@Table(name="Recipe")
public class Recipe implements Serializable{
	private long recipeID;
	private String recipeNo;
	private String title;
	private double cost;
	private double time;
	private String instructions;
	private String description; 
	private LocalDate date;
	
	
	@Id
	@Column(name = "RecipeID")
	public long getRecipeID() {
	    return recipeID;
	}
	public void setRecipeID(long recipeID) {
	    this.recipeID = recipeID;
	}
	
	@Column(name = "RecipeNo")
	public String getRecipeNo() {
		return recipeNo;
	}

	public void setRecipeNo(String recipeNo) {
		this.recipeNo = recipeNo;
	}

	@Column(name = "Title")
	public String getTitle() {
	    return title;
	}
	public void setTitle(String title) {
	    this.title = title;
	}

	@Column(name = "RecipeCost")
	public double getCost() {
	    return cost;
	}
	public void setCost(double cost) {
	    this.cost = cost;
	}

	@Column(name = "CookingTime")
	public double getTime() {
	    return time;
	}
	public void setTime(double time) {
	    this.time = time;
	}

	@Column(name = "RecipeInstructions")
	public String getInstructions() {
	    return instructions;
	}
	public void setInstructions(String instructions) {
	    this.instructions = instructions;
	}

	@Column(name = "RecipeDescription")
	public String getDescription() {
	    return description;
	}
	public void setDescription(String description) {
	    this.description = description;
	}

	@Column(name = "CreatedAt")
	public LocalDate getDate() {
	    return date;
	}
	public void setDate(LocalDate date) {
	    this.date = date;
	}	
	
	private List<RecipeIngredient> recipeIngredients = new ArrayList<>();

	@OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL)
	public List<RecipeIngredient> getRecipeIngredients() {
	    return recipeIngredients;
	}

	public void setRecipeIngredients(List<RecipeIngredient> recipeIngredients) {
	    this.recipeIngredients = recipeIngredients;
	}
}
