package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;

import java.util.List;

public class C05_DriverClassIleAramaTesti {

    @Test
    public void aramaTesti(){
        //1- testotomasyonu anasayfaya gidin
        Driver.getDriver().get("https://www.testotomasyonu.com");

        //2- phone icin arama yapin
        WebElement aramaKutusu = Driver.getDriver().findElement(By.id("global-search"));
        aramaKutusu.sendKeys("phone" + Keys.ENTER);

        //3- Arama sonucunda bulunan urun sayisinin 3’den cok oldugunu test edin
        List<WebElement> bulunanUrunElementleriList =
                Driver.getDriver().findElements(By.className("prod-img"));

        Assert.assertTrue(bulunanUrunElementleriList.size()>3);

        //4- ilk urunu tiklayin
        bulunanUrunElementleriList.get(0).click();


        //5- acilan urun sayfasinda,
        //   urun isminde case sensitive olmadan phone bulundugunu test edin.
        WebElement ilkUrunIsimElementi =
                Driver.getDriver().findElement(By.xpath("//div[@class=' heading-sm mb-4']"));

        String ilkUrunIsmi = ilkUrunIsimElementi.getText();

        Assert.assertTrue(ilkUrunIsmi.toLowerCase().contains("phone"));

        // 6- sayfayi kapatin
        Driver.quitDriver();

    }
}
