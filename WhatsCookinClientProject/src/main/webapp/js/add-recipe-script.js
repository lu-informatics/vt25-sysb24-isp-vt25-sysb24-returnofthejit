document.addEventListener('DOMContentLoaded', () => {
  const selectElement = document.querySelector('#ingredient-select');

  if (!selectElement) {
    console.error('ingredient-select not found');
    return;
  }

  new TomSelect(selectElement, {
    create: false,
    sortField: { field: "text", direction: "asc" },
    plugins: ['dropdown_input'],
    maxItems: 1
  });

  const form = document.getElementById('recipe-form');
  const selectedIngredients = [];

  function showError(input, message) {
    removeError(input);

    input.classList.add('input-error');

    const error = document.createElement('div');
    error.className = 'error-message';
    error.innerText = message;

    input.parentNode.appendChild(error);
  }

  function removeError(input) {
    input.classList.remove('input-error');
    const next = input.parentNode.querySelector('.error-message');
    if (next) next.remove();
  }

  function isPositiveInteger(value) {
    return /^\d+$/.test(value) && Number(value) >= 0;
  }

  function validateForm() {
    let isValid = true;

    const nameInput = form.querySelector('input[name="recipeName"]');
    const descInput = form.querySelector('textarea[name="description"]');
    const instrInput = form.querySelector('textarea[name="instructions"]');
    const timeInput = form.querySelector('input[name="time"]');
    const costInput = form.querySelector('input[name="cost"]');

    const inputs = [nameInput, descInput, instrInput, timeInput, costInput];

    inputs.forEach(input => removeError(input));

    if (nameInput.value.trim() === "") {
      showError(nameInput, "Recipe name is required.");
      isValid = false;
    }

    if (descInput.value.trim() === "") {
      showError(descInput, "Description is required.");
      isValid = false;
    }

    if (instrInput.value.trim() === "") {
      showError(instrInput, "Instructions are required.");
      isValid = false;
    }

    if (!isPositiveInteger(timeInput.value)) {
      showError(timeInput, "Time must be a non-negative whole number.");
      isValid = false;
    }

    if (!isPositiveInteger(costInput.value)) {
      showError(costInput, "Cost must be a non-negative whole number.");
      isValid = false;
    }

    if (selectedIngredients.length === 0) {
      alert("Please add at least one ingredient.");
      isValid = false;
    }

    return isValid;
  }

  form.addEventListener('submit', (e) => {
    if (!validateForm()) {
      e.preventDefault();
    }
  });

  window.addIngredient = function () {
    const select = document.getElementById('ingredient-select');
    const quantityInput = document.getElementById('ingredient-quantity');
    const ingredientId = select.value;
    const ingredientName = select.options[select.selectedIndex]?.text;
    const quantity = quantityInput.value.trim();

	removeError(select);

	if (!ingredientId) {
	  showError(select, "Please select an ingredient.");
	  return;
	}

	if (selectedIngredients.find(item => item.id === ingredientId)) {
	  showError(select, "This ingredient has already been added.");
	  return;
	}


    selectedIngredients.push({ id: ingredientId, quantity });

    const qtyLi = document.createElement('li');
    qtyLi.textContent = quantity;
    document.getElementById('selected-quantities').appendChild(qtyLi);

    const nameLi = document.createElement('li');
    nameLi.textContent = ingredientName;
    document.getElementById('selected-ingredients').appendChild(nameLi);

    document.getElementById('selected-quantities').classList.add('filled');
    document.getElementById('selected-ingredients').classList.add('filled');

    document.getElementById('ingredients-data').value = JSON.stringify(selectedIngredients);

    select.tomselect.clear();
    quantityInput.value = '';
  };
});
