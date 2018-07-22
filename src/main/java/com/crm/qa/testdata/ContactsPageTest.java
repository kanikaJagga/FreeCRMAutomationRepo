package com.crm.qa.testdata;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	String sheetName ="contacts";
	
	public ContactsPageTest()
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
		testUtil.switchToFrame();
		homePage.clickOnContactsLink();
		}
	
	
	@Test(priority=1)
	public void verifyContactsPageLabelTest() {
		
		Assert.assertTrue(contactsPage.verifyContactsLabel(),"Contacts label is missing on the page");
		
	}
	
	/*@Test(priority=2)
	 * public void selectSingleContactsTest(){
	 * }
	 */
	
	/*@Test(priority=3)
	 * public void selectMultipleContactsTest(){
	 * }
	 */
	
	@DataProvider
	public Object[][] getCRMTestData() {
		Object data[][]=testUtil.getTestData(sheetName);
		return data;
	}
	
	
	
	@Test(dataProvider="getCRMTestData")
	public void validateCreateNewContact(String title,String firstName,String lastName,String companyName) throws InterruptedException {
		homePage.clickOnNewContactLink();
		Thread.sleep(5000);
		//contactsPage.createNewContact("Mr.", "kanika", "jagga", "ABCCompany");
		contactsPage.createNewContact(title, firstName,lastName , companyName);
	}
	
	
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
