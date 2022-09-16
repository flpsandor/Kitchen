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

    public Recipe(String recipeName) {
        this.recipeName = recipeName;
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

    public void getScalled(Recipe recipe, double scale){
        var name = recipe.getRecipeName()+"scaled";
        var newRecipe = new Recipe(name, recipe.getLevel());
        for(var item: recipe.getIngredientListRecipe()){
            newRecipe.addIngredientInRecipe(item.getIngredientName(),item.getWeight()/(100 * scale));
        }
    }

    public Recipe getScaledRecipe(double procentage) {
        Recipe scaledRecipe = new Recipe(this.recipeName);
        for (WeightedIngredient weightedIngredient : this.ingredientListRecipe){
            weightedIngredient.withScaledWeight(procentage);
        }
        scaledRecipe.level=this.level;
        return scaledRecipe;
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
