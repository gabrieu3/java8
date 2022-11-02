import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class SortStringsTest {

    @Test
    public void sortArrayOfStrings(){
        Boolean equal = false;
        List<String> wordsActual = new ArrayList<>();
        List<String> wordsExpected = new ArrayList<>();

        wordsExpected.add("Bike");
        wordsExpected.add("Bus");
        wordsExpected.add("Car");
        wordsExpected.add("Truck");

        wordsActual.add("Truck");
        wordsActual.add("Bus");
        wordsActual.add("Car");
        wordsActual.add("Bike");

        Collections.sort(wordsActual);

        if(wordsActual.equals(wordsExpected)){
            equal = true;
        }
        Assert.assertTrue(wordsActual.toString() + " is diferent from "+ wordsExpected.toString(), equal);
    }
}
