<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
  <title>What's Cookin'</title>

  <!-- Länk till CSSen -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css" />
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/home.css" />

  <!-- Externa resurser (Font Awesome + Google Fonts) -->
  <link href="https://use.fontawesome.com/releases/v6.5.0/css/all.css" rel="stylesheet">
  <link href="https://fonts.googleapis.com/css2?family=Moo+Lah+Lah&display=swap" rel="stylesheet">
  <link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;600&display=swap" rel="stylesheet"> 
</head>
<body>
  <div class="page-container">
      <%-- Include the header (header.jsp) --%>
	  <%@ include file="/fragments/header.jsp" %>
	  
	  <div class="layout">
	
	    <!-- Main Content -->
	    <main class="home-content">
	      <h1 id="title-home">What’s Cookin’</h1>
	      <p id="slogan">Recipes worth sharing!</p>
	      <img src="${pageContext.request.contextPath}/images/homepagehands.png" alt="Hands Image" class="hands-img" />
	    </main>
	    
	  </div>
	  
	  <%-- Include the footer (footer.jsp) --%>
	  <%@ include file="/fragments/footer.jsp" %>
  </div>
</body>
</html>
