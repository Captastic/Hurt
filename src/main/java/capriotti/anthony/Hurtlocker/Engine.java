package capriotti.anthony.Hurtlocker;

import javafx.scene.shape.Path;
import sun.applet.Main;
import sun.misc.IOUtils;


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
        System.out.println(output);
    }

}
