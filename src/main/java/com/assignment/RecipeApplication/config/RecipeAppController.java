package com.assignment.RecipeApplication.config;
import com.assignment.RecipeApplication.domain.Recipe;
import com.assignment.RecipeApplication.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;
import java.util.List;

@RestController
public class RecipeAppController {

    private final RecipeService recipeService;

    @Autowired
    public RecipeAppController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("/")
    public RedirectView redirectToHomepage() {
        return new RedirectView("/homepage.html");
    }

    @GetMapping("/all-recipes")
    public List<Recipe> getAllRecipes() {
        return recipeService.getAllRecipes();
    }

    @GetMapping("/gluten-free")
    public List<Recipe> getGlutenFreeRecipes() {
        return recipeService.filterRecipes(recipe -> recipe.getGlutenFree() != null && recipe.getGlutenFree());
    }

    @GetMapping("/vegan")
    public List<Recipe> getVeganRecipes() {
        return recipeService.filterRecipes(recipe -> recipe.getVegan() != null && recipe.getVegan());
    }

    @GetMapping("/vegan-and-gluten-free")
    public List<Recipe> getVeganAndGlutenFreeRecipes() {
        return recipeService.filterRecipes(recipe -> (recipe.getVegan() != null && recipe.getVegan()) && (recipe.getGlutenFree() != null && recipe.getGlutenFree()));
    }

    @GetMapping("/vegetarian")
    public List<Recipe> getVegetarianRecipes() {
        return recipeService.filterRecipes(recipe -> recipe.getVegetarian() != null && recipe.getVegetarian());
    }
}
