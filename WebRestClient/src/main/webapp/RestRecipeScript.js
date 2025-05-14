const BASE_URL = 'http://localhost:8080/WhatsCookin/Recipes';

$(document).ready(function() {
	$('#FindBtn').click(function() {
		let id = $('#recipeID').val();
		if (!id) return alert('Provide ID to find.');

		$.ajax({
			url: `${BASE_URL}/${id}`,
			method: 'GET',
			success: function(data) {
				fillForm(data);
				$('#updateFields').removeClass('hidden');
				$('#newFields').addClass('hidden');
			},
			error: () => alert('Recipe not found')
		});
	});

	$('#NewRecipeBtn').click(function() {
		resetView();
		$('#newFields').removeClass('hidden');
	});

	$('#AddBtn').click(function() {
		let recipe = {
			title: $('#title').val(),
			cost: $('#cost').val(),
			time: $('#time').val(),
			instructions: $('#instructions').val(),
			description: $('#description').val()
		};
		$.ajax({
			url: `${BASE_URL}`,
			method: 'POST',
			contentType: 'application/json',
			data: JSON.stringify(recipe),
			success: () => {
				clearForm();
				alert('Recipe added successfully! ID: ${createdRecipe.id}');
				resetView();
			},
			error: () => alert('Could not add recipe')
		});
	});

	$('#UpdateBtn').click(function() {
		let id = $('#recipeID').val();
		if (!id) return alert('Provide ID to update.');

		let recipe = {
			id: id,
			no: $('#recipeNo').val(),
			title: $('#title').val(),
			cost: $('#cost').val(),
			time: $('#time').val(),
			instructions: $('#instructions').val(),
			description: $('#description').val()
		};
		$.ajax({
			url: `${BASE_URL}/${id}`,
			method: 'PUT',
			contentType: 'application/json',
			data: JSON.stringify(recipe),
			success: () => {
				clearForm();
				alert('Recipe updated successfully!');
				resetView();
			},
			error: () => alert('Could not update recipe')
		});
	});

	$('#DeleteBtn').click(function() {
		let id = $('#recipeID').val();
		if (!id) return alert('Provide ID to delete.');

		$.ajax({
			url: `${BASE_URL}/${id}`,
			method: 'DELETE',
			success: () => {
				clearForm();
				resetView();
				alert('Recipe deleted!');
			},
			error: () => alert('Could not delete recipe')
		});
	});
});

function readForm() {
	return {
		id: $('#recipeID').val(),
		no: $('#recipeNo').val(),
		title: $('#title').val(),
		cost: $('#cost').val(),
		time: $('#time').val(),
		instructions: $('#instructions').val(),
		description: $('#description').val()
	};
}

function fillForm(data) {
	$('#recipeID').val(data.id || '');
	$('#recipeNo').val(data.no || '');
	$('#title').val(data.title || '');
	$('#cost').val(data.cost || '');
	$('#time').val(data.time || '');
	$('#instructions').val(data.instructions || '');
	$('#description').val(data.description || '');
}

function clearForm() {
	$('#recipeID').val('');
	$('#recipeNo').val('');
	$('#title').val('');
	$('#cost').val('');
	$('#time').val('');
	$('#instructions').val('');
	$('#description').val('');
}

function showEditFields() {
	$('#editFields').removeClass('hidden');
}

function hideEditFields() {
	$('#editFields').addClass('hidden');
	clearForm();
}

function resetView() {
	clearForm();
	$('#recipeID').val('');
	$('#updateFields').addClass('hidden');
	$('#newFields').addClass('hidden');
}
