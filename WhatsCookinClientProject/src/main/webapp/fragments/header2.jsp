<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/header2.css" />

<link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;600&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Playfair+Display:wght@400;700&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Moo+Lah+Lah&display=swap" rel="stylesheet">


<header class="site-header">
 <div class="header-container">
   <div class="logo">
     <a href="${pageContext.request.contextPath}/controller?action=home">What's Cookin'</a>
   </div>
   <nav class="nav-links">
     <a href="${pageContext.request.contextPath}/controller?action=home">Home</a>
     <a href="${pageContext.request.contextPath}/controller?action=recipefeed">Recipes</a>
     <a href="${pageContext.request.contextPath}/controller?action=addrecipe">Add Recipe</a>
     <a href="${pageContext.request.contextPath}/controller?action=about">About</a>
    </nav>
  </div>
</header>
