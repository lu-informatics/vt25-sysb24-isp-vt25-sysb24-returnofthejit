package se.ics.whatscookin.testJUnit;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import se.ics.whatscookin.ejb.Recipe;

class RecipeTest {
	//private long expectedRecipeID;
	private String expectedRecipeNo;
	private String expectedTitle;
	private double expectedCost;
	private double expectedTime;
	private String expectedInstructions;
	private String expectedDescription; 
	private LocalDate expectedDate;
	//private List<RecipeIngredient> expectedIngredients;
	private Recipe r1;
	private Recipe r2; 

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		expectedRecipeNo = "R001";
		expectedTitle = "RecipeName";
		expectedCost = 40;
		expectedTime = 60;
		expectedInstructions = "instructions";
		expectedDescription = "description";
		expectedDate = LocalDate.now();
		
		r1 = new Recipe(expectedRecipeNo, expectedTitle, expectedCost, expectedTime, expectedInstructions,expectedDescription, expectedDate);
		r2 = new Recipe("R002", "Pasta", 35, 30, "Koka pasta och häll i pastasåsen", "Enkel och snabb pasta rätt", LocalDate.now());
		
	}

	@AfterEach
	void tearDown() throws Exception {
		r1 = null;
		r2 = null; 
	}

	@Test
	void testGetRecipeNo() {
		assertNotNull(r1);
		assertEquals(expectedRecipeNo, r1.getRecipeNo());
	}

	@Test
	void testSetRecipeNo() {
		String expectedRecipeNo2 = "TestRecipeNo";
		r1.setRecipeNo(expectedRecipeNo2);
		assertEquals(expectedRecipeNo2, r1.getRecipeNo());
	}

	@Test
	void testGetTitle() {
		assertNotNull(r1);
		assertEquals(expectedTitle, r1.getTitle());
	}

	@Test
	void testSetTitle() {
		String expectedTitle2 = "TestTitle";
		r1.setTitle(expectedTitle2);
		assertEquals(expectedTitle2, r1.getTitle());
	}

	@Test
	void testGetCost() {
		assertNotNull(r1);
		assertEquals(expectedCost, r1.getCost());
	}

	@Test
	void testSetCost() {
		double expectedCost2 = 45;
		r1.setCost(expectedCost2);
		assertEquals(expectedCost2, r1.getCost());
	}

	@Test
	void testGetTime() {
		assertNotNull(r1);
		assertEquals(expectedTime, r1.getTime());
	}

	@Test
	void testSetTime() {
		double expectedTime2 = 45;
		r1.setTime(expectedTime2);
		assertEquals(expectedTime2, r1.getTime());
	}

	@Test
	void testGetInstructions() {
		assertNotNull(r1);
		assertEquals(expectedInstructions, r1.getInstructions());
	}

	@Test
	void testSetInstructions() {
		String expectedInstructions2 = "TestInstructions";
		r1.setInstructions(expectedInstructions2);
		assertEquals(expectedInstructions2, r1.getInstructions());
	}

	@Test
	void testGetDescription() {
		assertNotNull(r1);
		assertEquals(expectedDescription, r1.getDescription());
	}

	@Test
	void testSetDescription() {
		String expectedDescription2 = "TestDescription";
		r1.setDescription(expectedDescription2);
		assertEquals(expectedDescription2, r1.getDescription());
	}

	@Test
	void testGetDate() {
		assertNotNull(r1);
		assertEquals(expectedDate, r1.getDate());
	}

	@Test
	void testSetDate() {
		LocalDate expectedDate2 = LocalDate.now();
		r1.setDate(expectedDate2);
		assertEquals(expectedDate2, r1.getDate());
	}

}
