<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/sidebar.css" />
<aside class="sidebar">
 <h2 id="sidebar-logo">What’s Cookin’</h2>
  <nav>
  	<div class="sidebar">
      <ul>
	      <li class="sidebar-list">
	        <a href="${pageContext.request.contextPath}/controller?action=home">
	          <i class="fas fa-house"></i><span> Home</span>
	        </a>
	      </li>
	      <li class="sidebar-list">
	        <a href="${pageContext.request.contextPath}/controller?action=recipefeed">
	          <i class="fas fa-search"></i><span> Feed</span>
	        </a>
	      </li>
	      <li class="sidebar-list">
	        <a href="${pageContext.request.contextPath}/controller?action=addrecipe">
	          <i class="fas fa-plus"></i><span> Add New Recipe</span>
	        </a>
	      </li>
	      <li class="sidebar-list">
	        <a href="${pageContext.request.contextPath}/controller?action=about">
	          <i class="fas fa-utensils"></i><span> About</span>
	        </a>
	      </li>
	    </ul>
	</div>
  </nav>
</aside>
