package webApplication.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import webApplication.abstractComponents.AbstractComponent;

public class LoginPage extends AbstractComponent {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "userEmail")
	WebElement userEmail;

	@FindBy(id = "userPassword")
	WebElement password;

	@FindBy(id = "login")
	WebElement submit;

	public ProductCatalogue login(String email, String pswrd) {
		userEmail.sendKeys(email);
		password.sendKeys(pswrd);
		submit.click();
		ProductCatalogue productCatalogue = new ProductCatalogue(driver);
		return productCatalogue;
	}

	public void getTo() {

		driver.get("https://rahulshettyacademy.com/client");
	}
}
