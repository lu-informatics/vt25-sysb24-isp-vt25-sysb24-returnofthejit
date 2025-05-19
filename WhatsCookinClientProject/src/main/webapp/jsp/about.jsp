<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
  <title>About Us – What's Cookin'</title>

  <!-- Local stylesheet -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/about.css" />
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css" />

  <!-- Fonts -->
  <link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;600&display=swap" rel="stylesheet">
  <link href="https://fonts.googleapis.com/css2?family=Moo+Lah+Lah&display=swap" rel="stylesheet">
  <link href="https://fonts.googleapis.com/css2?family=Archivo+Black&display=swap" rel="stylesheet">

  <!-- Font Awesome (optional if you’re using icons) -->
  <link href="https://use.fontawesome.com/releases/v6.5.0/css/all.css" rel="stylesheet">
</head>
<body>
  <div class="page-container">
	  
	  <%-- Include the header (header2.jsp) --%>
	  <%@ include file="/fragments/header2.jsp" %>
	  
	  <div class="layout">
	    
	    <!-- Main content -->
	    <main class="about-content">
	      <h1>About What's Cookin'</h1>
	      <p class="description">
	        We’re a food-loving team of students who built What's Cookin' to make sharing meals and recipes easier, more fun, and more social.
	        Whether you're a kitchen pro or just starting out, our app helps you connect with friends and share what you’re cookin’.
	      </p>
	
	      <h2>Our Founders</h2>
	      <div class="founders-grid">
	        <div class="founder-card">
	          <img src="${pageContext.request.contextPath}/images/founder-ah.jpeg" alt="Founder 1" />
	          <h3>Amelie Hörnfeldt</h3>
	          <p>Backend Developer</p>
	        </div>
	        <div class="founder-card">
	          <img src="${pageContext.request.contextPath}/images/founder-hg.jpg" alt="Founder 2" />
	          <h3>Hugo Gunnarson</h3>
	          <p>Backend Developer</p>
	        </div>
	        <div class="founder-card">
	          <img src="${pageContext.request.contextPath}/images/founder-ps.jpeg" alt="Founder 3" />
	          <h3>Peggy Schnitzer</h3>
	          <p>Frontend Developer</p>
	        </div>
	        <div class="founder-card">
	          <img src="${pageContext.request.contextPath}/images/founder-if.jpeg" alt="Founder 4" />
	          <h3>Isak Frankfeldt</h3>
	          <p>All-round/Mood manager</p>
	        </div>
	        <div class="founder-card">
	          <img src="${pageContext.request.contextPath}/images/founder-to.jpeg" alt="Founder 5" />
	          <h3>Tobias Omming</h3>
	          <p>Senorita Awesome</p>
	        </div>
	      </div>
	    </main>
	  </div>
	  <%-- Include the footer (footer2.jsp) --%>
	  <%@ include file="/fragments/footer2.jsp" %>
  </div>
</body>
</html>
