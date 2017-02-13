package capriotti.anthony.Hurtlocker;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by anthonycapriotti on 2/8/17.
 */
public class JerkParser {
    GroceryItem groceryItem;

    Map<String, GroceryItem> groceryList = new HashMap<String, GroceryItem>();

    public void parseInput(String input){
        String[] items = splitListing(input);
        for (int i = 0; i < items.length; i++){
            String [] itemArray = parseKeyValuePairs(items[i]);
            addInputToMap(itemArray[0], itemArray[1]);
        }
    }

    public String[] splitListing(String input){
        String[] items = input.split("##");
        return items;
    }

    public void addInputToMap(String item, String itemprice){
        Map<String, Integer> priceAndOccurences = new HashMap<String, Integer>();
        String name;
        String price = null;
        try {
            name = checkForNullValue(item);
            price = checkForNullValue(price);
        } catch (ValueNotFoundExcpetion e){
            item = null;
        }

        if (name != null && price != null){
            name = spellCheck(item);
            if (!checkForExisitingGroceryItem(name)){
                priceAndOccurences.put(price , 0);
                GroceryItem groceryItem = new GroceryItem(name, priceAndOccurences);
                groceryList.put(name, groceryItem);
            }
        }
        addPriceToGroceryItem(name,price);
    }

    public String[] parseKeyValuePairs(String item){
        String[] pairs = item.split("[^a-zA-Z0-9:./]");
        return pairs;
    }

    public void printMap(){
        for (HashMap.Entry<String, GroceryItem> entry : groceryList.entrySet()){
            System.out.println(entry.getValue().formattedOutput());
        }
    }

    public void printError(){
        System.out.println(ValueNotFoundException.formattedErrorOutput());
    }

    public String spellCheck(String item){
        if (item != null){
            item = checkSpelling(item);
        }
        if (item != null){
            item = convertToLowerCase(item);
        }
        return item;
    }

    public void addPriceToGroceryItem(String itemName, String price){
        if (itemName != null && price != null){
            if(groceryList.get(itemName).checkIfPriceExists(price))
                groceryList.get(itemName).incrementCount(price);
            else
                groceryList.get(itemName).addPrice(price);
        }
    }

    public String checkForNullValue(String value){
        Pattern pattern = Pattern.compile("[^:]*$");
        Matcher matcher = pattern.matcher(value);
        matcher.find();

        Matcher noMatcher = Pattern.compile("^$").matcher(matcher.group());
        if (noMatcher.find()){
            throw new ValueNotFoundException("Not Found");
        }
        return matcher.group();
    }

    public boolean checkForExisitingGroceryItem(String item){
        return groceryList.containsKey(item);
    }

    public String convertToLowerCase(String item){
        String lowerCase = item.toLowerCase();
        return lowerCase;
    }

    public String checkSpelling(String item){
        Matcher matcher = Pattern.compile("0", Pattern.CASE_INSENSITIVE).matcher(item);
        matcher.find();
        return matcher.replaceAll("o");
    }


}
