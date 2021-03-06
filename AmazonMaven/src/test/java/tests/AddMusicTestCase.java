package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import amazon.AmazonBase;
import amazon.Pages.AddedPage;
import amazon.Pages.GlobalPage;
import amazon.Pages.ItemPage;
import amazon.Pages.SearchResultsPage;
import assets.CommonDataProviders;
import assets.Methods;

public class AddMusicTestCase extends AmazonBase {
	
	@BeforeClass
	public static void FindItem()
	{
		GlobalPage.Search("The Dark Side of the Moon");
		SearchResultsPage.OpenItemByImgUrl("https://m.media-amazon.com/images/I/61PEh3IyaeL._AC_UL436_.jpg");
	}
	

	@Test()
	public static void AddMp3ToCart() 
	{		
		ItemPage.selectItemType("MP3").click();
		ItemPage.addMp3ToCartButton().click();
		
		Methods.WaitInvisibility(ItemPage.addMp3ToCartButton());
		hardAssert.assertFalse(ItemPage.addMp3ToCartButton().isDisplayed());	
	}
		
		
	@Test(dataProvider = "musicProvider", dataProviderClass = CommonDataProviders.class)
	public static void AddToCart(String musicItemType) 
	{		
		ItemPage.selectItemType(musicItemType).click();
		ItemPage.addToCartButton().click();
		
		hardAssert.assertEquals(AddedPage.addedToCartMessage().getText(), "Added to Cart");
		
		AddedPage.GetBackToTheItem();
	}
	
	
	@Test(dataProvider = "musicProvider", dataProviderClass = CommonDataProviders.class) 
	public static void AddUsedToCart(String musicItemType)
	{
		ItemPage.selectByConditionType(musicItemType, "Used").click();
		ItemPage.addOldToCartButton().click();
		
		hardAssert.assertEquals(AddedPage.addedToCartMessage().getText(), "Added to Cart");
		
		AddedPage.GetBackToTheItem();
	}
}

