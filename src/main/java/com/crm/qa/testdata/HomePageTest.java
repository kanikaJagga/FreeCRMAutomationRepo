package com.crm.qa.testdata;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;

	public HomePageTest()
	{
		super();
	}
		
	@BeforeMethod
	public void setup() throws InterruptedException {
		initialization();
		loginPage=new LoginPage();
		testUtil=new TestUtil();
		contactsPage=new ContactsPage();
		testUtil.handleLoginPageChatModal();
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
		}

	@Test(priority=1)
	public void verifyHomePagetitleTest() {
		String homePageTitle=homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "CRMPRO","Home Page title not matched");
	}
	
	@Test(priority=2)
	public void verifyUserNameTest() {
		testUtil.switchToFrame();
		boolean flag=homePage.verifyCorrectUsername();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void clickContactsPageLinkTest() {
		testUtil.switchToFrame();
		contactsPage=homePage.clickOnContactsLink();
	}
	
	
	
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
