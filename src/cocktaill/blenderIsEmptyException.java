package cocktaill;

public class blenderIsEmptyException extends Exception {

    @Override
    public String getMessage() {
        return "The blender is empty, please add ingredients.";

    }

}
