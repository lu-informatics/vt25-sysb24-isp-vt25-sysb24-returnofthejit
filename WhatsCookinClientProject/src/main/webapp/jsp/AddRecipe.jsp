<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
  <title>Add Recipe</title>
  <link rel="stylesheet" href="styles.css" />
  <link href="https://use.fontawesome.com/releases/v6.5.0/css/all.css" rel="stylesheet">
  <link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;600&display=swap" rel="stylesheet">
  <link href="https://fonts.googleapis.com/css2?family=Moo+Lah+Lah&display=swap" rel="stylesheet">
  <link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;600&display=swap" rel="stylesheet">
  <!-- Tom Select CSS for a searchable drop down menu - ingredients -->
  <link href="https://cdn.jsdelivr.net/npm/tom-select@2.3.1/dist/css/tom-select.css" rel="stylesheet" />
   
</head>
<body>
  <div class="layout">
    <!-- Sidebar -->
    <aside class="sidebar">
      <h2 id="sidebar-logo">What’s Cookin’</h2>
      <ul>
        <li><i class="fas fa-house"></i><span> Home</span></li>
        <li><i class="fas fa-search"></i><span> Feed</span></li>
        <li><i class="fas fa-plus"></i><span> Add New Recipe</span></li>
        <li class="active"><i class="fas fa-utensils"></i><span> About</span></li>
      </ul>
    </aside>

    <!-- Form -->
    <main class="form-container">
      <h2>Add Recipe</h2>
      <form id="recipe-form">
        <label>Enter Recipe Name:</label>
        <input type="text" placeholder="Ex. Pasta Carbonara" />

        <div class="row">
          <div class="column">
            <label>Enter a short description of your recipe:</label>
            <textarea></textarea>
          </div>
          <div class="column">
            <label>Enter a summarized text of instructions:</label>
            <textarea></textarea>
          </div>
        </div>

        <div class="row">
          <div class="column">
            <label>Time (minutes):</label>
            <input type="text" />
          </div>
          <div class="column">
            <label>Cost per portion in SEK:</label>
            <input type="text" />
          </div>
        </div>

        <label>Ingredients:</label>
        <div class="ingredient-row">
         <div class="ingredient-select-wrapper">
          <select id="ingredient-select" placeholder="Select an ingredient..." autocomplete="off">
			  <option value="">Select ingredient</option>
			  <option value="egg">Egg</option>
			  <option value="milk">Milk</option>
			  <option value="pasta">Pasta</option>
			  <!-- Load with database list later  -->
		  </select>
		 </div>
         <input type="text" class="quantity-input" placeholder="Quantity" />
  		 <button type="button" class="add-ingredient-btn gtr">Add Ingredient</button>
        </div>

        <label>Selected Ingredients:</label>
        <ul id="selected-ingredients"></ul>

        <div class="submit-wrapper">
          <button type="submit" class="gtr">Add Recipe</button>
        </div>
      </form>
    </main>
  </div>
  <!-- Tom Select JS -->
 <script src="https://cdn.jsdelivr.net/npm/tom-select@2.3.1/dist/js/tom-select.complete.min.js"></script>
 <script>
    new TomSelect('#ingredient-select', {
      create: false,
      sortField: {
        field: "text",
        direction: "asc"
      }
    });
 </script>
</body>
</html>
