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
  <link href="https://fonts.googleapis.com/css2?family=Playfair+Display:wght@400;700&display=swap" rel="stylesheet">
  <link href="https://fonts.googleapis.com/css2?family=Archivo+Black&display=swap" rel="stylesheet">
  
   
</head>
<body>
  <div class="page-container">
      <%-- Include the header (header.jsp) --%>
	  <%@ include file="/fragments/header.jsp" %>
	  
	  <div class="layout">
	
	    <!-- Main Content -->
	    <main class="home-content">
	      <h1 id="title-home">SHARING IS CARING</h1>
	      <div class="image-wrapper">
	        <img src="${pageContext.request.contextPath}/images/homepagehands.png" alt="Hands Image" class="hands-img" />
	      </div>
	      <section class="split-section">
			  <div class="left-column">
			    <h2>WHAT'S COOKIN'<br>GOOD LOOKIN'</h2>
			  </div>
			  <div class="right-column">
			    <p>
			      Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur dignissim, justo sit amet suscipit volutpat, neque sem luctus nisi, in feugiat nisi justo ac orci.
			    </p>
			  </div>
			</section>
	      <p id="slogan">Recipes worth sharing!</p>
	      
	      <div class="stat-box">
	        <h2>Aktivitet idag</h2>
	        <p><strong>${nbrOfRecipesToday}</strong> recept har skapats idag.</p>
	      </div>

	      <!-- Weather Section -->
	      <section id="weather">
	          <h2>What's the cookin weather today?</h2>
	        <p><strong>City:</strong> <span id="city">Loading...</span></p>
	        <p><strong>Temperature:</strong> <span id="degree"></span> °C</p>
	        <p><strong>Weather:</strong> <span id="weatherType"></span></p>
	        <p><strong>Sunrise:</strong> <span id="sunrise"></span></p>
	        <p><strong>Sunset:</strong> <span id="sunset"></span></p>
	      </section>
	      
	    </main>
	    
	  </div>
	  
	  <%-- Include the footer (footer.jsp) --%>
	  <%@ include file="/fragments/footer.jsp" %>
  </div>

  <!-- Weather Script -->
  <script src="${pageContext.request.contextPath}/js/home-weatherscript.js" defer></script>
</body>
</html>
