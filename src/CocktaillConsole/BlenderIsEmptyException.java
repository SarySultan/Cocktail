package CocktaillConsole;

public class BlenderIsEmptyException extends Exception {

    @Override
    public String getMessage() {
        return "The blender is empty, please add ingredients.";

    }
    

}
