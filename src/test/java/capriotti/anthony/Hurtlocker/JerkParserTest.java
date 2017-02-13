package capriotti.anthony.Hurtlocker;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by anthonycapriotti on 2/8/17.
 */
public class JerkParserTest {
    JerkParser jerkParser;

    @Before
    public void setUp() {
        jerkParser = new JerkParser();
        String input = "naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##naME:BreaD;price:1.23;type:Food;expiration:1/02/2016##";
    }

    @Test
    public void splitItemsTest() {
        jerkParser = new JerkParser();
        String expectedInput = "naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##";
        String[] actualOutput = jerkParser.splitListing(expectedInput);
        Assert.assertTrue(actualOutput.length == 2);
    }

    @Test
    public void parseAsKeyValuePairs() {
        jerkParser = new JerkParser();
        String expectedInput = "naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##";
        String[] items = jerkParser.splitListing(expectedInput);
        String[] valuePairs = jerkParser.parseKeyValuePairs(items[0]);
        Assert.assertTrue(valuePairs[0].equals("naMe:Milk"));
    }

    @Test
    public void checkForNullValuesTest() {
        jerkParser = new JerkParser();
        String actual = null;
        try {
            actual = jerkParser.checkForNullValue("naMe:Milk");
        } catch (ValueNotFoundException e) {
        }
        Assert.assertEquals("Milk will return", "Milk", actual);
    }

    @Test
    //null values test with non-null value inputted
    public void checkForNullValuesNullTest() {
        jerkParser = new JerkParser();
        String actual = null;
        try {
            actual = jerkParser.checkForNullValue("naMe:");
        } catch (ValueNotFoundException e) {
        }
        Assert.assertEquals("Milk will return", null, actual);
    }

    @Test
    public void spellCheckTest(){
        jerkParser = new JerkParser();
        String expected = "Milk";
        String actual = jerkParser.checkSpelling("MiLK");
        Assert.assertEquals("Output will be Milk", expected,actual);
    }

    @Test
    public void checkIfItemsExistsInMap(){
        jerkParser = new JerkParser();
        Map<String, Integer> priceAndPriceOccurences = new HashMap<String, Integer>();
        priceAndPriceOccurences.put("1.00", 2);
        jerkParser.groceryList.put("Milk", new GroceryItem("Milk", priceAndPriceOccurences));
        boolean expected = true;
        boolean actual = jerkParser.checkForExisitingGroceryItem("Milk");
        assertEquals("milk exists / true returns", expected, actual);
    }

    @Test
    public void convertToLowerCase(){
        jerkParser = new JerkParser();
        String expected = "milk";
        String actual = jerkParser.convertToLowerCase("Milk");
        assertEquals("milk lowercase will return", expected, actual);
    }




}
