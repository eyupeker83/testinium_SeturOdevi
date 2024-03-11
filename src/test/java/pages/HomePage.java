package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;


public class HomePage {

    public HomePage(){PageFactory.initElements(Driver.getDriver(),this);}

    @FindBy(xpath = "//*[@class='ins-close-button']")
    public WebElement popupElement;
    @FindBy(xpath ="//*[text()='Tümüne izin ver']")
    public WebElement allowCookie;
    @FindBy (xpath = "//button[@class='sc-25740042-1 jmbIRo']")
    public WebElement otelTab;
    @FindBy(xpath = "//*[@inputmode='search']")
    public WebElement searchCity;
    @FindBy(xpath = "(//strong[text()='Antalya'])[1]")
    public WebElement antalya;
    @FindBy(xpath = "//div[@class='sc-bf3a6118-0 VntNS']")
    public  WebElement dateInput;
    @FindBy(xpath = "(//div[@class='CalendarMonth CalendarMonth_1'])[3]//table//td//span[text()='1']")
    public WebElement startDate;
    @FindBy(xpath = "(//div[@class='CalendarMonth CalendarMonth_1'])[3]//table//td//span[text()='7']")
    public WebElement endDate;
    @FindBy(xpath = "//*[@class='sc-b2c3f6ee-21 bSPwxV']")
    public WebElement kisiElementi;
    @FindBy(xpath = "//*[@class='sc-423a98f0-2 kxWULs']")
    public WebElement kisiSayisi;
    @FindBy(xpath = "(//*[@data-testid='increment-button'])[1]")
    public WebElement kisiSayisiArtir;
    @FindBy(xpath = "//*[@class='sc-8de9de7b-0 dYTYAP']")
    public WebElement araBtn;


    @FindBy (xpath = "(//*[@class='sc-21021e1e-3 eqVmWj'])[1]")
    public WebElement resultSayi;


    @FindBy(xpath = "//*[@class='sc-2569635-2 PSzMH']//*[@data-testid='checkbox']")
    public List<WebElement>  otherCountries;

    }


