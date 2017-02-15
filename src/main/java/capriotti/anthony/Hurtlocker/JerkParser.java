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

    Map<String, GroceryItem> groceryList = new HashMap<>();

    public String[] splitListing(String input){
        String[] itemsArray = input.split("##");
        return itemsArray;
    }

    public String[] parseKeyValuePairs(String item){
        String[] pairs = item.split("[^a-zA-Z0-9:./]");
        return pairs;
    }

    public void parseInput(String input){
        String[] itemsArray = splitListing(input);
        for (int i = 0; i < itemsArray.length-1; i++){
            String[] items = parseKeyValuePairs(itemsArray[i]);
            addInputToMap(items[0], items[1]);
        }
    }

    public void addInputToMap(String item, String itemPrice){
        Map<String, Integer> priceAndOccurences = new HashMap<>();
        String name;
        String price = null;

        try {
            name = checkForNullValue(item);
            price = checkForNullValue(itemPrice);
        } catch (ErrorHandler e){
            name = null;
        }

        if (name != null && price != null){
            name = spellCheck(name);
            if (!checkForExisitingGroceryItem(name)){
                priceAndOccurences.put(price , 0);
                GroceryItem groceryItem = new GroceryItem(name, priceAndOccurences);
                groceryList.put(name, groceryItem);
            }
        }
        addPriceToGroceryItem(name,price);
    }

    public void printMap(){
        for (HashMap.Entry<String, GroceryItem> entry : groceryList.entrySet()){
            System.out.println(entry.getValue().output());
        }
    }

    public void printError(){
        System.out.println(ErrorHandler.outputFormat());
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

    public String checkForNullValue(String value) throws ErrorHandler{
        Pattern pattern = Pattern.compile("[^:]*$");
        Matcher matcher = pattern.matcher(value);
        matcher.find();

        Matcher noMatcher = Pattern.compile("^$").matcher(matcher.group());
        if (noMatcher.find()){
            throw new ErrorHandler("Not Found");
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
