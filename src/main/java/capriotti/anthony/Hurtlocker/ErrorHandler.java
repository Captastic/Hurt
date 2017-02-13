package capriotti.anthony.Hurtlocker;

/**
 * Created by anthonycapriotti on 2/8/17.
 */
public class ErrorHandler extends Exception {
    int errorCounter;

    public void itemNotFoundException(String exception){
        errorCounter++;
    }

    public String outputFormat(){
        return "Errors\t\t\t\tseen: "+errorCounter+" times";
    }
}
