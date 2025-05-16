const BASE_URL = 'http://localhost:8080/WhatsCookinClientProject/Recipes';

$(document).ready(function () {
    $('#FindBtn').click(function () {
        let id = $('#recipeID').val();
        if (!id) return alert('Provide ID to find.');

        $.ajax({
            url: `${BASE_URL}/${id}`,
            method: 'GET',
            success: fillForm,
            error: () => alert('Recipe not found')
        });
    });

    $('#AddBtn').click(function () {
        let recipe = readForm();
        $.ajax({
            url: `${BASE_URL}`,
            method: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(recipe),
            success: fillForm,
            error: () => alert('Could not add recipe')
        });
    });

    $('#UpdateBtn').click(function () {
        let id = $('#recipeID').val();
        if (!id) return alert('Provide ID to update.');

        let recipe = readForm();
        $.ajax({
            url: `${BASE_URL}/${id}`,
            method: 'PUT',
            contentType: 'application/json',
            data: JSON.stringify(recipe),
            success: fillForm,
            error: () => alert('Could not update recipe')
        });
    });

    $('#DeleteBtn').click(function () {
        let id = $('#recipeID').val();
        if (!id) return alert('Provide ID to delete.');

        $.ajax({
            url: `${BASE_URL}/${id}`,
            method: 'DELETE',
            success: () => alert('Recipe deleted'),
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