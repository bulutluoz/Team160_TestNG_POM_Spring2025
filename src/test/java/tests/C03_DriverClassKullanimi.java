package tests;

import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ReusableMethods;

public class C03_DriverClassKullanimi {

    @Test
    public void test01(){


        // "driver"  yerine artik Driver class'indaki getDriver() kullanacagiz

        Driver.getDriver().get("https://www.testotomasyonu.com");

        ReusableMethods.bekle(2);

        Driver.getDriver().get("https://www.wisequarter.com");

        ReusableMethods.bekle(2);

        Driver.getDriver().get("https://www.youtube.com");

        ReusableMethods.bekle(2);


        Driver.quitDriver();

    }
}
