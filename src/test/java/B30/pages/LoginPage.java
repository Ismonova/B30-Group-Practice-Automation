package B30.pages;

import B30.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage (){
        PageFactory.initElements(Driver.getDriver(),this);
    }

  @FindBy(id = "user")
    public WebElement userName;

    @FindBy(id="password")
    public WebElement passwordInput;

    @FindBy (id="submit-form")
    public WebElement loginBtn;


    public void login (String user, String password){
        userName.sendKeys(user);
        passwordInput.sendKeys(password);
        loginBtn.click();
    }


}
