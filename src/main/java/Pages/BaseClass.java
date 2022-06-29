package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.nio.file.Paths;

public class BaseClass {
    public static WebDriver chrome = null;
    static {
        System.setProperty("webdriver.chrome.driver", Paths.get("src/test/resources/drivers/chromedriver-2").toString());
        chrome = new ChromeDriver();
        chrome.get("http://localhost:3000");
    }
}
