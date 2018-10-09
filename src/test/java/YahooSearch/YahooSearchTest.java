package YahooSearch;
import day2.Class1;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class YahooSearchTest {
    private WebDriver driver;

    @BeforeTest
    public void setupDriver() throws Exception {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\Bohdan\\IdeaProjects\\WebdriverJavaBootcamp\\src\\test\\resources\\geckodriver");
        driver = new FirefoxDriver();
    }

    @Test
    public void testSearch() throws Exception {
        navigateToMainPage("http://yahoo.com");
        typeRequestInSearchInput("portnov");
        submitResult();
        seeResult();
    }

    private void seeResult() {
        String result = driver.findElement(MainPageLocators.searchAmountRes).getText();
        System.out.println(result);

    }

    private void submitResult() {
        driver.findElement(MainPageLocators.searchButton).click();
    }

    private void typeRequestInSearchInput(String param) {
        driver.findElement(MainPageLocators.searchField).sendKeys(param);
        

        
    }

    private void navigateToMainPage(String url) {

        driver.get(url);
    }
}
