package se.ics.whatscookin.testJUnit;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({ IngredientTest.class, RecipeTest.class })
public class AllTests {

}
