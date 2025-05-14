<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
  <title>Add Recipe</title>
<!-- Local stylesheet -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css" />
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/add-recipe.css" />

<!-- Fonts and Icons -->
  <link href="https://use.fontawesome.com/releases/v6.5.0/css/all.css" rel="stylesheet">
  <link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;600&display=swap" rel="stylesheet">
  <link href="https://fonts.googleapis.com/css2?family=Moo+Lah+Lah&display=swap" rel="stylesheet">

  <!-- Tom Select CSS -->
  <link href="https://cdn.jsdelivr.net/npm/tom-select@2.3.1/dist/css/tom-select.css" rel="stylesheet" />
</head>
<body>
  <div class="layout">

    <%-- Include the sidebar --%>
    <%@ include file="/fragments/sidebar.jsp" %>

    <main class="form-container">
      <h2>Add Recipe</h2>
      <form id="recipe-form" method="post" action="${pageContext.request.contextPath}/controller?action=saverecipe">
        <label>Enter Recipe Name:</label>
        <input type="text" name="recipeName" placeholder="Ex. Pasta Carbonara" required />

        <div class="row">
          <div class="column">
            <label>Enter a short description of your recipe:</label>
            <textarea name="description" required></textarea>
          </div>
          <div class="column">
            <label>Enter a summarized text of instructions:</label>
            <textarea name="instructions" required></textarea>
          </div>
        </div>

        <div class="row">
          <div class="column">
            <label>Time (minutes):</label>
            <input class="timecost" type="number" name="time" required />
          </div>
          <div class="column">
            <label>Cost per portion in SEK:</label>
            <input class="timecost" type="number" name="cost" required />
          </div>
        </div>

        <label>Ingredients:</label>
        <div class="ingredient-row">
          <div class="ingredient-select-wrapper">
            <select id="ingredient-select" placeholder="Select an ingredient..." autocomplete="off">
              <option value="">Select ingredient</option>
              <c:forEach var="ingredient" items="${ingredients}">
                <option value="${ingredient.ingredientID}">${ingredient.ingredientName}</option>
              </c:forEach>
            </select>
          </div>
          <input type="text" id="ingredient-quantity" class="quantity-input" placeholder="Quantity" />
          <button type="button" class="add" onclick="addIngredient()">Add Ingredient</button>
        </div>

        <label>Selected Ingredients:</label>
        <div class="selected-ingredients-container">
	        <ul id="selected-quantities"></ul>
	        <ul id="selected-ingredients"></ul>
	    </div>
        
        <!-- Hidden field to carry JSON string of selected ingredients -->
        <input type="hidden" name="ingredientsData" id="ingredients-data" />

        <div class="submit-wrapper">
          <button type="submit" class="add">Add Recipe</button>
        </div>
      </form>
    </main>
  </div>
  <!-- Load Tom Select first -->
  <script src="https://cdn.jsdelivr.net/npm/tom-select@2.3.1/dist/js/tom-select.complete.min.js" defer></script>
  <!-- Then your custom script -->
  <script src="${pageContext.request.contextPath}/js/add-recipe-script.js" defer></script>
</body>
</html>
