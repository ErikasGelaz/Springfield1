package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    @FindBy(xpath = "//*[@id=\"root\"]/div/nav/nav/ul/li[1]/a")
    private WebElement loginPageUrl;
    @FindBy(name = "email")
    private  WebElement username;
    @FindBy(name = "password")
    private WebElement password;
    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div/form/button[1]")
    private  WebElement loginButton;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    public void getToLoginPage() {
        this.loginPageUrl.click();
    }
    public void setUsername(String username) {
        this.username.sendKeys(username);
    }
    public void setPassword(String password) {
        this.password.sendKeys(password);
    }
    public void clickOnLoginButton() {
        this.loginButton.click();
    }
}
