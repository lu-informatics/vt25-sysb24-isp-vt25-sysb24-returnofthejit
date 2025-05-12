<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
  <title>Recipe Feed</title>

  <!-- Local stylesheet -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css" />
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/recipe-feed.css" />
  <!-- Fonts -->
  <link href="https://fonts.googleapis.com/css2?family=Moo+Lah+Lah&display=swap" rel="stylesheet">
  <link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;600&display=swap" rel="stylesheet">
  <link href="https://use.fontawesome.com/releases/v6.5.0/css/all.css" rel="stylesheet">
</head>
<body>
  <div class="layout">
   
   	<%-- Include the sidebar --%>
    <%@ include file="/fragments/sidebar.jsp" %>

    <main class="feed">
      <h3 id="page-title">Recipe Feed</h3>
      <p id="discover">Discover new recipes!</p>

      <!-- Static cards for now – later replaced with dynamic JSTL/EL -->
      <div class="recipe-card">
        <div class="recipe-info">
          <h4>PastaPapi</h4>
          <p class="user">Hugo Gunnarson • 11 mars – kl. 12:20</p>
          <p class="description">Made a really nice Carbonara today for lunch! Both quick and easy!</p>
          <button class="gtr">Go to recipe →</button>
          <div class="minhrparent">
            <div class="minhr">
              <i class="fas fa-clock"></i><span> 30 min</span>
            </div>
            <div class="minhr">
              <i class="fas fa-sack-dollar"></i><span> 45 kr</span>
            </div>
          </div>
        </div>
      </div>

      <div class="recipe-card">
        <div class="recipe-info">
          <h4>SoupMommy</h4>
          <p class="user">Amelie Hörnfeldt • 11 mars – kl. 12:05</p>
          <p class="description">Today I made a yummy tomato soup, really recommend! Suuuuper easy to make!</p>
          <button class="gtr">Go to recipe →</button>
          <div class="minhrparent">
            <div class="minhr">
              <i class="fas fa-clock"></i><span> 25 min</span>
            </div>
            <div class="minhr">
              <i class="fas fa-sack-dollar"></i><span> 35 kr</span>
            </div>
          </div>
        </div>
      </div>
    </main>
  </div>
</body>
</html>
