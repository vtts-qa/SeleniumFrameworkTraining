package amazon.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import amazon.AmazonBase;
import assets.Methods;

public class AddedPage extends AmazonBase{
	
	
	public static WebElement proceedCheckoutButton() {
		
		WebElement proceedCheckoutButton = driver.findElement(By.id("hlb-ptc-btn-native"));
		return proceedCheckoutButton;
	}
	
	
	public static WebElement addedToCartMessage() {
		
		logger.debug("getting added to cart message");
		
		WebElement addedToCartMessage = (new WebDriverWait(driver, 3))
				   .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#huc-v2-order-row-confirm-text > h1")));
		return addedToCartMessage;
	}
	

	public static void GetBackToTheItem() {
		
		WebElement hoverItem = driver.findElement(By.className("huc-v2-table-col"));
		Methods.Hover(hoverItem);

		logger.debug("getting back to the item page");
		WebDriverWait wait = new WebDriverWait(driver, 3);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("mdp-title")));
		driver.findElement(By.className("sc-product-image")).click();
	}
	
	
}


