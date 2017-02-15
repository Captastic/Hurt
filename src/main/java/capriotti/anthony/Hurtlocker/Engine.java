package capriotti.anthony.Hurtlocker;
import org.apache.commons.io.IOUtils;
import java.io.IOException;



/**
 * Created by anthonycapriotti on 2/9/17.
 */
public class Engine {



    public String readRawDataToString() throws Exception{
        ClassLoader classLoader = getClass().getClassLoader();
        String result = IOUtils.toString(classLoader.getResourceAsStream("RawData.txt"));
        return result;
    }

    public static void main(String[] args) throws Exception{
        String output = (new Main()).readRawDataToString();
        JerkParser jerkParser = new JerkParser();

        jerkParser.parseInput(output);
        jerkParser.printMap();
        jerkParser.printError();
    }

}
