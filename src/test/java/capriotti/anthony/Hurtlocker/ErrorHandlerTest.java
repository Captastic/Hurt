package capriotti.anthony.Hurtlocker;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by anthonycapriotti on 2/8/17.
 */
public class ErrorHandlerTest {
    ErrorHandler errorHandler;

    @Test
    public void checkForNullValuetest() {
        JerkParser jerkParser = new JerkParser();
        String actual = null;
        try {
            actual = jerkParser.checkForNullValue("naMe:");
        } catch (ValueNotFoundException e) {
            Assert.assertTrue(e.getMessage().equals("Value not found"));
        }
    }


}
