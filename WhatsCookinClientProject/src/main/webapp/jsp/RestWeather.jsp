<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
  <title>Cooking Weather</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css" />
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/RestWeatherStyle.css" />
  
  <link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;600&display=swap" rel="stylesheet">
  <link href="https://fonts.googleapis.com/css2?family=Moo+Lah+Lah&display=swap" rel="stylesheet">
</head>
<body>
  <header>
    <h1>What's the cooking weather like?</h1>
  </header>
  
  <section id="weather">
    <p><strong>City:</strong> <span id="city">Loading...</span></p>
    <p><strong>Temperature:</strong> <span id="degree"></span> °C</p>
    <p><strong>Weather:</strong> <span id="weatherType"></span></p>
    <p><strong>Sunrise:</strong> <span id="sunrise"></span></p>
    <p><strong>Sunset:</strong> <span id="sunset"></span></p>
  </section>

  <script src="${pageContext.request.contextPath}/js/RestWeatherScript.js" defer></script>
</body>
</html>