package utilities;

import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ReusableMethods {

    // verilen List<WebElement> listesindeki tum web elementleri tek tek ele alip
    // uzerlerindeki yazilari bir List<String> 'e kaydedip
    // yazilardan olusan bu listeyi donduren bir method olusturun

    public static List<String> stringListeDonustur(List<WebElement>  webElementList){

            List<String> stringList=new ArrayList<>();

            for(WebElement eachElement: webElementList){

                stringList.add( eachElement.getText());

            }

            return stringList;
    }

    public static void bekle(int saniye){

        try {
            Thread.sleep(saniye*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
