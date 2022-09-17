import java.util.ArrayList;
import java.util.List;

public class Fridge {
    private static final List<WeightedIngredient> ingredientListInFridge=new ArrayList<>();


    public static void addInFridge(WeightedIngredient ingredient) {
        ingredientListInFridge.add(ingredient);
    }

    public static List<WeightedIngredient> getIngredientListInFridge() {
        return ingredientListInFridge;
    }

    public static void removeInFridge(String ingredientName){
        ingredientListInFridge.removeIf(item -> item.ingredientName.equalsIgnoreCase(ingredientName));
    }

    public static boolean recipeCheck(Recipe recipe, ArrayList<WeightedIngredient> ingredientinFridge) {
        for (WeightedIngredient checkRecipe : recipe.getIngredientListRecipe()) {
            for (WeightedIngredient checkFridge : ingredientinFridge) {
                if (checkFridge.getIngredientName().equalsIgnoreCase(checkRecipe.getIngredientName()) && checkFridge.getWeight() >= checkRecipe.getWeight()) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void makeRecipe(String recipeName){
        for(var recipe: Database.getAllRecipes()){
            if(recipe.getRecipeName().equalsIgnoreCase(recipeName)){
                for(int i=0;i<recipe.getIngredientListRecipe().size();i++){
                    Database.subtractIngredientWeight(Database.getIngredient(recipe.getIngredientListRecipe().get(i).getIngredientName()), recipe.getIngredientListRecipe().get(i).getWeight());
                }

            }

        }
    }


}
