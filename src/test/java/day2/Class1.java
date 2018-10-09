package day2;

import GoogleSignIn.Locators;
import YahooSearch.MainPageLocators;
import com.beust.jcommander.Parameter;
import com.sun.deploy.util.Waiter;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.File;
import java.util.List;

public class Class1 {
    private WebDriver driver;

    @BeforeTest(groups = {"mygroup"})
    public void setupDriver() {
        File file = new File("src/test/resources");
        String path = file.getAbsolutePath();
        System.setProperty("webdriver.gecko.driver", path + "/geckodriver");
        driver = new FirefoxDriver();

    }


    @Test
    public void test001() throws Exception {
        driver.get("http://google.com");
        driver.findElement(By.xpath("//input[@class='gLFyf gsfi']")).sendKeys("portnov computer school");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.xpath("//input[@value='Google Search']")).click();
        String result = driver.findElement(By.id("resultStats")).getText();
        System.out.println(result);

    }

    //HOMEWORK
    @Test
    public void test002() throws Exception {
        driver.get("http://google.com");
        driver.findElement(Locators.signInButton).click();
        driver.findElement(Locators.emailField).sendKeys("bootcampportnov");
        driver.findElement(Locators.nextBtn).click();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.whsOnd.zHQkBf")));
        if (driver.findElement(Locators.passField).isDisplayed()) {
            driver.findElement(Locators.passField).sendKeys("abcdef1234@");
        }

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[.='Next']")));

        driver.findElement(By.xpath("//span[.='Next']")).click();
        WebElement element = driver.findElement(By.xpath("//a[contains(@title, 'Google Account')]"));
        element.click();
        String res = driver.findElement(By.xpath("//div[@class='gb_Eb']")).getText();
        Assert.assertEquals(res, "bootcampportnov@gmail.com");


    }

    @Test
    public void forgotPass() throws Exception {
        driver.get("http://the-internet.herokuapp.com/forgot_password");
        driver.findElement(By.id("email")).sendKeys("my@email.com");
        driver.findElement(By.id("form_submit")).click();
        WebElement element = driver.findElement(By.id("content"));
        String result = element.getText();
        Assert.assertEquals(result, "Your e-mail's been sent!");

    }

    @Test
    public void test004() throws Exception {
        driver.get("http://the-internet.herokuapp.com/dynamic_loading/1");
        driver.findElement(By.xpath("//div[@id='start']/button")).click();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        //check if element is visible
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='finish']/H4")));
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='finish']/H4")).getText(), "Hello World!");
    }

    @Test
    public void test005() throws Exception {
        driver.get("http://the-internet.herokuapp.com/dynamic_loading/2");
        driver.findElement(By.xpath("//div[@id='start']/button")).click();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        //check if element was created
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='finish']/H4")));
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='finish']/H4")).getText(), "Hello World!");

    }

    @Test
    public void test006() throws Exception {
        driver.get("http://the-internet.herokuapp.com/disappearing_elements");
        if (driver.findElement(By.linkText("Gallery")).isDisplayed()) {
            driver.findElement(By.linkText("Gallery")).click();
        }
    }

    @Test
    //HOW TO SELECT ELEMENT IN DROPDOWN MENU
    public void testDropdown() throws Exception {
        driver.get("http://the-internet.herokuapp.com/dropdown");
        Select dropdown = new Select(driver.findElement(By.id("dropdown")));
        dropdown.selectByVisibleText("Option 2");
        WebElement option = dropdown.getFirstSelectedOption();
        String getText = option.getText();
        Assert.assertEquals(getText, "Option 2");
        //dropdown.selectByValue("1");//choose value 1
        //dropdown.selectByValue("2");//choose vlue 2
    }

    @Test
    //INSERT TEXT INTO ALERT INPUTFIELD
    public void testAlerts() throws Exception {
        driver.get("http://the-internet.herokuapp.com/javascript_alerts");
        List<WebElement> elements = driver.findElements(By.tagName("button"));
        elements.get(2).click();
        //String textFromAlert = driver.switchTo().alert().getText();
        //Assert.assertEquals(textFromAlert, "I am a JS Confirm");
        Alert myAlert = driver.switchTo().alert();
        String myTxt = "Bohdan";
        myAlert.sendKeys(myTxt);
        //String textFromAlert = myAlert.getText();

        myAlert.accept();
        String result = driver.findElement(By.xpath("//p[@id='result']")).getText();

        Assert.assertEquals(result, "You entered: " + myTxt);

        //Assert.assertEquals(result,"You clicked Ok");


    }

    @Test
    public void testLoginJS() throws Exception {
        driver.get("http://the-internet.herokuapp.com/login");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.getElementById('username').value='tomsmith'");
        js.executeScript("document.getElementById('password').value='SuperSecretPassword!'");
        driver.findElement(By.xpath("//button[@class='radius']")).click();
        String result = driver.findElement(By.className("subheader")).getText();
        String result1 = driver.findElement(By.id("flash")).getText();
        //Assert.assertEquals(result,"Welcome to the Secure Area. When you are done click logout below.");
        Assert.assertEquals(result1, "You logged into a secure area!\n" + "×");

    }

    @Test
    //1st test
    public void testGoogle() throws Exception {

        driver.get("http://www.google.com");
        driver.findElement(By.id("gb_70")).click();
        driver.findElement(By.id("identifierId")).sendKeys("bootcampportnov");
        driver.findElement(By.xpath("//span[.='Next']")).click();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.textToBe(By.id("headingText"), "Welcome"));
        String actualRes = driver.findElement(By.xpath("//h1[@id='headingText' and contains(content,'Wel')]")).getText();
        Assert.assertEquals(actualRes, "Welcome!");
    }

    @Test
    //2nd test
    public void testClickForgetEmail() throws Exception {
        driver.get("http://www.google.com");
        driver.findElement(By.id("gb_70")).click();
        driver.findElement(By.xpath("//content[@class='CwaK9']")).click();
        String actualRes = driver.findElement(By.xpath("//h1[@id='headingText' and contains(content,'Find')]")).getText();
        Assert.assertEquals(actualRes, "Find your email!");
    }

    @Test
    public void testInvalidEmail() throws Exception {
        driver.get("http://www.google.com");
        driver.findElement(By.id("gb_70")).click();
        driver.findElement(By.id("identifierId")).sendKeys("bootcampportnovINVALID");
        driver.findElement(By.xpath("//span[.='Next']")).click();
        String actualRes = driver.findElement(By.xpath("//div[@class='dEOOab RxsGPe']")).getText();
        Assert.assertEquals(actualRes, "Couldn\'t find your Google Account!");

    }

    @Test
    public void testCreateAcc() throws Exception {
        driver.get("http://www.google.com");
        driver.findElement(By.id("gb_70")).click();
        driver.findElement(By.xpath("//span[@class='RveJvd snByac' and contains(text(),'Create')]")).click();
        String actualRes = driver.findElement(By.xpath("//h1[@id='headingText']")).getText();
        Assert.assertEquals(actualRes, "Create your Google Account");
    }

    @Test
    public void test0char() throws Exception {
        driver.get("http://www.google.com");
        driver.findElement(By.id("gb_70")).click();
        driver.findElement(By.id("identifierId")).sendKeys("");
        driver.findElement(By.xpath("//span[.='Next']")).click();
        //String actualRes = driver.findElement(By.xpath("//div[@class='dEOOab RxsGPe']")).getText();
        //Assert.assertEquals(actualRes,"Enter an email or phone number!");
        Boolean containsText = driver.getPageSource().contains("Enter an email or phone number");
        Assert.assertTrue(containsText);
    }

    @Test(groups = {"fast"})
    public void testLearnMore() throws Exception {
        driver.get("http://www.google.com");
        driver.findElement(By.id("gb_70")).click();
        driver.findElement(By.partialLinkText("Learn more")).click();
    }
    @DataProvider(name = "data2")
    public Object[][] createData1() {
        return new Object[][]{
                //new Object[] {"lietuv"},
                //new Object[] {"eesti"}
                {"zh-TW"},{"da"},
                {"pl"},{"gu"}
        };
    }

    @Test(dataProvider = "data2",groups = {"mygroup"})
    //HOMEWORK
    public void testChangeLang(String mylang) throws Exception {
        driver.get("http://www.google.com");
        driver.findElement(By.id("gb_70")).click();//Sign In Button
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='TquXA']")));
        driver.findElement(By.xpath("//div[@class='TquXA']")).click();//dropdown
        driver.findElement(By.xpath("//div[@class='OA0qNb ncFHed']/div[@data-value='"+mylang+"']")).click();

        String result = driver.findElement(By.xpath("//div[@id='lang-chooser']//div[@data-value='"+mylang+"']/content")).getText();
        System.out.println(result);



        /*WebElement dropdownElement = driver.findElement(By.xpath(("//div[@class='OA0qNb ncFHed']" +
                "/div[@class='MocG8c B9IrJb LMgvRb' and contains(content,'" + mylang + "')]")));
        if (dropdownElement.isDisplayed()){
            dropdownElement.click();
        }
        /*driver.findElement(By.xpath(("//div[@class='OA0qNb ncFHed']" +
                "/div[@class='MocG8c B9IrJb LMgvRb' and contains(content,'" + mylang + "')]"))).click();*/
    }

    @Test
    //HOMEWORK
    public void testGoToWindow() throws Exception {
        driver.get("http://www.google.com");
        driver.findElement(Locators.signInButton).click();
        driver.findElement(By.xpath("//ul[@class='Bgzgmd']/li[contains(a,'Help')]")).click();


    }

    @DataProvider(name = "data1")
    public Object[][] createData() {
        return new Object[][]{
            { "Bohdan" , new Integer(35)},
            { "Mike", new Integer(77)}
        };
    }
    @Test(dataProvider = "data1")
    public void verifyData(String str, Integer intg){
        System.out.println(str + " "+ intg);
    }



    @AfterTest
    public void closeBrowser(){
        //driver.close();
    }


}
