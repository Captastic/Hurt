package capriotti.anthony.Hurtlocker;

import java.util.Map;

/**
 * Created by anthonycapriotti on 2/8/17.
 */
public class GroceryItem {
    public String name;
    public int count;
    public Map<String, Integer> priceAndOccurences;


    public GroceryItem(String name, Map<String, Integer> priceAndOccurences){
        this.name = name;
        this.priceAndOccurences = priceAndOccurences;
    }

    public void addPrice(String price){
        priceAndOccurences.put(price, 1);
        count++;

    }

    public boolean checkIfPriceExists(String price){
        if (priceAndOccurences.containsKey(price)){
            return true;
        } else {
            return false;
        }
    }

    public void incrementCount(String price){
        priceAndOccurences.put(price, (priceAndOccurences.get(price)) + 1);
        count++;
    }

    @Override
    public String toString(){
        return "GroceryItem " +
                "name= " + name + '\'' +
                "' count=" + count +
                ", price And number of price occurences" + priceAndOccurences;
    }

    public String output(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("name:\t" + name)
                .append("\t\tseen: " + count + " times\n")
                .append("=============\t\t=============\n");
        for (Map.Entry<String, Integer> list : priceAndOccurences.entrySet()){
            stringBuilder.append("Price:\t" + list.getKey())
                    .append("\t\tseen: " + list.getValue() + " times\n")
                    .append("-------------\t\t-------------\n");
        }
        return stringBuilder.toString();
    }
}
