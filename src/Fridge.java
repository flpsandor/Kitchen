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


}
