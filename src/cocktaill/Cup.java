package cocktaill;

import java.awt.Color;

public class Cup {

    private double cupSize;
    private double caloriesInOneCup;
    private double volume = cupSize;

    // Constructor to initialize Cup object with cupSize and caloriesInOneCup
    public Cup(double cupSize, double caloriesInOneCup) {
        this.cupSize = cupSize;
        this.caloriesInOneCup = caloriesInOneCup;
        this.volume = cupSize;
    }

    // Method to pour a cocktail into the cup and calculate its calories
    public String pourCocktail(Cocktail cocktail, Blender blender) throws blenderIsEmptyException {

        if (cocktail.getTotalVolume() != 0) {

            if (cocktail.getTotalVolume() <= cupSize)//Last cup and clean the blender
            {
                caloriesInOneCup = cocktail.getTotalCalories();
                volume = cocktail.getTotalVolume();
                cocktail.setFinalColor(new Color(0, 0, 0));
                cocktail.setTotalCalories(0);
                cocktail.setTotalVolume(0);
                cocktail.setTotalTaste(0);
                blender.cleanBlender(cocktail, blender);
                return getInfo();
            } else {

                caloriesInOneCup = ((cocktail.getTotalCalories() / cocktail.getTotalVolume()) * cupSize);
                //Modify the blender information after pouring the cup
                blender.setEditCalories(caloriesInOneCup);
                blender.setEditVolume(cupSize);
                blender.setEditTaste(blender.getTotalTaste());
                //Modify the cocktail information in the blender after pouring the cup
                cocktail.setTotalCalories(cocktail.getTotalCalories() - caloriesInOneCup);
                cocktail.setTotalVolume(cocktail.getTotalVolume() - cupSize);
                return getInfo();
            }

        } else {
            throw new blenderIsEmptyException();
        }

    }

    // Method to return information about the cup
    public String getInfo() {
        return "The number of calories poured into this cup is: " + caloriesInOneCup + " ,This quantity roughly equals " + this.volume + " milliliters of the cocktail";
    }

}
