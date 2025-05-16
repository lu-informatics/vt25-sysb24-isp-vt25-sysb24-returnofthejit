<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
  <title>Recipe Feed</title>

  <!-- Local stylesheet -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css?v=2" />
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/recipe-feed.css?v=3" />

  <!-- Fonts -->
  <link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;600&display=swap" rel="stylesheet">
  <link href="https://fonts.googleapis.com/css2?family=Archivo+Black&display=swap" rel="stylesheet">
  <link href="https://use.fontawesome.com/releases/v6.5.0/css/all.css" rel="stylesheet">
</head>
<body>
  <div class="page-container">
    
    <%@ include file="/fragments/header.jsp" %>
    
    <div class="layout">
      <main class="feed">
        <h3 id="page-title">Recipe Feed</h3>
        <p id="discover">Discover new recipes!</p>

        <div class="recipe-feed-grid">
          <c:forEach var="recipe" items="${recipes}">
            <div class="recipe-card">
              <div class="recipe-card-inner">
                <!-- Front -->
                <div class="recipe-card-front">
                  <h4>${recipe.title}</h4>
                  <p class="user">${recipe.user.username} • ${recipe.formattedDate}</p>
                  <p class="description">${recipe.description}</p>
                </div>

                <!-- Back -->
                <div class="recipe-card-back">
                  <div class="recipe-meta">
                    <div><i class="fas fa-clock"></i>${recipe.time} min</div>
                    <div><i class="fas fa-sack-dollar"></i>${recipe.cost} kr</div>
                  </div>
                  <a href="${pageContext.request.contextPath}/controller?action=recipedetails&id=${recipe.recipeID}">
                    <button class="view-button">View Recipe</button>
                  </a>
                </div>
              </div>
            </div>
          </c:forEach>
        </div>
      </main>
    </div>

    <%@ include file="/fragments/footer.jsp" %>
  </div>
</body>
</html>
