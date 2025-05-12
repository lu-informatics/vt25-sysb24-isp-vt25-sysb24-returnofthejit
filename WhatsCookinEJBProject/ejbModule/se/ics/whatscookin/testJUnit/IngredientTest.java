package se.ics.whatscookin.testJUnit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import se.ics.whatscookin.ejb.Ingredient;

class IngredientTest {
	private String expectedIngredientNo;
	private String expectedIngredientName;
	Ingredient ing1;
	Ingredient ing2;

	@BeforeEach
	void setUp() throws Exception {
		expectedIngredientNo = "I001";
		expectedIngredientName = "IngredientName";
		
		ing1 = new Ingredient(expectedIngredientNo, expectedIngredientName); 
	}

	@AfterEach
	void tearDown() throws Exception {
		ing1 = null; 
		ing2 = null;
	}

	@Test
	void testGetIngredientNo() {
		assertNotNull(ing1);
		assertEquals(expectedIngredientNo, ing1.getIngredientNo());
	}

	@Test
	void testSetIngredientNo() {
		String expectedIngredientNo2 = "TestRecipeNo";
		ing1.setIngredientNo(expectedIngredientNo2);
		assertEquals(expectedIngredientNo2, ing1.getIngredientNo());
	}

	@Test
	void testGetIngredientName() {
		assertNotNull(ing1);
		assertEquals(expectedIngredientName, ing1.getIngredientName());
	}

	@Test
	void testSetIngredientName() {
		String expectedIngredientName2 = "TestRecipeName";
		ing1.setIngredientName(expectedIngredientName2);
		assertEquals(expectedIngredientName2, ing1.getIngredientName());
	}

	

}
