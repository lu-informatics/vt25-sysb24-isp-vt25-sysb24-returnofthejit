<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <title>Recipe Receipt</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css" />
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/recipe-details.css" />
</head>
<body>

  <div class="page-container">
  
    <%-- Include the header (header2.jsp) --%>
    <%@ include file="/fragments/header2.jsp" %>
    
    <div class="layout">
	    
	  <a href="${pageContext.request.contextPath}/controller?action=recipefeed">
        <button class="btr-button">Back to recipes</button>
      </a>
	    
	    <main class="form-container">
	      
	      <h2>${recipe.title}</h2>
	
	      <div class="meta-info">
	        <p><strong>By:</strong> ${recipe.user.username}</p>
	        <p><strong>Date:</strong> ${recipe.formattedDate}</p>
	      </div>
	
	      <div class="row">
	        <div class="column data-block">
	          <label>Time</label>
	          <div class="value">${recipe.time} min</div>
	        </div>
	        <div class="column data-block">
	          <label>Cost</label>
	          <div class="value">${recipe.cost} kr</div>
	        </div>
	      </div>
	
	      <div class="data-block">
	        <label>Description</label>
	        <div class="value">${recipe.description}</div>
	      </div>
	
	      <div class="data-block">
	        <label>Instructions</label>
	        <div class="value">${recipe.instructions}</div>
	      </div>
	
	      <div class="data-block">
	        <label>Ingredients</label>
	        <div class="selected-ingredients-container">
	          <ul id="selected-quantities">
	            <c:forEach var="ri" items="${recipe.recipeIngredients}">
	              <li>${ri.quantity}</li>
	            </c:forEach>
	          </ul>
	          <ul id="selected-ingredients">
	            <c:forEach var="ri" items="${recipe.recipeIngredients}">
	              <li>${ri.ingredient.ingredientName}</li>
	            </c:forEach>
	          </ul>
	        </div>
	      </div>
	      
      </main>
    </div>
    
    <%-- Include the footer (footer2.jsp) --%>
    <%@ include file="/fragments/footer2.jsp" %>
    
  </div>
</body>
</html>
