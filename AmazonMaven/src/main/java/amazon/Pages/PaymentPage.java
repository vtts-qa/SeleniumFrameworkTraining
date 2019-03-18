package amazon.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import amazon.AmazonBase;

public class PaymentPage extends AmazonBase {

	public static WebElement ccNameField() {
		
		WebElement ccNameField = (new WebDriverWait(driver, 3))
				   .until(ExpectedConditions.elementToBeClickable(By.id("ccName")));
		return ccNameField;
	}
	
		
	public static WebElement ccNumberField() {
		
		WebElement ccNumberField = (new WebDriverWait(driver, 3))
				   .until(ExpectedConditions.elementToBeClickable(By.id("addCreditCardNumber")));
		return ccNumberField;
	}
	
	public static WebElement ccValidMListButton(String Default01) {
		
		WebElement ccValidMListButton = driver.findElements(By.className("a-dropdown-prompt"))
				.stream().filter(e -> e.getText().equals(Default01)).findFirst().get();
		return ccValidMListButton; 
	}
	
	public static WebElement ccValidMListItem(String MM) {
		
		String M = MM.substring(MM.length() - 1); 
		WebElement ccValidMListItem = driver.findElement(By.cssSelector("[data-value=\"" + M + "\"]"));

		return ccValidMListItem; 
	}
	
	public static WebElement ccValidYListButton(String Default2019) {
		
		WebElement ccValidYListButton = driver.findElements(By.className("a-dropdown-prompt"))
				.stream().filter(e -> e.getText().equals(Default2019)).findFirst().get();
		return ccValidYListButton; 
	}
	
	public static WebElement ccValidYListItem(String YYYY) {
		
		WebElement ccValidYListItem = driver.findElement(By.cssSelector("[data-value=\"" + YYYY + "\"]"));

		return ccValidYListItem; 
	}
	
	
//	public static void SelectCcValidM(String ccM_m) {
//		
//		logger.debug("adding credit card valid month");
//		driver.findElements(By.className("a-dropdown-prompt")).stream().filter(e -> e.getText().equals("01")).findFirst().get().click();
//		driver.findElement(By.cssSelector("[data-value=\"" + ccM_m + "\"]")).click();
//	}
	
	
//	public static void SelectCcValidY(String ccY_yyyy) {
//		
//		logger.debug("openning credit card valid year dropdown in 2019");
//		driver.findElements(By.className("a-dropdown-prompt")).stream().filter(e -> e.getText().equals("2019")).findFirst().get().click();
////BUG:	Should send This.Year, so it would not fail on 2020		
//		logger.debug("selecting credit card valid year");
//		driver.findElement(By.cssSelector("[data-value=\"" + ccY_yyyy + "\"]")).click();
////BUG:	sometimes this happens: no such element: Unable to locate element: {"method":"css selector","selector":"[data-value="2023"]"}
//
//	}	
}
