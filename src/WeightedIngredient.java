public class WeightedIngredient extends Ingredient{
    protected double weight;
    private double pricePerUnit;

    public WeightedIngredient(String ingredientName,double weight, double pricePerUnit) {
        super(ingredientName);
        this.weight = weight;
        this.pricePerUnit = pricePerUnit;
    }

    public WeightedIngredient(String ingredientName, double weight){
        super(ingredientName);
        this.weight =  weight;
    }

    public double getWeight() {
        return weight;
    }

    public double getPricePerUnit() {
        return pricePerUnit;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setPricePerUnit(double pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }

    public WeightedIngredient ScaledWeight(double value) {
        return new WeightedIngredient(getIngredientName(), weight * (value / 100), pricePerUnit);
    }

    @Override
    public double getPrice() {
        return weight*pricePerUnit;
    }

    @Override
    public String toString() {
        return "WeightedIngredient{" +
                "weight=" + weight +
                ", pricePerUnit=" + pricePerUnit +
                ", id=" + id +
                ", ingredientName='" + ingredientName + '\'' +
                '}';
    }
}
