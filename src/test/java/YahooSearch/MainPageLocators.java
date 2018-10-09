package YahooSearch;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPageLocators {
    public static By searchField = By.id("uh-search-box");
    public static By searchButton = By.id("uh-search-button");
    public static By searchAmountRes = By.xpath("//div[@class='compPagination']/span");
}
