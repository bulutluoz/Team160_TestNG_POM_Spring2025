package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.ReusableMethods;

import java.time.Duration;
import java.util.List;

public class C02_JunittenTestTransferi {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }

    @Test
    public void webTableTest(){

        //1."https://testotomasyonu.com/webtables" adresine gidin
        driver.get("https://testotomasyonu.com/webtables");

        //2. Web table tum body’sini yazdirin
        WebElement tumBodyElementi = driver.findElement(By.xpath("//tbody"));
        System.out.println("Tablodaki tum body : \n" + tumBodyElementi.getText());

        //3. Web tablosunda "Comfortable Gaming Chair" bulundugunu test edin

        String expectedTabloIcerik = "Comfortable Gaming Chair";
        String actualTumTabloYazilar = tumBodyElementi.getText();

        Assert.assertTrue( actualTumTabloYazilar.contains(expectedTabloIcerik),"tabloda aranan urun yok"  );

        //4. Web table’daki satir sayisinin 5 oldugunu test edin

        List<WebElement> satirlarListesi = driver.findElements(By.xpath("//tbody/tr"));
        int expectedSatirSayisi = 5;
        int actualSatirSayisi = satirlarListesi.size();

        Assert.assertEquals(expectedSatirSayisi,actualSatirSayisi);

        //5. Tum satirlari yazdirin
        System.out.println("=======================");

        for (WebElement each :satirlarListesi
        ) {
            System.out.println(each.getText());
        }

        // 3.satiri yazdirin
        System.out.println("tablodaki 3.satir : " + satirlarListesi.get(2).getText());

        // tum satirlari reusableMethods kullanarak yazdirin
        System.out.println("==========Tum Satirlar=============");
        System.out.println(ReusableMethods.stringListeDonustur(satirlarListesi));


        //6. Web table’daki sutun sayisinin 4 olduğunu test edin
        //   Web Tablolari Table / Row (satir) / Data (herbir bilgi)
        //   seklinde kullanilir.
        //   Tablo'da sutun yapisi yoktur
        //   sutun yapisini xpath ile olustururuz

        // sutun sayisini bulabilmek icin herhangi bir satirdaki data sayisina bakabiliriz
        List<WebElement> dorduncuSatirElementleriList =
                driver.findElements(By.xpath("//tbody/tr[4]/td"));

        int expectedSutunSayisi = 4;
        int actualSutunSayisi = dorduncuSatirElementleriList.size();

        Assert.assertEquals(expectedSutunSayisi,actualSutunSayisi);


        //7. 3.sutunu yazdirin

        List<WebElement> ucuncuSutunElementleriList =
                driver.findElements(By.xpath("//tbody/tr/td[1]"));

        System.out.println(ReusableMethods.stringListeDonustur(ucuncuSutunElementleriList));


        //8. Tablodaki basliklari yazdirin

        List<WebElement> baslikElementleriList =
                driver.findElements(By.xpath("//thead/tr/th"));

        System.out.println(ReusableMethods.stringListeDonustur(baslikElementleriList));



        //9. Satir ve sutunu parametre olarak alip,
        //   hucredeki bilgiyi döndüren bir method olusturun

        System.out.println(getDataFromCell(2, 2)); // Electronics
        System.out.println(getDataFromCell(3, 1)); // Medium 25 L Laptop Backpack
        System.out.println(getDataFromCell(4, 3)); // $39.00

        //10. 4.satirdaki category degerinin "Furniture" oldugunu test edin

        String expectedCategory = "Furniture";
        String actualCategory = getDataFromCell(4,2);

        Assert.assertEquals(expectedCategory,actualCategory);


    }


    public String getDataFromCell(int satirNo, int sutunNo){

        //  genel xpath :   //tbody/tr[  4  ]/td[    4   ]
        String dinamikXPath = "//tbody/tr["+ satirNo + "]/td[" + sutunNo + "]";

        WebElement istenenHucreElementi = driver.findElement(By.xpath(dinamikXPath));

        return istenenHucreElementi.getText();
    }
}
