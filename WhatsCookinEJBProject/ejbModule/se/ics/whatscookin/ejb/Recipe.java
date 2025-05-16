package se.ics.whatscookin.ejb;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PostPersist;
import jakarta.persistence.PostRemove;
import jakarta.persistence.PostUpdate;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

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
	private LocalDateTime date;
	
	private AppUser user;
	private List<RecipeIngredient> recipeIngredients = new ArrayList<>();
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	public LocalDateTime getDate() {
	    return date;
	}
	public void setDate(LocalDateTime date) {
	    this.date = date;
	}	
	
	@OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	public List<RecipeIngredient> getRecipeIngredients() {
	    return recipeIngredients;
	}

	public void setRecipeIngredients(List<RecipeIngredient> recipeIngredients) {
	    this.recipeIngredients = recipeIngredients;
	}
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "AppUserID", nullable = false)
	public AppUser getUser() {
		return user;
	}

	public void setUser(AppUser user) {
		this.user = user;
	}
	
	@Transient
	public String getFormattedDate() {
	    if (this.date == null) return "";
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
	    return this.date.format(formatter);
	}
	
	@PrePersist
	public void beforeInsert() {
	    System.out.println("[Callback] PrePersist: Förbereder att spara nytt recept ");
	    System.out.println("Titel: " + title);
	    System.out.println("Date: " + getFormattedDate());
	}

	@PostPersist
	public void afterInsert() {
	    System.out.println("[Callback] PostPersist: Receptet har nu sparats i databasen");
	    System.out.println("Titel: " + title);
	}
	
	@PostRemove
	public void afterDelete() {
	    System.out.println("[Callback] PostRemove: Receptet har tagits bort från databasen");
	    System.out.println("Titel: " + title + ", ID: " + recipeID);
	}

	

}
