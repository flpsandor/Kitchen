public class WeightedIngredient extends Ingredient{
    protected double weight;
    private double pricePerUnit;

    public WeightedIngredient(String ingredientName,double weight, double pricePerUnit) {
        super(ingredientName);
        this.weight = weight;
        this.pricePerUnit = pricePerUnit;
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
