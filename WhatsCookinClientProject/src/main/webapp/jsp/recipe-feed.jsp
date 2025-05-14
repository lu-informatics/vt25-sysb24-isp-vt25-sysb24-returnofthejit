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
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/recipe-feed.css" />
  <!-- Fonts -->
  <link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;600&display=swap" rel="stylesheet">
  <link href="https://fonts.googleapis.com/css2?family=Moo+Lah+Lah&display=swap" rel="stylesheet">
  <link href="https://use.fontawesome.com/releases/v6.5.0/css/all.css" rel="stylesheet">
</head>
<body>
   <div class="page-container">
	  <div class="layout">
	
	    <%-- Include the sidebar --%>
	    <%@ include file="/fragments/sidebar.jsp" %>
	
	    <main class="feed">
	      <h3 id="page-title">Recipe Feed</h3>
	      <p id="discover">Discover new recipes!</p>
	
	      <c:forEach var="recipe" items="${recipes}">
	        <div class="recipe-card">
	          <div class="recipe-info">
	            <h4>${recipe.title}</h4>
	            <p class="user">${recipe.user.username} • ${recipe.formattedDate}</p>
	            <p class="description">${recipe.description}</p>
	            <button class="gtr">Go to recipe →</button>
	            <div class="mincostparent">
	              <div class="mincost">
	                <i class="fas fa-clock"></i><span> ${recipe.time} min</span>
	              </div>
	              <div class="mincost">
	                <i class="fas fa-sack-dollar"></i><span> ${recipe.cost} kr</span>
	              </div>
	            </div>
	          </div>
	        </div>
	      </c:forEach>
	    </main>
	  </div>
	  <%-- Include the footer --%>
	  <%@ include file="/fragments/footer.jsp" %>
	</div>
</body>
</html>
