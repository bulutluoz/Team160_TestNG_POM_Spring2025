package tests;

import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ReusableMethods;

public class C04_quitDriver {

    @Test
    public void test01(){
        Driver.getDriver().get("https://www.youtube.com");

        ReusableMethods.bekle(2);


        Driver.quitDriver();

    }

    @Test
    public void test02(){
        Driver.getDriver().get("https://www.testotomasyonu.com");

        ReusableMethods.bekle(2);


        Driver.quitDriver();

    }
}
