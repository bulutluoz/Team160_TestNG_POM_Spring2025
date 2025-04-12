package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import utilities.Driver;

import java.util.List;

public class TestOtomasyonuPage {
    /*
        Bir page class'i olusturuldugunda
        arama islemini yapacak WebDriver objesinin
        bu class'a tanimlanmasi gerekir

        Kullandigimiz Test class'indan
        page class'indaki locate'lere ulasmak icin
        bir obje olusturuyoruz

        obje olusturmak icin Page class'indaki constructor calisir
        eger page class'indaki constructor'in icine
        driver tanimlamayi eklersek
        her page class'i kullaniminda
        driver otomatik olarak tanimlanmis olur
     */

    public TestOtomasyonuPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }



    @FindBy(id = "global-search")
    public WebElement aramaKutusu;

    @FindBy(className = "prod-img")
    public List<WebElement> bulunanUrunElementleriList;

    @FindBy(xpath = "//div[@class=' heading-sm mb-4']")
    public WebElement ilkUrunSayfasindakiUrunIsimElementi;




}
