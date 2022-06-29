import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.nio.file.Paths;
import java.time.Duration;

public class springfieldLoginAndEarnings {
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
    void sApplication1() throws InterruptedException {
        // page Aplikacija
        //WebElement greetingsMessage = chrome.findElement(By.cssSelector("body > div.swal-overlay > div > div.swal-footer > div > button"));
        //greetingsMessage.submit();
        WebElement application = chrome.findElement(By.cssSelector("#root > div > nav > nav > ul > li:nth-child(2) > a"));
        application.click();
        chrome.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement loginResult = new WebDriverWait(chrome, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div/div/div/div[2]/div[2]/form/button[1]")));
        String expected = "Pridėti";
        String actual = loginResult.getText();
        Assertions.assertEquals(expected, actual);
        chrome.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Thread.sleep(2000);
    }

    @Test
    void sApplication2() throws InterruptedException {
        //earnings text skola
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
        Thread.sleep(2000);

        //WebElement loginReult = new WebDriverWait(chrome, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/nav/nav/ul/li[6]/button")));
        WebElement earningsTextResult = chrome.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[3]/table/tbody/tr/td[3]"));
        String expected = "skola";
        String actual = earningsTextResult.getText();
        Assertions.assertEquals(expected, actual);
        chrome.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //Thread.sleep(5000);
    }

    @Test
    void sApplication3() throws InterruptedException {
        // earnings amount 50
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
        earningsAmount.sendKeys("50");
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

        //WebElement loginReult = new WebDriverWait(chrome, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/nav/nav/ul/li[6]/button")));
        WebElement earningsAmountResult = chrome.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[3]/table/tbody/tr[1]/td[1]"));
        String expected = "50";
        String actual = earningsAmountResult.getText();
        Assertions.assertEquals(expected, actual);
        chrome.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //Thread.sleep(5000);
    }

    @Test
    void sApplication4() throws InterruptedException {
        // earnings group selection
        WebElement application = chrome.findElement(By.cssSelector("#root > div > nav > nav > ul > li:nth-child(2) > a"));
        application.click();
        chrome.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Thread.sleep(2000);

        WebElement firstSelection = chrome.findElement(By.cssSelector("#root > div > div > div > div > div.Form-container > div.Form-body > form > select:nth-child(1)"));
        Select firstSelectionObject = new Select(firstSelection);
        firstSelectionObject.selectByVisibleText("Pajamos");
        WebElement earningsSelection = chrome.findElement(By.xpath("//*[@id=\"category\"]"));
        Select earningsSelectionObject = new Select(earningsSelection);
        earningsSelectionObject.selectByVisibleText("Investavimas");
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

        //WebElement loginReult = new WebDriverWait(chrome, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/nav/nav/ul/li[6]/button")));
        WebElement earningsGroupSelection = chrome.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[3]/table/tbody/tr[1]/td[2]"));
        String expected = "Investavimas";
        String actual = earningsGroupSelection.getText();
        Assertions.assertEquals(expected, actual);
        chrome.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //Thread.sleep(5000);
    }

    @Test
    void sApplication5() throws InterruptedException {
        // earnings negative amount error
        WebElement application = chrome.findElement(By.cssSelector("#root > div > nav > nav > ul > li:nth-child(2) > a"));
        application.click();
        chrome.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Thread.sleep(2000);

        WebElement firstSelection = chrome.findElement(By.cssSelector("#root > div > div > div > div > div.Form-container > div.Form-body > form > select:nth-child(1)"));
        Select firstSelectionObject = new Select(firstSelection);
        firstSelectionObject.selectByVisibleText("Pajamos");
        WebElement earningsSelection = chrome.findElement(By.xpath("//*[@id=\"category\"]"));
        Select earningsSelectionObject = new Select(earningsSelection);
        earningsSelectionObject.selectByVisibleText("Investavimas");
        chrome.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement earningsAmount = chrome.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div[2]/div[2]/form/input[1]"));
        earningsAmount.sendKeys("-10");
        chrome.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement name = chrome.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div[2]/div[2]/form/input[3]"));
        name.sendKeys("skola");
        chrome.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement submit = chrome.findElement(By.cssSelector("#root > div > div > div > div > div.Form-container > div.Form-body > form > button.Form-btn"));
        submit.submit();
        chrome.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement earningsNegativeAmountError = chrome.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div[2]/div[2]/form/p[2]"));
        String expected = "Galimi tik teigiami skaičiai ir du skaičiai po kablelio";
        String actual = earningsNegativeAmountError.getText();
        Assertions.assertEquals(expected, actual);
        chrome.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement cancel = chrome.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div[2]/div[2]/form/button[2]"));
        cancel.click();
    }

    @Test
    void sApplication6() throws InterruptedException {
        // earnings date selection
        WebElement application = chrome.findElement(By.cssSelector("#root > div > nav > nav > ul > li:nth-child(2) > a"));
        application.click();
        chrome.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Thread.sleep(2000);

        WebElement firstSelection = chrome.findElement(By.cssSelector("#root > div > div > div > div > div.Form-container > div.Form-body > form > select:nth-child(1)"));
        Select firstSelectionObject = new Select(firstSelection);
        firstSelectionObject.selectByVisibleText("Pajamos");
        WebElement earningsSelection = chrome.findElement(By.xpath("//*[@id=\"category\"]"));
        Select earningsSelectionObject = new Select(earningsSelection);
        earningsSelectionObject.selectByVisibleText("Investavimas");
        chrome.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement earningsAmount = chrome.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div[2]/div[2]/form/input[1]"));
        earningsAmount.sendKeys("10");
        chrome.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement earningsDate = chrome.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div[2]/div[2]/form/input[2]"));
        earningsDate.sendKeys("2021" + Keys.TAB + "0505");
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

        //WebElement loginReult = new WebDriverWait(chrome, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/nav/nav/ul/li[6]/button")));
        WebElement earningsDateSelection = chrome.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[3]/table/tbody/tr[1]/td[4]"));
        String expected = "2021-05-05";
        String actual = earningsDateSelection.getText();
        Assertions.assertEquals(expected, actual);
        chrome.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //Thread.sleep(5000);
    }

    @Test
    void sApplication7() throws InterruptedException {
        // earnings clear fields
        WebElement application = chrome.findElement(By.cssSelector("#root > div > nav > nav > ul > li:nth-child(2) > a"));
        application.click();
        chrome.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Thread.sleep(2000);

        WebElement firstSelection = chrome.findElement(By.cssSelector("#root > div > div > div > div > div.Form-container > div.Form-body > form > select:nth-child(1)"));
        Select firstSelectionObject = new Select(firstSelection);
        firstSelectionObject.selectByVisibleText("Pajamos");
        WebElement earningsSelection = chrome.findElement(By.xpath("//*[@id=\"category\"]"));
        Select earningsSelectionObject = new Select(earningsSelection);
        earningsSelectionObject.selectByVisibleText("Investavimas");
        chrome.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        WebElement earningsAmount = chrome.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div[2]/div[2]/form/input[1]"));
        earningsAmount.sendKeys("10");
        chrome.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement name = chrome.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div[2]/div[2]/form/input[3]"));
        name.sendKeys("skola");
        chrome.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement submit = chrome.findElement(By.cssSelector("#root > div > div > div > div > div.Form-container > div.Form-body > form > button.Form-btn"));
        submit.submit();
        chrome.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement earningsAmountAdded = chrome.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div[2]/div[2]/form/input[1]"));
        String expected = "";
        String actual = earningsAmountAdded.getText();
        Assertions.assertEquals(expected, actual);
        chrome.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement cancel = chrome.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div[2]/div[2]/form/button[2]"));
        cancel.click();
    }
}
