package cocktaill;

import java.awt.Color;

// Represents a cocktail with various properties
public class Cocktail {

    private Color finalColor;
    private double totalCalories;
    private double totalVolume;
    private int totalTaste;

    public Cocktail() {
        this.finalColor = new Color(0, 0, 0);
        this.totalCalories = 0;
        this.totalVolume = 0.0;
        this.totalTaste = 0;

    }

    // Constructor to initialize Cocktail object with properties
    public Cocktail(Color finalColor, double totalCalories, double totalVolume, int totalTaste) {
        this.finalColor = finalColor;
        this.totalCalories = totalCalories;
        this.totalVolume = totalVolume;
        this.totalTaste = totalTaste;
    }
    // Getters and setters for Cocktail properties

    public void setFinalColor(Color finalColor) {
        this.finalColor = finalColor;
    }

    public void setTotalCalories(double totalCalories) {
        this.totalCalories = totalCalories;
    }

    public void setTotalVolume(double totalVolume) {
        this.totalVolume = totalVolume;
    }

    public void setTotalTaste(int totalTaste) {
        this.totalTaste = totalTaste;
    }

    public Color getFinalColor() {
        return finalColor;
    }

    public double getTotalCalories() {
        return totalCalories;
    }

    public double getTotalVolume() {
        return totalVolume;
    }

    public int getTotalTaste() {
        return totalTaste;
    }

    // Method to convert Color object to string
    public String colorToString(Color color) {
        return "[r=" + color.getRed() + ",g=" + color.getGreen() + ",b=" + color.getBlue() + "]";
    }

    // Method to return information about the cocktail
    public String getInfo() {
//        Informs the user of the expected taste of the cocktail
        String taste = " ";
        if (totalTaste > 0 && totalTaste <= 2) {
            taste = "A little sweet";
        } else if (totalTaste > 2 && totalTaste < 4) {
            taste = "Sweet";
        } else if (totalTaste >= 4) {
            taste = "Very sweet";
        } else if (totalTaste < 0 && totalTaste >= -2) {
            taste = "A little sour";
        } else if (totalTaste < -2 && totalTaste > -4) {
            taste = "Sour";
        } else if (totalTaste <= -4) {
            taste = "Very sour";
        } else if (totalTaste == 0) {
            taste = "There is no taste";
        }
        return "Final Color: " + colorToString(finalColor)
                + ", Total Calories: " + totalCalories
                + ", Total Volume: " + totalVolume
                + ", Total Taste: " + taste;
    }
}
