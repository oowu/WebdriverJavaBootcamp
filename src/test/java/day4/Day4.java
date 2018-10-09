package day4;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;

public class Day4 {
    private WebDriver driver;

    @BeforeTest(groups = {"mygroup"})
    public void setupDriver() {
        File file = new File("src/test/resources");
        String path = file.getAbsolutePath();
        System.setProperty("webdriver.gecko.driver", path + "/geckodriver");
        driver = new FirefoxDriver();
    }

    @Test
    public void testName() throws Exception {

    }
}
