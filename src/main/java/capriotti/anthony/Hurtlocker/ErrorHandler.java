package capriotti.anthony.Hurtlocker;

/**
 * Created by anthonycapriotti on 2/8/17.
 */
public class ErrorHandler {
    int errorCounter;

    public void itemNotFoundException(String exception){
        errorCounter = 0;
        errorCounter++;
    }

    public String outputFormat(){
        return null;
    }
}
