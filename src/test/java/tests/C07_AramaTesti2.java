package tests;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestOtomasyonuPage;
import utilities.Driver;
import utilities.ReusableMethods;

public class C07_AramaTesti2 {

    @Test
    public void test01(){

        //1- testotomasyonu anasayfaya gidin
        Driver.getDriver().get("https://www.testotomasyonu.com");

        //2- dress icin arama yapin
        TestOtomasyonuPage testOtomasyonuPage = new TestOtomasyonuPage();
        testOtomasyonuPage.aramaKutusu.sendKeys("dress" + Keys.ENTER);

        //3- Arama sonucunda bulunan urun sayisinin 5’den cok oldugunu test edin

        int aramaSonucSayisi = testOtomasyonuPage.bulunanUrunElementleriList.size();
        Assert.assertTrue(aramaSonucSayisi > 5);

        //4- ucuncu urunu tiklayin
        ReusableMethods.bekle(1);
        testOtomasyonuPage.bulunanUrunElementleriList.get(2).click();

        //5- acilan urun sayfasinda,
        //   urun isminde case sensitive olmadan dress bulundugunu test edin.

        String urunIsmi = testOtomasyonuPage
                                    .ilkUrunSayfasindakiUrunIsimElementi
                                    .getText()
                                    .toLowerCase();

        Assert.assertTrue(urunIsmi.contains("dress"));

        Driver.quitDriver();

    }
}
