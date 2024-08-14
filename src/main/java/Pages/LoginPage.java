package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	@FindBy(xpath = "//*[@name='uname']")
	private WebElement userName;

	@FindBy(xpath = "//*[@name='pass']")
	private WebElement password;

	@FindBy(xpath = "//*[@type='submit']")
	private WebElement login;

	@FindBy(xpath = "(//*[@class='story']//p)[1]")
	private WebElement title;

	@FindBy(xpath = "(//*[@id='content']//h3)[1]")
	private WebElement invalidTitle;

	public LoginPage(WebDriver driver){
		PageFactory.initElements(driver,this);
	}

	public void sendUserName(String user){
		userName.sendKeys(user);
	}

	public void sendPassword(String pass){
		password.sendKeys(pass);
	}

	public void clickOnLoginBtn(){
		login.click();
	}
	
	public String getTitle(){
        return title.getText();
    }

    public String getInvalidTitle(){
        return invalidTitle.getText();
    }

}
