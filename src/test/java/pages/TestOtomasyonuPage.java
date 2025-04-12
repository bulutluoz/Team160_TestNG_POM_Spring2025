package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

import java.util.List;

public class TestOtomasyonuPage {

    @FindBy(id = "global-search")
    public WebElement aramaKutusu;

    @FindBy(className = "prod-img")
    public List<WebElement> bulunanUrunElementleriList;

    @FindBy(xpath = "//div[@class=' heading-sm mb-4']")
    public WebElement ilkUrunSayfasindakiUrunIsimElementi;




}
