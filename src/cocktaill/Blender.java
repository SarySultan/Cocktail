package cocktaill;

import java.awt.Color;
import java.util.ArrayList;

// Represents a blender for mixing ingredients to create cocktails
public class Blender {

    private double blenderCapacity;
    public ArrayList<Ingredient> ingredients;
    double editVolume, editCalories;
    int editTaste;

    public double getEditVolume() {
        return editVolume;
    }

    // Constructor to initialize Blender object with blenderCapacity and an empty list of ingredients
    public Blender(double blenderCapacity) {
        this.blenderCapacity = blenderCapacity;
        this.ingredients = new ArrayList<>();
    }

    public void setEditVolume(double editVolume) {
        if (editVolume == 0) {
            this.editVolume = 0;
        } else {
            this.editVolume += editVolume;
        }
    }

    public double getEditCalories() {
        return editCalories;
    }

    public void setEditCalories(double editCalories) {
        if (editCalories == 0) {
            this.editCalories = 0;
        } else {
            this.editCalories += editCalories;
        }
    }

    public int getEditTaste() {
        return editTaste;
    }

    public void setEditTaste(int editTaste) {
        this.editTaste = editTaste;
    }

    public double getBlenderCapacity() {
        return blenderCapacity;
    }

    public void setBlenderCapacity(double blenderCapacity) {
        this.blenderCapacity = blenderCapacity;
    }

//Restore the ratios to their defaults
    public void cleanBlender(Cocktail cocktail, Blender blender) {

        ingredients.removeAll(ingredients);
        cocktail.setFinalColor(new Color(0, 0, 0));//We have considered the default color to be (0,0,0)
        cocktail.setTotalCalories(0);
        cocktail.setTotalVolume(0);
        cocktail.setTotalTaste(0);
        setEditCalories(0);
        setEditVolume(0);

    }

    // Method to add an ingredient to the blender
    public void addIngredient(Ingredient ingredient) throws BlenderOverflowException {
        if (getCocktailVolume() + ingredient.getVolume() <= getBlenderCapacity()) {
            ingredients.add(ingredient);
        } else {
            throw new BlenderOverflowException();
        }
    }

    // Method to mix ingredients and create a cocktail
    public Cocktail mix() throws blenderIsEmptyException {
        int numLiquid = 0, numFruit = 0;

        for (Ingredient ingredient : ingredients) {
            if (ingredient instanceof Fruit) {
                numFruit++;
            } else if (ingredient instanceof Liquid) {
                numLiquid++;
            }

        }

        if (getCocktailVolume() != 0 && (numFruit != 0 || numLiquid != 0)) {//The condition must not be empty. The second condition is that there be fruit or liquid
            Color finalColor = getTotalColor();
            double totalCalories = getTotalCalories();
            int totalTaste = getTotalTaste();
            double totalvolume = getCocktailVolume();
            return new Cocktail(finalColor, totalCalories, totalvolume, totalTaste);
        } else {
            throw new blenderIsEmptyException();
        }

    }

    // Method to calculate the average (final) color of ingredients
    public Color getTotalColor() {
        int red = 0, green = 0, blue = 0;
        int numIngredients = ingredients.size();
        int numSugar = 0;
        for (Ingredient ingredient : ingredients) {
            if (ingredient instanceof Sugar) {
                numSugar++;
            }

        }
        numIngredients -= numSugar;
        for (Ingredient ingredient : ingredients) {
            if (ingredient instanceof Fruit) {
                Color colorOfFruit = ((Fruit) ingredient).getColor();
                red += colorOfFruit.getRed();
                green += colorOfFruit.getGreen();
                blue += colorOfFruit.getBlue();
            } else if (ingredient instanceof Liquid) {
                Color colorOfLiquid = ((Liquid) ingredient).getColor();
                red += colorOfLiquid.getRed();
                green += colorOfLiquid.getGreen();
                blue += colorOfLiquid.getBlue();
            }
        }
        //We have divided by the number of ingredients here because the sizes of
        //the defined ingredients are almost similar,
        //so there is no need to compare the ingredients size
        red /= numIngredients;
        green /= numIngredients;
        blue /= numIngredients;
        return new Color(red, green, blue);
    }

    // Method to calculate the total calories of ingredients
    public double getTotalCalories() {
        int totalCalories = 0;
        for (Ingredient ingredient : ingredients) {
            totalCalories += ingredient.getCalorie();
        }

        return totalCalories - getEditCalories();//Discount who poured into the cup
    }

    // Method to calculate the average (final) taste of ingredients
    public int getTotalTaste() {
        int totalTast = 0;
        for (Ingredient ingredient : ingredients) {
            totalTast += ingredient.getSweetness();

        }
        if (getEditTaste() >= 0) {
            return (((totalTast / 5) - getEditTaste()) / 2);//The percentage is estimated
        } else {
            return (((totalTast / 5) + getEditTaste()) / 2);
        }

    }

    // Method to calculate the total volume of ingredients
    public double getCocktailVolume() {
        double totalvolume = 0;
        for (Ingredient ingredient : ingredients) {
            totalvolume += ingredient.getVolume();
        }

        return totalvolume - getEditVolume();
    }

    // Method to return information about the blender and its ingredients
    public String getInfo() {
        String info = "Blender Capacity: " + blenderCapacity
                + ", Ingredients: [";
        for (Ingredient ingredient : ingredients) {
            info += ingredient.getInfo() + ", ";
        }
        info += "]";
        return info;
    }
}
