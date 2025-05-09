<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
  <title>About Us – What's Cookin'</title>

  <!-- Local stylesheet -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css" />

  <!-- Fonts -->
  <link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;600&display=swap" rel="stylesheet">
  <link href="https://fonts.googleapis.com/css2?family=Moo+Lah+Lah&display=swap" rel="stylesheet">

  <!-- Font Awesome (optional if you’re using icons) -->
  <link href="https://use.fontawesome.com/releases/v6.5.0/css/all.css" rel="stylesheet">
</head>
<body>
  <div class="layout">
    <!-- Sidebar -->
    <aside class="sidebar">
      <h2 id="sidebar-logo">What’s Cookin’</h2>
      <ul>
        <li>
          <a href="${pageContext.request.contextPath}/controller?action=home">
            <i class="fas fa-house"></i><span> Home</span>
          </a>
        </li>
        <li>
          <a href="${pageContext.request.contextPath}/controller?action=recipefeed">
            <i class="fas fa-search"></i><span> Feed</span>
          </a>
        </li>
        <li>
          <a href="${pageContext.request.contextPath}/controller?action=addrecipe">
            <i class="fas fa-plus"></i><span> Add New Recipe</span>
          </a>
        </li>
        <li class="active">
          <a href="${pageContext.request.contextPath}/controller?action=about">
            <i class="fas fa-utensils"></i><span> About</span>
          </a>
        </li>
      </ul>
    </aside>

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
          <img src="${pageContext.request.contextPath}/images/founder-ah.jpg" alt="Founder 1" />
          <h3>Amelie Hörnfeldt</h3>
          <p>Backend Developer</p>
        </div>
        <div class="founder-card">
          <img src="${pageContext.request.contextPath}/images/founder-hg.jpg" alt="Founder 2" />
          <h3>Hugo Gunnarson</h3>
          <p>Backend Developer</p>
        </div>
        <div class="founder-card">
          <img src="${pageContext.request.contextPath}/images/founder-ps.jpg" alt="Founder 3" />
          <h3>Peggy Schnitzer</h3>
          <p>Frontend Developer</p>
        </div>
        <div class="founder-card">
          <img src="${pageContext.request.contextPath}/images/founder-if.jpg" alt="Founder 4" />
          <h3>Isak Frankfeldt</h3>
          <p>All-round/Mood manager</p>
        </div>
        <div class="founder-card">
          <img src="${pageContext.request.contextPath}/images/founder-to.jpg" alt="Founder 5" />
          <h3>Tobias Omming</h3>
          <p>Sick Bastard</p>
        </div>
      </div>
    </main>
  </div>
</body>
</html>
