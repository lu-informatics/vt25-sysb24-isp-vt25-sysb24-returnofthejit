<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <title>Recipe Details</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/recipe-details.css" />
</head>
<body>
  <div class="page-container">
    <div class="form-container">
      <h2>${recipe.title}</h2>
      <p><strong>By:</strong> ${recipe.user.username}</p>
      <p><strong>Date:</strong> ${recipe.formattedDate}</p>

      <div class="row">
        <div class="column">
          <label>Time</label>
          <input type="text" readonly value="${recipe.time} min">
        </div>
        <div class="column">
          <label>Cost</label>
          <input type="text" readonly value="${recipe.cost} kr">
        </div>
      </div>

      <label>Description</label>
      <textarea readonly>${recipe.description}</textarea>

      <label>Instructions</label>
      <textarea readonly>${recipe.instructions}</textarea>

      <label>Ingredients</label>
      <div class="selected-ingredients-container">
        <ul id="selected-quantities" class="filled">
          <c:forEach var="ri" items="${recipe.recipeIngredients}">
            <li>${ri.quantity}</li>
          </c:forEach>
        </ul>
        <ul id="selected-ingredients" class="filled">
          <c:forEach var="ri" items="${recipe.recipeIngredients}">
            <li>${ri.ingredient.ingredientName}</li>
          </c:forEach>
        </ul>
      </div>
    </div>
  </div>
</body>
</html>
