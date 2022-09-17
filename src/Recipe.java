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

    public Recipe(String recipeName, List<WeightedIngredient> ingredientListRecipe){
        this.recipeName = recipeName;
        this.ingredientListRecipe =  new ArrayList<>();
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

    public void getScaledRecipe(double value) {
        Recipe scaledRecipe = new Recipe(recipeName, ingredientListRecipe);
        Database.addRecipe(scaledRecipe);
        for (WeightedIngredient weightedIngredient : this.ingredientListRecipe) {
            scaledRecipe.ingredientListRecipe.add(new WeightedIngredient(weightedIngredient.getIngredientName(), ((weightedIngredient.getWeight())*value)/100, weightedIngredient.getPricePerUnit()*(value/100)));
        }
    }

    public void setLevel(Level level) {
        this.level = level;
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
