package utilities;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import pages.HomePage;
import tests.TestPage;

import java.util.Random;

public class Methods {
    final static Logger logger = Logger.getLogger(Methods.class);
  static   HomePage homePage = new HomePage();
   static Random random=new Random();

    public static void bekle(int saniye) {

        try {
            Thread.sleep(saniye * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public static void getUrl(){
        logger.info("Test başlatıldı.");
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        logger.info("Setur Url e gidildi.");

    }
    public static void urlControl() {
        String actualtUrl = Driver.getDriver().getCurrentUrl();
        String expectedUrl = ConfigReader.getProperty("url");
        Assert.assertEquals(actualtUrl, expectedUrl);
        logger.info("setur url’nin geldiği kontrol edildi.");
    }
    public static void allowCookie() {

        clickElement(homePage.popupElement);
        Methods.bekle(1);
        clickElement(homePage.allowCookie);
        logger.info("popup kapatıldı ve cookie'ler kabul edildi.");
    }

    public static void hotelTabControl(String OTEL_TAB_ATTRIBUTE) {

        String otelTabElements = homePage.otelTab.getAttribute("class");
        if (otelTabElements.contains(OTEL_TAB_ATTRIBUTE)) {
            logger.info("Default olarak Otel Tabı seçili geldiği kontrol edildi.");
        }
    }
    public static void sendCsv() {
        String cityName = CsvReader.getCityName();
        homePage.searchCity.sendKeys(cityName);
        clickElement(homePage.searchCity);
        Methods.bekle(1);
        clickElement(homePage.antalya);
        logger.info("Nereye gideceksiniz kısmına Csv dosyasından okutularak Antalya yazıldı");

    }
    public static void vacationDates() {
        clickElement(homePage.dateInput);
        clickElement(homePage.startDate);
        clickElement(homePage.endDate);
        logger.info("Tarih nisanın ilk haftası seçildi");

    }
    public static void peopleCountControl() {
        clickElement( homePage.kisiElementi);
        String kisiSayisiOnce = homePage.kisiSayisi.getText();
        clickElement(homePage.kisiSayisiArtir);
        String kisiSayisiSonra = homePage.kisiSayisi.getText();

        Assert.assertNotEquals(kisiSayisiOnce, kisiSayisiSonra);
        logger.info("Kişi sayısı 1 arttırıldı ve arttırıldığı doğrulandı");
    }
    public static void searchButtonControl() {
        Assert.assertTrue(homePage.araBtn.isDisplayed());
        clickElement(homePage.araBtn);
        Methods.bekle(2);
        logger.info("Ara butonunun görünülürlüğü kontrol edilip tıklandı");
    }
    public static void urlContainsCityName() {
        String antalyaUrl = "antalya";
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains(antalyaUrl));
        Methods.bekle(2);
        logger.info("Url'in "+antalyaUrl+" kelimesini içerdiği kontrol edildi");
    }
  public static int randomRegionClick(){
        Methods.bekle(2);

        int random1= random.nextInt(homePage.otherCountries.size());
        WebElement clickElementi=homePage.otherCountries.get(random1);

        clickElement(clickElementi);
        bekle(2);
        WebElement header =Driver.driver.findElement(By.xpath("//*[@class='sc-2569635-1 byIIER']"));
        String headerStr=header.getText().replaceAll("\\D","");
        Methods.bekle(3);
        //String otherCountryOtelsStr =clickElement.findElement(By.tagName("span")).getText().replaceAll("\\D", "");
        int otherCountryOtelsInt =Integer.parseInt(headerStr);
        logger.info("rastgele tıklama metotu kullanılarak bir bölge seçimi yapıldı");
        return otherCountryOtelsInt;

    }
    public static void endOfPageAndResultControl(int filterCount) {
    Methods.bekle(2);
    JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
    if (filterCount > 20) {
        WebElement footer = Driver.getDriver().findElement(By.xpath("//div[@class='sc-21021e1e-1 gPQAyQ']"));
        js.executeScript("arguments[0].scrollIntoView(true);",footer);
        int resultInt=Integer.parseInt(homePage.resultSayi.getText());
        Assert.assertEquals(resultInt,filterCount);
    }
        logger.info("Gösterilen sonuç 20 den fazla ise sayfanın sonuna gidilip assertion yapıldı");
}


    public static void clickElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor)Driver.getDriver();

        js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
        element.click();
    }


}