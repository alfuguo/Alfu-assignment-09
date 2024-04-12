package com.assignment.RecipeApplication.service;

import com.assignment.RecipeApplication.domain.Recipe;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class RecipeService {

    @Autowired
    private FileService fileService;
    private List<Recipe> recipes;

    @PostConstruct
    public void readAndCreateRecipeList() throws IOException {
        recipes = fileService.readFile();
    }
    public List<Recipe> getAllRecipes() {
        return recipes;
    }
    public List<Recipe> filterRecipes(Predicate<Recipe> filterCriteria) {
        List<Recipe> allRecipes = getAllRecipes();
        return allRecipes.stream()
                .filter(filterCriteria)
                .collect(Collectors.toList());
    }
}
