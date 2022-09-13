public abstract class Ingredient implements Priceable{
    private static int count=0;
    int id;
    String ingredientName;

    public Ingredient(String ingredientName) {
        this.ingredientName = ingredientName;
        this.id = count++;
    }

    public String getIngredientName() {
        return ingredientName;
    }
}
