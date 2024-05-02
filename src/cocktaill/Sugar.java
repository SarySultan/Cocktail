package cocktaill;

// Represents sugar as an ingredient
public class Sugar extends Ingredient {

    public Sugar(String name, double calorie, double volume, String taste, boolean isSweet, int sweetness) {
        super(name, calorie, volume, taste, isSweet, sweetness);
    }

    // Method to return information about the sugar
    @Override
    public String getInfo() {
        return super.getInfo();
    }
}
