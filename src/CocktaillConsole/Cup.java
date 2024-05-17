package CocktaillConsole;

import java.awt.Color;

public class Cup {

    private double cupSize;
    private double caloriesInOneCup;
    private double volume = cupSize;
    private FileLogger logger;
    

    // Constructor to initialize Cup object with cupSize and caloriesInOneCup
    public Cup(double cupSize, double caloriesInOneCup, FileLogger logger) {
        this.cupSize = cupSize;
        this.caloriesInOneCup = caloriesInOneCup;
        this.volume = cupSize;
        this.logger = logger; 
    }
    
    public double getCupSize() {
        return cupSize;
    }

    public double getCaloriesInOneCup() {
        return caloriesInOneCup;
    }

    public double getVolume() {
        return volume;
    }

    public void setCupSize(double cupSize) {
        this.cupSize = cupSize;
    }

    public void setCaloriesInOneCup(double caloriesInOneCup) {
        this.caloriesInOneCup = caloriesInOneCup;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }
    

    // Method to pour a cocktail into the cup and calculate its calories
    public String pourCocktail(Cocktail cocktail, Blender blender) throws BlenderIsEmptyException {

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
                logger.log("Poured into cup: " + getInfo());
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
                logger.log("Poured into cup: " + getInfo());
                return getInfo();
            }

        } else {
            throw new BlenderIsEmptyException();
        }

    }

    // Method to return information about the cup
    public String getInfo() {
        return "The number of calories poured into this cup is: " + caloriesInOneCup + "\nThis quantity roughly equals " + this.volume + " milliliters of the cocktail";
    }

}
