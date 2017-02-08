package capriotti.anthony.Hurtlocker;

/**
 * Created by anthonycapriotti on 2/8/17.
 */
public class Price {
    String price;
    int occurences;


    Price(String price, int occurences){
        this.price = price;
        this.occurences = occurences;
    }

    public String getPrice() {
        return price;
    }

    public int getOccurences() {
        return occurences;
    }

    public void incrementOccurences(){
        this.occurences++;
    }

    @Override
    public String toString(){
        return "price = " + price +
                ", seen = " + occurences;
    }
}
