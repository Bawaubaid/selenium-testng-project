package webApplicationTests;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import webApplication.PageObjects.CartPage;
import webApplication.PageObjects.CheckOutPage;
import webApplication.PageObjects.ConfirmationPage;
import webApplication.PageObjects.LoginPage;
import webApplication.PageObjects.ProductCatalogue;
import webSiteTests.baseTest.BaseTests;

public class SubmitOrder extends BaseTests {

	@Test
	public void submitOrderTest() throws IOException , InterruptedException{
		String username = "bawaubaidullah@gmail.com";
		String password = "Ubaid@1234";
		String productName = "ADIDAS ORIGINAL";
		LoginPage loginPage = launchApplication();
		
		ProductCatalogue productCatalogue = loginPage.login(username, password);
		productCatalogue.getProductList();
		productCatalogue.addProductToCart(productName);
		CartPage cartPage = productCatalogue.goToCartPage();
		Boolean match = cartPage.verifyCartProducts(productName);
		Assert.assertTrue(match);
		CheckOutPage checkOutPage = cartPage.goToCheckoutPage();
		ConfirmationPage confirmationPage = checkOutPage.selectCountry("India");
		String confirmMesg = confirmationPage.getConfirmationMsg();
		Assert.assertTrue(confirmMesg.equalsIgnoreCase("Thankyou for the order."));
		driver.quit();
		
	}
}
