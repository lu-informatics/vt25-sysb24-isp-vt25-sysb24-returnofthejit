<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Recipe CRUD</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" href="RestRecipe.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
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
                    ID:<br>
                    <input type="text" id="recipeID"><br>
                    No:<br>
                    <input type="text" id="recipeNo"><br>
                    Title:<br>
                    <input type="text" id="title"><br>
                    Cost:<br>
                    <input type="text" id="cost"><br>
                    Time:<br>
                    <input type="text" id="time"><br>
                    Instructions:<br>
                    <textarea id="instructions"></textarea><br>
                    Description:<br>
                    <textarea id="description"></textarea><br><br>
                    <input type="button" value="Find" id="FindBtn">
                    <input type="button" value="Add" id="AddBtn">
                    <input type="button" value="Update" id="UpdateBtn">
                    <input type="button" value="Delete" id="DeleteBtn">
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
