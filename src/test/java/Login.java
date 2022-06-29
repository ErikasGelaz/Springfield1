import Pages.BaseClass;
import Pages.LoginPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.nio.file.Paths;
import java.time.Duration;

public class Login extends BaseClass {

    //static ChromeDriver chrome;
    //@BeforeEach
    //void setUp() {
    //System.setProperty("webdriver.chrome.driver", Paths.get("src/test/resources/drivers/chromedriver-2").toString());
    //chrome = new ChromeDriver();

    @AfterEach
    void tearDown() {
        chrome.quit();
    }

    @Test
    void login() {
        //chrome.get("http://localhost:3000");

        LoginPage loginPage = new LoginPage(chrome);
        loginPage.getToLoginPage();
        loginPage.setUsername("login@gmail.com");
        loginPage.setPassword("Password1");
        loginPage.clickOnLoginButton();
        WebElement loginReult = new WebDriverWait(chrome, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/nav/nav/ul/li[6]/button")));
        String expected = "Atsijungti";
        String actual = loginReult.getText();
        Assertions.assertEquals(expected, actual);
        chrome.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //Thread.sleep(5000);
    }

    @Test
    void logout() throws InterruptedException {
        //chrome.get("http://localhost:3000");
        LoginPage loginPage = new LoginPage(chrome);
        loginPage.getToLoginPage();
        loginPage.setUsername("login@gmail.com");
        loginPage.setPassword("Password1");
        loginPage.clickOnLoginButton();
        chrome.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement greetingsMessage = chrome.findElement(By.xpath("/html/body/div[2]/div/div[3]/div/button"));
        greetingsMessage.click();
        WebElement logoutButton = new WebDriverWait(chrome, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/nav/nav/ul/li[6]/button")));
        logoutButton.click();
        WebElement logoutConfirmButton = chrome.findElement(By.xpath("/html/body/div[2]/div/div[3]/div[2]/button"));
        logoutConfirmButton.click();

        WebElement logoutReult = new WebDriverWait(chrome, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/nav/nav/ul/li[2]/a")));
        String expected = "Registruotis";
        String actual = logoutReult.getText();
        Assertions.assertEquals(expected, actual);
        chrome.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //Thread.sleep(5000);
    }

}
