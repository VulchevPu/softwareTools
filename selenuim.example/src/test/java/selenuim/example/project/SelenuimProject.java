package selenuim.example.project;

import java.util.logging.Logger;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

/**
 * Class performing automation tests using selenium 
 * over the http://automationpractice.com/index.php website
 * @author a.vulchev
 *
 */
public class SelenuimProject {
	
	private Logger myLogger = Logger.getLogger(getClass().getName());
	static WebDriver driver;
	
	/**
	 * Setting commons - chrome driver,coockies,site
	 */
	@BeforeClass
	public static void invokeBrowser() {
		 System.setProperty("webdriver.chrome.driver",
		            "C:\\Users\\Hack\\Desktop\\HAX\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("http://automationpractice.com/index.php");
	}
	
	/**
	 * Methods testing the title of the website
	 * @throws InterruptedException
	 */
	@Test
	public void testTitle() throws InterruptedException {
		String actualTitle = driver.getTitle();
		String expectedTitle = "My Store";
		Thread.sleep(5000);
		Assert.assertEquals(actualTitle, expectedTitle);
		myLogger.info("<<<<< Title test SUCCESS >>>>>");
	}
	
	/**
	 * Method testing the searchbox present on the page
	 * and performing asserts over recieved data
	 * @throws InterruptedException
	 */
	@Test
	public void testSearchBox() throws InterruptedException {
		WebElement searchBox = driver.findElement(By.xpath("//*[@id=\"search_query_top\"]"));
		String searchCriteria = "Black dress";
		searchBox.sendKeys(searchCriteria);
		WebElement searchButton = driver.findElement(By.xpath("//*[@id=\"searchbox\"]/button"));
		searchButton.click();
		WebElement pictureLink = driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[3]/div/div[1]/div/a[1]/img"));
		pictureLink.click();
		Thread.sleep(5000);
		boolean textIsPresent = driver.getPageSource().contains("Short sleeved blouse with feminine draped sleeve detail.");
		Assert.assertTrue(textIsPresent);
		myLogger.info("<<<<< Searchbox test SUCCESS >>>>>");
	}
	
	/**
	 * Method testing the registration form present on the page
	 * and performing asserts over recieved data
	 * @throws InterruptedException
	 */
	@Test
	public void testRegistration() throws InterruptedException {
		WebElement signInLink = driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a"));
		signInLink.click();
		WebElement emailInputBox = driver.findElement(By.xpath("//*[@id=\"email_create\"]"));
		String email = "seleniumTest@mail.bg";
		emailInputBox.sendKeys(email);
		WebElement registrationButton = driver.findElement(By.xpath("//*[@id=\"SubmitCreate\"]/span"));
		registrationButton.click();
		Thread.sleep(5000);
		WebElement gender = driver.findElement(By.xpath("//*[@id=\"account-creation_form\"]/div[1]/div[1]/div[1]/label"));
		gender.click();
		WebElement firstNameInputField = driver.findElement(By.xpath("//*[@id=\"customer_firstname\"]"));
		String firstName = "Selenium";
		firstNameInputField.sendKeys(firstName);
		Assert.assertNotEquals(firstNameInputField.getAttribute("value"), "Alex");
		WebElement lastNameInputField = driver.findElement(By.xpath("//*[@id=\"customer_lastname\"]"));
		String lastName = "Test";
		lastNameInputField.sendKeys(lastName);
		Assert.assertEquals(lastNameInputField.getAttribute("value"), "Test");
		WebElement emailInputField = driver.findElement(By.xpath("//*[@id=\"email\"]"));
		Assert.assertNotNull(emailInputField.getAttribute("value"));
		WebElement passwordInputField = driver.findElement(By.xpath("//*[@id=\"passwd\"]"));
		passwordInputField.sendKeys("12345678");
		Assert.assertEquals(passwordInputField.getAttribute("value").length(), 8);
		Select dayDropDown = new Select(driver.findElement(By.xpath("//*[@id=\"days\"]")));
		dayDropDown.selectByValue("19");
		Select monthDropDown = new Select(driver.findElement(By.xpath("//*[@id=\"months\"]")));
		monthDropDown.selectByValue("5");
		Select yearDropDown = new Select(driver.findElement(By.xpath("//*[@id=\"years\"]")));
		yearDropDown.selectByValue("1994");
		WebElement newsLetterLabel = driver.findElement(By.xpath("//*[@id=\"account-creation_form\"]/div[1]/div[7]/label"));
		newsLetterLabel.click();
		WebElement newsLetterCheckbox = driver.findElement(By.xpath("//*[@id=\"newsletter\"]"));
		Assert.assertTrue(newsLetterCheckbox.isSelected());
		WebElement addressInfofirstNameInputField = driver.findElement(By.xpath("//*[@id=\"firstname\"]"));
		addressInfofirstNameInputField.sendKeys(firstName);
		WebElement addressInfolastNameInputField = driver.findElement(By.xpath("//*[@id=\"lastname\"]"));
		addressInfolastNameInputField.sendKeys(lastName);
		WebElement addressInfoInputField = driver.findElement(By.xpath("//*[@id=\"address1\"]"));
		addressInfoInputField.sendKeys("Test street 21");
		WebElement addressCityInputField = driver.findElement(By.xpath("//*[@id=\"city\"]"));
		addressCityInputField.sendKeys("Plovdiv");
		Select stateDropDown = new Select(driver.findElement(By.xpath("//*[@id=\"id_state\"]")));
		stateDropDown.selectByValue("1");
		WebElement addressPostalCodeInputField = driver.findElement(By.xpath("//*[@id=\"postcode\"]"));
		addressPostalCodeInputField.sendKeys("36016");
		WebElement addressTextAreaInputField = driver.findElement(By.xpath("//*[@id=\"other\"]"));
		Assert.assertTrue(addressTextAreaInputField.getAttribute("value").isEmpty());
		WebElement addressMobilePhoneInputField = driver.findElement(By.xpath("//*[@id=\"phone_mobile\"]"));
		addressMobilePhoneInputField.sendKeys("35955691255");
		WebElement addressEmailInputField = driver.findElement(By.xpath("//*[@id=\"alias\"]"));
		addressEmailInputField.sendKeys("SeliTesti");
		WebElement registerButtonAfterForm = driver.findElement(By.xpath("//*[@id=\"submitAccount\"]/span"));
		registerButtonAfterForm.click();
		Thread.sleep(5000);
		myLogger.info("<<<<< Registration test SUCCESS >>>>>");
	}
	
	/**
	 * Method testing the sign in after account creation
	 * and creating a wish list
	 * and performing asserts over recieved data
	 * @throws InterruptedException
	 */
	@Test
	public void testSignInAndCreateWishList() throws InterruptedException {
		WebElement signInLink = driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a"));
		signInLink.click();
		WebElement signInEmailInputField = driver.findElement(By.xpath("//*[@id=\"email\"]"));
		signInEmailInputField.sendKeys("seleniumTest@mail.bg");
		WebElement signInPasswordInputField = driver.findElement(By.xpath("//*[@id=\"passwd\"]"));
		signInPasswordInputField.sendKeys("12345678");
		WebElement signInButton = driver.findElement(By.xpath("//*[@id=\"SubmitLogin\"]/span"));
		Assert.assertTrue(signInButton.isDisplayed());
		signInButton.click();
		Thread.sleep(5000);
		boolean textIsPresent = driver.getPageSource().contains("Welcome to your account. Here you can manage all of your personal information and orders.");
		Assert.assertTrue(textIsPresent);
		WebElement wishListSpan = driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/div[2]/ul/li/a/span"));
		wishListSpan.click();
		WebElement wishListInputField = driver.findElement(By.xpath("//*[@id=\"name\"]"));
		wishListInputField.sendKeys("Pure Awesomeness");
		WebElement saveButton = driver.findElement(By.xpath("//*[@id=\"submitWishlist\"]/span"));
		saveButton.click();
		Thread.sleep(5000);
		Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"block-history\"]/table")).isDisplayed());
		Assert.assertTrue(driver.getPageSource().contains("Pure Awesomeness"));
		myLogger.info("<<<<< SignInAndCreateWishList test SUCCESS >>>>>");
	}
	
	/**
	 * Method testing the functionality add to cart and delete from
	 * cart after present and performing asserts over recieved data
	 * @throws InterruptedException
	 */
	@Test
	public void testAddTshirtToCartAndDeleteAfter() throws InterruptedException {
		WebElement signInLink = driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a"));
		signInLink.click();
		WebElement signInEmailInputField = driver.findElement(By.xpath("//*[@id=\"email\"]"));
		signInEmailInputField.sendKeys("seleniumTest@mail.bg");
		WebElement signInPasswordInputField = driver.findElement(By.xpath("//*[@id=\"passwd\"]"));
		signInPasswordInputField.sendKeys("12345678");
		WebElement signInButton = driver.findElement(By.xpath("//*[@id=\"SubmitLogin\"]/span"));
		Assert.assertTrue(signInButton.isDisplayed());
		signInButton.click();
		Thread.sleep(2000);
		WebElement dressTab = driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]/a"));
		dressTab.click();
		WebElement styleCheckbox = driver.findElement(By.xpath("//*[@id=\"layered_id_feature_13\"]"));
		styleCheckbox.click();
		Thread.sleep(3000);
		WebElement propertiesCheckbox = driver.findElement(By.xpath("//*[@id=\"layered_id_feature_20\"]"));
		propertiesCheckbox.click();
		Thread.sleep(3000);
		WebElement viewAsList = driver.findElement(By.xpath("//*[@id=\"list\"]/a/i"));
		viewAsList.click();
		WebElement pickedDressAddToCartButton = driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li/div/div/div[3]/div/div[2]/a[1]/span"));
		pickedDressAddToCartButton.click();
		Thread.sleep(2000);
		WebElement proceedToCheckoutButton = driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a/span"));
		proceedToCheckoutButton.click();
		Assert.assertTrue(driver.getPageSource().contains("Printed Chiffon Dress"));
		WebElement deleteButton = driver.findElement(By.xpath("//*[@id=\"7_34_0_146259\"]"));
		deleteButton.click();
		Thread.sleep(2000);
		Assert.assertFalse(driver.getPageSource().contains("Printed Chiffon Dress"));
		myLogger.info("<<<<< AddTshirtToCartAndDeleteAfter test SUCCESS >>>>>");
	}
	
	/**
	 * Method closing the Chrome driver
	 */
	@AfterClass
	public static void closeBrowser() {
		driver.quit();
	}

}
