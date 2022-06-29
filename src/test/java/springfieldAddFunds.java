import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.nio.file.Paths;
import java.time.Duration;

public class springfieldAddFunds {

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
    void earningsOtherDebt() throws InterruptedException {
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
        WebElement greetingsMessage = chrome.findElement(By.xpath("/html/body/div[2]/div/div[3]/div/button"));
        greetingsMessage.click();
        chrome.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Thread.sleep(1000);

        WebElement application = chrome.findElement(By.cssSelector("#root > div > nav > nav > ul > li:nth-child(2) > a"));
        application.click();
        chrome.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement firstSelection = chrome.findElement(By.cssSelector("#root > div > div > div > div > div.Form-container > div.Form-body > form > select:nth-child(1)"));
        Select firstSelectionObject = new Select(firstSelection);
        firstSelectionObject.selectByVisibleText("Pajamos");
        WebElement earningsSelection = chrome.findElement(By.xpath("//*[@id=\"category\"]"));
        Select earningsSelectionObject = new Select(earningsSelection);
        earningsSelectionObject.selectByVisibleText("Kita");
        chrome.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement earningsAmount = chrome.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div[2]/div[2]/form/input[1]"));
        earningsAmount.sendKeys("20");
        chrome.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement name = chrome.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div[2]/div[2]/form/input[3]"));
        name.sendKeys("skola");
        chrome.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement submit = chrome.findElement(By.cssSelector("#root > div > div > div > div > div.Form-container > div.Form-body > form > button.Form-btn"));
        submit.submit();
        chrome.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement historyButton = chrome.findElement(By.xpath("//*[@id=\"root\"]/div/nav/nav/ul/li[3]"));
        //WebElement historyButton = new WebDriverWait(chrome, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\\\"root\\\"]/div/nav/nav/ul/li[3]")));
        historyButton.click();
        chrome.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //Thread.sleep(5000);


        //WebElement loginReult = new WebDriverWait(chrome, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/nav/nav/ul/li[6]/button")));
        WebElement earningsResult = chrome.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[3]/table/tbody/tr/td[3]"));
        String expected = "skola";
        String actual = earningsResult.getText();
        Assertions.assertEquals(expected, actual);
        chrome.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //Thread.sleep(5000);
    }

}
