package tests;

import org.junit.Test;
import pages.HomePage;
import utilities.ConfigReader;
import utilities.CsvReader;
import utilities.Driver;
import utilities.Methods;

public class TestPage {
    //Logger logger = LogManager.getLogger();
    HomePage homePage = new HomePage();
    Methods methods = new Methods();
    CsvReader csvReader = new CsvReader();
    private static String OTEL_TAB_ATTRIBUTE = "jmbIRo";


    @Test
    public void setur() {

        Methods.getUrl();
        Methods.urlControl();
        Methods.allowCookie();
        Methods.hotelTabControl(OTEL_TAB_ATTRIBUTE);
        Methods.sendCsv();
        Methods.vacationDates();
        Methods.peopleCountControl();
        Methods.searchButtonControl();
        Methods.urlContainsCityName();

        int filterCount = Methods.randomRegionClick();
        Methods.endOfPageAndResultControl(filterCount);
        Driver.closeDriver();
        }
    }
