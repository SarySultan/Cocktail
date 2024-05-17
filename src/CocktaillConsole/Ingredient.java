package CocktaillConsole;

// Represents an ingredient used in cocktails(will go to Blender)
public abstract class Ingredient {

    private String name;
    private double calorie;
    private double volume;
//    The following three attributes were added to work on the new property added (taste)
//    You can read the project explanation file attached with the project to understand this new property well
    private String taste;//Sweet or Sour
    private boolean isSweet;//true->Sweet, false->Sour
    private int sweetness;//sweet->Degree of sweetness from 1 to 5, Sour->Degree of sweetness from -1 to -5

    // Constructor to initialize Ingredient object with specified properties
    public Ingredient(String name, double calorie, double volume, String taste, boolean isSweet, int sweetness) {
        this.name = name;
        this.calorie = calorie;
        this.volume = volume;
        this.taste = taste;
        this.isSweet = isSweet;
        this.sweetness = sweetness;
    }

    // Getters for each property
    public String getName() {
        return name;
    }

    public double getCalorie() {
        return calorie;
    }

    public double getVolume() {
        return volume;
    }

    public String getTaste() {
        return taste;
    }

    public boolean getIsSweet() {
        return isSweet;
    }

    public int getSweetness() {
        return sweetness;
    }

    // Method to return information about the ingredient
    public String getInfo() {

        return name
                + ", Calorie: " + calorie
                + ", Volume: " + volume;

    }
}
