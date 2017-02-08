package capriotti.anthony.Hurtlocker;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by anthonycapriotti on 2/8/17.
 */
public class GroceryItemTest {
    GroceryItem groceryItem;


    @Test
    public void addPriceTest() {
        Map<String, Integer> priceAndOccurences = new HashMap<String, Integer>();
        groceryItem = new GroceryItem("Apple", priceAndOccurences);
        groceryItem.addPrice("1.00");
        int expected = 1;
        int actual = priceAndOccurences.get("1.00");
        assertEquals("1 occurence will return", expected, actual);
    }

    @Test
    //return true
    public void checkIfPriceExistsTestTrue() {
        Map<String, Integer> priceAndOccurences = new HashMap<String, Integer>();
        priceAndOccurences.put("1.00", 2);
        groceryItem = new GroceryItem("Apple", priceAndOccurences);
        boolean expected = true;
        boolean actual = groceryItem.checkIfPriceExists("1.00");
        assertEquals("Will return true/false", expected, actual);
    }

    @Test
    //return false
    public void checkIfPriceExistsTestFalse() {
        Map<String, Integer> priceAndOccurences = new HashMap<String, Integer>();
        priceAndOccurences.put("1.00", 2);
        groceryItem = new GroceryItem("Apple", priceAndOccurences);
        boolean expected = false;
        boolean actual = groceryItem.checkIfPriceExists("2.00");
        assertEquals("Will return true/false", expected, actual);
    }

    @Test
    public void incrementCountTest() {
        Map<String, Integer> priceAndOccurences = new HashMap<String, Integer>();
        priceAndOccurences.put("1.00", 2);
        groceryItem = new GroceryItem("Apple", priceAndOccurences);
        groceryItem.incrementCount("1.00");
        int expected = 3;
        int actual = priceAndOccurences.get("1.00");
        assertEquals("count will return", expected, actual);

    }

    @Test
    public void toStringTest() {
        Map<String, Integer> priceAndOccurences = new HashMap<String, Integer>();
        priceAndOccurences.put("1.00", 2);
        groceryItem = new GroceryItem("Apple", priceAndOccurences);
        String expected = "GroceryItem name = Apple', price And number of price occurences{1.00=2}";
        String actual = groceryItem.toString();
        assertEquals("Output format testing", expected, actual);
    }

}
