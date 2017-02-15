package capriotti.anthony.Hurtlocker;

/**
 * Created by anthonycapriotti on 2/8/17.
 */
public class ErrorHandler extends Exception {
    static int errorCounter = 0;

    public ErrorHandler(String exception){
        super(exception);
        errorCounter++;
    }

    public static String outputFormat(){
        return "Errors\t\t\t\tseen: "+errorCounter+" times";
    }
}
