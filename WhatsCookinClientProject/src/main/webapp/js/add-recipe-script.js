document.addEventListener('DOMContentLoaded', () => {
  const selectElement = document.querySelector('#ingredient-select');

  if (!selectElement) {
    console.error('ingredient-select not found');
    return;
  }

  console.log('Initializing TomSelect...');

  new TomSelect(selectElement, {
    create: false,
    sortField: {
      field: "text",
      direction: "asc"
    },
    plugins: ['dropdown_input'], // Enables search
    maxItems: 1 // Single selection
  });
});

  const selectedIngredients = [];

  window.addIngredient = function () {
    const select = document.getElementById('ingredient-select');
    const quantityInput = document.getElementById('ingredient-quantity');
    const ingredientId = select.value;
    const ingredientName = select.options[select.selectedIndex].text;
    const quantity = quantityInput.value;

    if (!ingredientId || !quantity) {
      alert("Please select an ingredient and provide a quantity.");
      return;
    }

    selectedIngredients.push({ id: ingredientId, quantity });

    const qtyLi = document.createElement('li');
    qtyLi.textContent = `${quantity}`;
	document.getElementById('selected-quantities').appendChild(qtyLi);
	
	const nameLi = document.createElement('li');
	nameLi.textContent = `${ingredientName}`;
	document.getElementById('selected-ingredients').appendChild(nameLi);
	
	// Add the background class after adding the first ingredient
	document.getElementById('selected-quantities').classList.add('filled');
	document.getElementById('selected-ingredients').classList.add('filled');	

    document.getElementById('ingredients-data').value = JSON.stringify(selectedIngredients);

    select.selectedIndex = 0;
    quantityInput.value = '';
  };

