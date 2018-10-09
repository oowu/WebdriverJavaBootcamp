package GoogleSignIn;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Locators {
    public static By signInButton = By.id("gb_70");
    public static By emailField = By.id("identifierId");
    public static By nextBtn = By.xpath("//span[.='Next']");
    public static By passField = By.cssSelector("input.whsOnd.zHQkBf");
}
