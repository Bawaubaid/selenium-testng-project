package webApplication.PageObjects;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import webApplication.abstractComponents.AbstractComponent;

public class CartPage extends AbstractComponent {
	
	WebDriver driver;

	public CartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = ".cartSection h3")
	List <WebElement> cartProducts;
	
	@FindBy(css= ".totalRow .btn-primary")
	WebElement checkOut;
	
	
	public Boolean verifyCartProducts(String productName) {
		Boolean match = cartProducts.stream().anyMatch(p->p.getText().equalsIgnoreCase(productName));
		return match;
	}
	
	public CheckOutPage goToCheckoutPage() {
		checkOut.click();
		return new CheckOutPage(driver);
	}
	
}
