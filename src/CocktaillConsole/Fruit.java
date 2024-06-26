package CocktaillConsole;

import java.awt.Color;

// Represents a fruit as an ingredient
public class Fruit extends Ingredient {

    private Color color;

    public Fruit(String name, double calorie, double volume, String taste, boolean isSweet, int sweetness, Color color) {
        super(name, calorie, volume, taste, isSweet, sweetness);
        this.color = color;
    }

    // Getter for the color of the fruit
    public Color getColor() {
        return color;
    }



    // Method to return information about the fruit including its color
    @Override
    public String getInfo() {
        return super.getInfo();
               
    }

}
