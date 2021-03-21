package ru.geekbrains;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;



public class Login_1 {

    public static final String LOGIN_PAGE_URL = "https://www.diary.ru/";
    static final String LOGIN = "nbfgdc45";
    static final String PASSWORD = "aaa#a4890";
    private static final WebDriver driver;

    static {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-bloking");

    }

    public static void main(String[] args) throws InterruptedException {
        driver.get(LOGIN_PAGE_URL);
        WebElement LoginButton = driver.findElement(By.xpath(".//*[@id='drop-login']"));
        LoginButton.click();
        WebElement LoginTextInput = driver.findElement(By.cssSelector("input[id='usrlog2']"));
        LoginTextInput.sendKeys(LOGIN);
        WebElement passwordTextInput = driver.findElement(By.cssSelector("input[id='usrpass2']"));
        passwordTextInput.sendKeys(PASSWORD);
        Thread.sleep(2000);
        WebElement LoginButton1 = driver.findElement(By.xpath("//*[@id=\"signin_btn\"]"));
        LoginButton1.click();
        Thread.sleep(2000);
        driver.close();
        Thread.sleep(2000);
        driver.quit();
    }
}
