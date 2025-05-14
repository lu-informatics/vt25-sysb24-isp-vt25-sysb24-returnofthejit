<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Recipe CRUD</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="RestRecipe.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="RestRecipeScript.js"></script>
</head>
<body>
	<header>
		<p>Recipe REST Client</p>
	</header>
	<section id="row">
		<nav>
			<ul>
				<li class="active"><a href="#">CRUD</a></li>
				<li><a href="#">About</a></li>
			</ul>
		</nav>
		<section id="main">
			<section id="content">
				<article>
					<fieldset id="RecipeFS">
						<legend>Recipe</legend>

						<!-- ID + Find visible always -->
						ID:<br> <input type="text" id="recipeID"><br> <input
							type="button" value="Find" id="FindBtn"><br>
						<br>

						<!-- Knapp för nytt recept -->
						<input type="button" value="New Recipe" id="NewRecipeBtn"><br>
						<br>

						<!-- Fält för uppdatering (visas efter Find) -->
						<div id="updateFields" class="hidden">
							<!-- Recipe No endast visas, ej redigerbar -->
							Recipe No:<br> <input type="text" id="recipeNo" readonly><br>
							Title:<br> <input type="text" id="title"><br>
							Cost:<br> <input type="text" id="cost"><br>
							Time:<br> <input type="text" id="time"><br>
							Instructions:<br>
							<textarea id="instructions"></textarea>
							<br> Description:<br>
							<textarea id="description"></textarea>
							<br>
							<br> <input type="button" value="Update" id="UpdateBtn">
							<input type="button" value="Delete" id="DeleteBtn">
						</div>

						<!-- Fält för nytt recept (visas efter New Recipe) -->
						<div id="newFields" class="hidden">
							Title:<br> <input type="text" id="new_title"><br>
							Cost:<br> <input type="text" id="new_cost"><br>
							Time:<br> <input type="text" id="new_time"><br>
							Instructions:<br>
							<textarea id="new_instructions"></textarea>
							<br> Description:<br>
							<textarea id="new_description"></textarea>
							<br>
							<br> <input type="button" value="Add" id="AddBtn">
						</div>
					</fieldset>


				</article>
			</section>
		</section>
	</section>
	<footer>
		<p>&copy; Recipe Client - Informatik</p>
	</footer>
</body>
</html>
