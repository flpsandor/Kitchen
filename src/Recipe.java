import java.util.ArrayList;
import java.util.List;

public class Recipe implements Priceable{
    private final String recipeName;
    private Level level = Level.BEGGINER;
    private final List<WeightedIngredient> ingredientListRecipe;

    public Recipe(String recipeName, Level level) {
        this.recipeName = recipeName;
        this.level = level;
        this.ingredientListRecipe = new ArrayList<>();
        Database.addRecipe(this);
    }

    public void addIngredientInRecipe(String ingredientName, double ingredientWeight){
        ingredientListRecipe.add(new WeightedIngredient(ingredientName, ingredientWeight,this.getPrice()*ingredientWeight));
    }

    public String getRecipeName() {
        return recipeName;
    }

    public Level getLevel() {
        return level;
    }

    public List<WeightedIngredient> getIngredientListRecipe() {
        return ingredientListRecipe;
    }

    @Override
    public double getPrice() {
        var price = 0;
        for(var item: ingredientListRecipe){
            price += (Database.getIngredient(item.getIngredientName()).getPricePerUnit())*(item.getWeight());
        }
        return price;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "recipeName='" + recipeName + '\'' +
                ", level=" + level +
                ", ingredientListRecipe=" + ingredientListRecipe +
                '}';
    }
}
