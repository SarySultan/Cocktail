package cocktaill;

public class BlenderOverflowException extends Exception {

    public String getMessage(Blender blender) {
        return "The remaining capacity of the blender is " + (blender.getBlenderCapacity() - blender.getCocktailVolume()) + " milliliters. You cannot add this component.";

    }

}
