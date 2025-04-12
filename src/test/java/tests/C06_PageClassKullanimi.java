package tests;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestOtomasyonuPage;
import utilities.Driver;

public class C06_PageClassKullanimi {

    @Test
    public void aramaTesti(){
        //1- testotomasyonu anasayfaya gidin
        Driver.getDriver().get("https://www.testotomasyonu.com");
        //2- phone icin arama yapin
        TestOtomasyonuPage testOtomasyonuPage = new TestOtomasyonuPage();
        testOtomasyonuPage.aramaKutusu.sendKeys("phone" + Keys.ENTER);

        //3- Arama sonucunda bulunan urun sayisinin 3’den cok oldugunu test edin

        int actualAramaSonucSayisi = testOtomasyonuPage.bulunanUrunElementleriList.size();

        Assert.assertTrue(actualAramaSonucSayisi > 3);

        //4- ilk urunu tiklayin
        testOtomasyonuPage.bulunanUrunElementleriList.get(0).click();

        //5- acilan urun sayfasinda,
        //   urun isminde case sensitive olmadan phone bulundugunu test edin.

        String expectedIsimIcerigi = "phone";
        String actualUrunIsmi = testOtomasyonuPage
                                        .ilkUrunSayfasindakiUrunIsimElementi
                                        .getText()
                                        .toLowerCase();

        Assert.assertTrue(actualUrunIsmi.contains(expectedIsimIcerigi));

        //6- sayfayi kapatin
        Driver.quitDriver();
    }
}
