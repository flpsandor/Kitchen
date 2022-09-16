import java.util.ArrayList;
import java.util.List;

public class Database {
    private static final List<WeightedIngredient> ingredientListInDatabase = new ArrayList<>();
    private static final List<Recipe> recipeListInDatabase = new ArrayList<>();
    private static final List<Recipe> favoriteRecipeList = new ArrayList<>();

    public static void putIngredientInFridge() {
        for (var item : ingredientListInDatabase) {
            Fridge.addInFridge(item);
        }
    }

    public static void subtractIngredientWeight(WeightedIngredient ingredient, Double value) {
        var weight = ingredient.getWeight();
        ingredient.setWeight(weight - value);
    }

    public static void additionIngredientWeight(WeightedIngredient ingredient, Double value) {
        var weight = ingredient.getWeight();
        ingredient.setWeight(weight + value);
    }

    public static Recipe getFavoriteRecipe(String recipeName) {
        for (var recipe : favoriteRecipeList) {
            if (recipeName.equalsIgnoreCase(recipe.getRecipeName())) {
                return recipe;
            }
        }
        return null;
    }

    public static void removeFavoriteRecipe(String recipeName) {
        favoriteRecipeList.removeIf(recipe -> recipeName.equalsIgnoreCase(recipe.getRecipeName()));
    }

    public static void addFavoriteRecipe(String recipeName) {
        for (var recipe : recipeListInDatabase) {
            if (recipeName.equalsIgnoreCase(recipe.getRecipeName()) && !favoriteRecipeList.contains(recipe)) {
                favoriteRecipeList.add(recipe);
            }
        }
    }

    public static List<Recipe> getAllFavoriteRecipe() {
        return new ArrayList<>(favoriteRecipeList);
    }

    public static WeightedIngredient getIngredient(String ingredientName) {
        for (var item : ingredientListInDatabase) {
            if (item.ingredientName.equalsIgnoreCase(ingredientName)) {
                return item;
            }
        }
        return null;
    }

    public static void addIngredient(WeightedIngredient ingredient) {
        if (!ingredientListInDatabase.contains(ingredient.ingredientName)) {
            ingredientListInDatabase.add(ingredient);
            Fridge.addInFridge(ingredient);
        } else {
            for (var item : ingredientListInDatabase) {
                if (ingredient.ingredientName.equalsIgnoreCase(item.ingredientName)) {
                    additionIngredientWeight(item, ingredient.weight);
                }
            }
        }
    }


    public static List<WeightedIngredient> getAllIngredients() {
        return new ArrayList<>(ingredientListInDatabase);
    }

    public static void removeIngredient(String ingredientName) {
        ingredientListInDatabase.removeIf(item -> ingredientName.equalsIgnoreCase(item.getIngredientName()));
        Fridge.getIngredientListInFridge().removeIf(item -> ingredientName.equalsIgnoreCase(item.getIngredientName()));
    }

    public static Recipe getRecipe(String recipeName) {
        for (var recipe : recipeListInDatabase) {
            if (recipeName.equalsIgnoreCase(recipe.getRecipeName())) {
                return recipe;
            }
        }
        return null;
    }

    public static void addRecipe(Recipe recipe) {
        if (!recipeListInDatabase.contains(recipe)) {
            recipeListInDatabase.add(recipe);
        }
    }

    public static List<Recipe> getAllRecipes() {
        return new ArrayList<>(recipeListInDatabase);
    }

    public static void printAllRecipes(){
        for(var recipe: recipeListInDatabase){
            System.out.println(recipe.getRecipeName()+" "+recipe.getPrice());
        }
    }

    public static void removeRecipe(String recipeName) {
        for (var recipe : recipeListInDatabase) {
            if (recipeName.equalsIgnoreCase(recipe.getRecipeName())) {
                recipeListInDatabase.remove(recipeName);
            }
        }
    }

    public static void getSortedRecipesByLevel(Level l) {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < Database.getAllRecipes().size(); i++) {
            if (Database.getAllRecipes().get(i).getLevel().equals(l)) {
                list.add(Database.getAllRecipes().get(i).getRecipeName());
            }
        }
        System.out.println(list);
    }

    public static void printIngredientListFromFridge(){
        for(var item:Fridge.getIngredientListInFridge()){
            System.out.println(item.getIngredientName()+", "+item.getWeight());
        }
    }


}
