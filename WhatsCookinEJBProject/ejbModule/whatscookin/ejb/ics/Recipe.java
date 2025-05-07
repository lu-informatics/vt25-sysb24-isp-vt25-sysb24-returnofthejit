package whatscookin.ejb.ics;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Recipe")
public class Recipe implements Serializable{
	private long idRecipe;
	private String title;
	private double cost;
	private double time;
	private String instructions;
	private String description; 
	private LocalDate date;
	
	
	@Id
	@Column(name = "idRecipe")
	public long getIdRecipe() {
	    return idRecipe;
	}
	public void setIdRecipe(long idRecipe) {
	    this.idRecipe = idRecipe;
	}

	@Column(name = "title")
	public String getTitle() {
	    return title;
	}
	public void setTitle(String title) {
	    this.title = title;
	}

	@Column(name = "cost")
	public double getCost() {
	    return cost;
	}
	public void setCost(double cost) {
	    this.cost = cost;
	}

	@Column(name = "time")
	public double getTime() {
	    return time;
	}
	public void setTime(double time) {
	    this.time = time;
	}

	@Column(name = "instructions")
	public String getInstructions() {
	    return instructions;
	}
	public void setInstructions(String instructions) {
	    this.instructions = instructions;
	}

	@Column(name = "description")
	public String getDescription() {
	    return description;
	}
	public void setDescription(String description) {
	    this.description = description;
	}

	@Column(name = "date")
	public LocalDate getDate() {
	    return date;
	}
	public void setDate(LocalDate date) {
	    this.date = date;
	}	
	

}
