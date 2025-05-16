<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Recipe CRUD</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="RestRecipe.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="RestRecipeScript.js"></script>
</head>
<body>
    <header>
        <h1>Recipe REST Client</h1>
    </header>
    <main>
        <section class="card">
            <h2>Recipe Manager</h2>
            <div class="form-group">
                <label for="recipeID">Recipe ID</label>
                <input type="text" id="recipeID">
                <button id="FindBtn">Find</button>
                <button id="NewRecipeBtn">New Recipe</button>
            </div>

            <div id="updateFields" class="hidden">
                <h3>Update Recipe</h3>
                <label>Recipe No</label>
                <input type="text" id="recipeNo" readonly>
                <label>Title</label>
                <input type="text" id="title">
                <label>Cost</label>
                <input type="text" id="cost">
                <label>Time</label>
                <input type="text" id="time">
                <label>Instructions</label>
                <textarea id="instructions"></textarea>
                <label>Description</label>
                <textarea id="description"></textarea>
                <button id="UpdateBtn">Update</button>
                <button id="DeleteBtn" class="danger">Delete</button>
            </div>

            <div id="newFields" class="hidden">
                <h3>New Recipe</h3>
                <label>Title</label>
                <input type="text" id="new_title">
                <label>Cost</label>
                <input type="text" id="new_cost">
                <label>Time</label>
                <input type="text" id="new_time">
                <label>Instructions</label>
                <textarea id="new_instructions"></textarea>
                <label>Description</label>
                <textarea id="new_description"></textarea>
                <button id="AddBtn">Add</button>
            </div>
        </section>
    </main>
    <footer>
        <p>&copy; 2025 Recipe Client - Informatik</p>
    </footer>
</body>
</html>
