import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.nio.file.Paths;
import java.time.Duration;

public class springfieldLoginAndHistory {
    static ChromeDriver chrome;

    @BeforeAll
    static void beforeAll() {
        System.setProperty("webdriver.chrome.driver", Paths.get("src/test/resources/drivers/chromedriver-2").toString());
        chrome = new ChromeDriver();
    }

    @AfterAll
    static void afterAll() {
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
        WebElement greetingsMessage = chrome.findElement(By.xpath("/html/body/div[2]/div/div[3]/div/button"));
        greetingsMessage.click();
        WebElement loginReult = new WebDriverWait(chrome, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/nav/nav/ul/li[6]/button")));
        String expected = "Atsijungti";
        String actual = loginReult.getText();
        Assertions.assertEquals(expected, actual);
        chrome.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Thread.sleep(4000);
    }
    @Test
    void sHistory1() throws InterruptedException {
        // Istorija page
        //WebElement greetingsMessage = chrome.findElement(By.cssSelector("body > div.swal-overlay > div > div.swal-footer > div > button"));
        //greetingsMessage.submit();
        WebElement history = chrome.findElement(By.xpath("//*[@id=\"root\"]/div/nav/nav/ul/li[3]/a"));
        history.click();
        chrome.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement loginResult = new WebDriverWait(chrome, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div/div[3]/table/tbody/tr[1]/td[5]/button[2]")));
        String expected = "Ištrinti";
        String actual = loginResult.getText();
        Assertions.assertEquals(expected, actual);
        chrome.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Thread.sleep(2000);
    }

    @Test
    void sHistory2() throws InterruptedException {
        // delete button confirmation message
        WebElement history = chrome.findElement(By.xpath("//*[@id=\"root\"]/div/nav/nav/ul/li[3]/a"));
        history.click();
        chrome.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement deleteButton = chrome.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[3]/table/tbody/tr[1]/td[5]/button[2]"));
        deleteButton.click();
        WebElement deleteButtonResult = new WebDriverWait(chrome, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div/div[3]/div[2]/button")));
        String expected = "Gerai";
        String actual = deleteButtonResult.getText();
        Assertions.assertEquals(expected, actual);
        chrome.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement cancel = chrome.findElement(By.xpath("/html/body/div[2]/div/div[3]/div[1]/button"));
        cancel.click();
        Thread.sleep(2000);
    }

    @Test
    void sHistory3() throws InterruptedException {
        // delete button working
        WebElement application = chrome.findElement(By.cssSelector("#root > div > nav > nav > ul > li:nth-child(2) > a"));
        application.click();
        chrome.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Thread.sleep(2000);

        WebElement firstSelection = chrome.findElement(By.cssSelector("#root > div > div > div > div > div.Form-container > div.Form-body > form > select:nth-child(1)"));
        Select firstSelectionObject = new Select(firstSelection);
        firstSelectionObject.selectByVisibleText("Pajamos");
        WebElement earningsSelection = chrome.findElement(By.xpath("//*[@id=\"category\"]"));
        Select earningsSelectionObject = new Select(earningsSelection);
        earningsSelectionObject.selectByVisibleText("Kita");
        chrome.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement earningsAmount = chrome.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div[2]/div[2]/form/input[1]"));
        earningsAmount.sendKeys("10");
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
        Thread.sleep(2000);
        WebElement earningsAmountResult = chrome.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[3]/table/tbody/tr[1]/td[1]"));
        String expectedErnings = "10";
        String actualEarnings = earningsAmountResult.getText();
        Assertions.assertEquals(expectedErnings, actualEarnings);
        chrome.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Thread.sleep(2000);

        WebElement application1 = chrome.findElement(By.cssSelector("#root > div > nav > nav > ul > li:nth-child(2) > a"));
        application.click();
        chrome.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Thread.sleep(2000);

        WebElement firstSelection1 = chrome.findElement(By.cssSelector("#root > div > div > div > div > div.Form-container > div.Form-body > form > select:nth-child(1)"));
        Select firstSelectionObject1 = new Select(firstSelection1);
        firstSelectionObject1.selectByVisibleText("Pajamos");
        WebElement earningsSelection1 = chrome.findElement(By.xpath("//*[@id=\"category\"]"));
        Select earningsSelectionObject1 = new Select(earningsSelection1);
        earningsSelectionObject1.selectByVisibleText("Kita");
        chrome.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement earningsAmount1 = chrome.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div[2]/div[2]/form/input[1]"));
        earningsAmount1.sendKeys("50");
        chrome.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement name1 = chrome.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div[2]/div[2]/form/input[3]"));
        name1.sendKeys("skola");
        chrome.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement submit1 = chrome.findElement(By.cssSelector("#root > div > div > div > div > div.Form-container > div.Form-body > form > button.Form-btn"));
        submit1.submit();
        chrome.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement historyButton1 = chrome.findElement(By.xpath("//*[@id=\"root\"]/div/nav/nav/ul/li[3]"));
        //WebElement historyButton = new WebDriverWait(chrome, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\\\"root\\\"]/div/nav/nav/ul/li[3]")));
        historyButton1.click();
        chrome.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Thread.sleep(2000);
        WebElement earningsAmountResult1 = chrome.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[3]/table/tbody/tr[1]/td[1]"));
        String expectedEarnings1 = "50";
        String actualEarnings1 = earningsAmountResult1.getText();
        Assertions.assertEquals(expectedEarnings1, actualEarnings1);
        chrome.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement deleteButton = chrome.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[3]/table/tbody/tr[1]/td[5]/button[2]"));
        deleteButton.click();
        WebElement deleteButtonConfirmation = chrome.findElement(By.xpath("/html/body/div[2]/div/div[3]/div[2]/button"));
        deleteButtonConfirmation.click();
        Thread.sleep(2000);
        WebElement deleteButtonResult = new WebDriverWait(chrome, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div/div[3]/table/tbody/tr[1]/td[1]")));
        String expected = "10";
        String actual = deleteButtonResult.getText();
        Assertions.assertEquals(expected, actual);
        chrome.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Thread.sleep(2000);
    }
}
