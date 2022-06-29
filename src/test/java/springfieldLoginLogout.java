import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;

import java.nio.file.Paths;
import java.time.Duration;

public class springfieldLoginLogout {
    static ChromeDriver chrome;
    @BeforeEach
    void setUp() {
        System.setProperty("webdriver.chrome.driver", Paths.get("src/test/resources/drivers/chromedriver-2").toString());
        chrome = new ChromeDriver();
    }
    @AfterEach
    void tearDown() {
        chrome.quit();
    }


    @Test
    void login() throws InterruptedException {
        chrome.get("http://localhost:3000");
        chrome.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement login = chrome.findElement(By.xpath("//*[@id=\"root\"]/div/nav/nav/ul/li[1]/a"));
        login.click();
        WebElement username = chrome.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/form/input"));
        WebElement password = chrome.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/form/div[2]/input"));
        WebElement loginButton = chrome.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/form/button[1]"));

        username.sendKeys("login@gmail.com");
        password.sendKeys("Password1");
        loginButton.click();
        WebElement loginReult = new WebDriverWait(chrome, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/nav/nav/ul/li[6]/button")));
        String expected = "Atsijungti";
        String actual = loginReult.getText();
        Assertions.assertEquals(expected, actual);
        chrome.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //Thread.sleep(5000);
    }
    @Test
    void logout() throws InterruptedException {
        chrome.get("http://localhost:3000");
        chrome.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement login = chrome.findElement(By.xpath("//*[@id=\"root\"]/div/nav/nav/ul/li[1]/a"));
        login.click();
        WebElement username = chrome.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/form/input"));
        WebElement password = chrome.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/form/div[2]/input"));
        WebElement loginButton = chrome.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/form/button[1]"));

        username.sendKeys("login@gmail.com");
        password.sendKeys("Password1");
        loginButton.click();
        chrome.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement greetingsMessage = chrome.findElement(By.xpath("/html/body/div[2]/div/div[3]/div/button"));
        greetingsMessage.click();
        //WebElement logoutButton = chrome.findElement(By.xpath("//*[@id=\"root\"]/div/nav/nav/ul/li[6]/button"));
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
    @Test
    void logoutCancel() throws InterruptedException {
        chrome.get("http://localhost:3000");
        chrome.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement login = chrome.findElement(By.xpath("//*[@id=\"root\"]/div/nav/nav/ul/li[1]/a"));
        login.click();
        WebElement username = chrome.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/form/input"));
        WebElement password = chrome.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/form/div[2]/input"));
        WebElement loginButton = chrome.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/form/button[1]"));

        username.sendKeys("login@gmail.com");
        password.sendKeys("Password1");
        loginButton.click();
        chrome.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement greetingsMessage = chrome.findElement(By.xpath("/html/body/div[2]/div/div[3]/div/button"));
        greetingsMessage.click();
        //WebElement logoutButton = chrome.findElement(By.xpath("//*[@id=\"root\"]/div/nav/nav/ul/li[6]/button"));
        WebElement logoutButton = new WebDriverWait(chrome, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/nav/nav/ul/li[6]/button")));
        logoutButton.click();
        WebElement logoutCancelButton = chrome.findElement(By.xpath("/html/body/div[2]/div/div[3]/div[1]/button"));
        logoutCancelButton.click();

        WebElement logoutCancelReult = new WebDriverWait(chrome, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/nav/nav/ul/li[6]/button")));
        String expected = "Atsijungti";
        String actual = logoutCancelReult.getText();
        Assertions.assertEquals(expected, actual);
        chrome.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //Thread.sleep(5000);
    }
}




