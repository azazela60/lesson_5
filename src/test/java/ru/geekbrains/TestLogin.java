package ru.geekbrains;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

class TestLogin {


    private final String LOGIN_PAGE_URL = "https://www.diary.ru";
    private final String LOGIN = "nbfgdc45";
    private final String PASSWORD = "aaa#a4890";
    private WebDriver driver;


    public TestLogin(WebDriver driver) {
        this.driver = driver;
    }

    @BeforeAll
    public static void setupWebDriverManager() {
        WebDriverManager.chromedriver().setup();

    }


    @BeforeEach
    public void beforeTest() {
        setUpDriverSession();
        login();
    }


    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }

    }

    @Test
    public void createNewExpenseTest() {

        By btnLocator = By.xpath(
                ".//[@class='nav navbar-nav navbar-index'/li[@class='dropdown open']/a[@class='dropdown-toggle']/span[text()='Вход']");

        Actions actions = new Actions(driver);
        WebElement menu = driver.findElement(btnLocator);
        Actions actions1 = actions.moveToElement(menu);
        actions.click().build().perform();
    }

    @Test
    public void testLogin(){
        login();
    }

        private void login () {
            driver.get(LOGIN_PAGE_URL);

            WebElement loginButton = driver.findElement(By.xpath(".//*[@id='drop-login']"));
            loginButton.click();
            WebElement loginTextInput = driver.findElement(By.cssSelector("input[id='usrlog2']"));
            loginTextInput.sendKeys(LOGIN);

            WebElement passwordTextInput = driver.findElement(By.cssSelector("input[id='usrpass2']"));
            passwordTextInput.sendKeys(PASSWORD);

            WebElement loginButton1 = driver.findElement(By.xpath(".//*[@id='drop-login']"));
            loginButton.click();

        }

    private void setUpDriverSession () {
            driver = new ChromeDriver();
            ChromeOptions options = new ChromeOptions();
            options.setPageLoadStrategy(PageLoadStrategy.EAGER);
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    }



