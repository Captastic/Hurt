package capriotti.anthony.Hurtlocker;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert.*;
import org.junit.Assert;

import static org.junit.Assert.assertEquals;

/**
 * Created by anthonycapriotti on 2/8/17.
 */
public class PriceTest {
    Price price;

    @Before
    public void setUp(){
        price = new Price("9.99", 1);
    }

    @Test
    //testing price occurences increase
    public void incrementOccurencesTest(){
        int expected = 2;
        price.incrementOccurences();
        int actual = price.getOccurences();
        assertEquals("count increases by one", expected, actual);
    }

    @Test
    //output format testing
    public void toStringTest(){
        String expected = "price = 9.99, seen = 1";
        String actual = price.toString();
        assertEquals("null", expected, actual);
    }




}
