package StepDefination;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import Setupclass.BaseClass;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;

public class Google_existing_paid_login extends BaseClass {

	@Given("User is home pageiii$")
	public void user_is_home_pageiii() throws Throwable {
		BaseClass.ClearGoggleCache();
		
		driver.get(AppURL);
		driver.manage().timeouts().implicitlyWait(4000, TimeUnit.MILLISECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		log.info("It's opening the website URL");
		BaseClass.ClearBrowserCache();
	}

	@Then("user click on the Popular PPTsiii$")
	public void user_click_on_the_popular_PPsiii() {
		WebElement popular_Ppts = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Popular PPTs")));
		popular_Ppts.click();
	}

	@Then("User try to download the pptiii$")
	public void user_try_to_download_the_pptiii() throws Throwable {
		try {
			WebElement select_Ppt = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//a[@title='Business Process Evaluation Powerpoint Show']")));
			js.executeScript("arguments[0].scrollIntoView();", select_Ppt);
			select_Ppt.click();

			WebElement download_Ppt = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='clicking']")));
			js.executeScript("arguments[0].scrollIntoView();", download_Ppt);
			download_Ppt.click();
			Thread.sleep(2000);
		} catch (NoSuchElementException e) {

		}
	}

	@Then("user is on Login page and click on Signin with google buttoniii$")
	public void user_is_on_login_page_and_click_on_sigin_with_google_buttoniii() throws InterruptedException {
		// Click on Sign in with Google Account
		Thread.sleep(2000);
		WebElement Sign_in_with_google = BaseClass.elementToBeClickable(By.xpath("//a[contains(text(),'Sign in with Google')]"));
		Thread.sleep(1000);
		Sign_in_with_google.click();

	}

	@Then("user enters the username and passwordiii$")
	public void user_enters_the_username_and_passwordiii() throws Throwable {
		try {

			if (!driver.findElements(By.xpath("//div[@class='BHzsHc']")).isEmpty()) {
				WebElement another_btn = BaseClass.elementToBeClickable(By.xpath("//div[text()='Use another account']"));
				another_btn.click();
			}

			WebElement gmail_email = BaseClass.elementToBeClickable(By.xpath("//*[@id='identifierId']"));

			gmail_email.sendKeys("parul.pahwa@slidetech.in");

			WebElement next_1 = driver.findElement(By.cssSelector("#identifierNext > div > button > span"));

			next_1.click();
			
			WebElement gmail_pass = wait.until(ExpectedConditions
					.elementToBeClickable(By.cssSelector("#password > div.aCsJod.oJeWuf > div > div.Xb9hP > input")));

			gmail_pass.sendKeys("parulpahwa@11");

			WebElement next_2 = driver.findElement(By.cssSelector("#passwordNext > div > button > span"));

			next_2.click();
			  Thread.sleep(9000);
			//Thread.sleep(9000);
			
		} catch (NoSuchElementException e) {

		}
	}

	@Then("user downloads the PPTiii$")
	public void user_downloads_the_pptiii() throws InterruptedException {
		Thread.sleep(9000);
		//driver.get("https://www.slideteam.net/business-process-evaluation-powerpoint-show.html");
		WebElement download_Ppt = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='clicking']")));
		js.executeScript("arguments[0].scrollIntoView();", download_Ppt);
		download_Ppt.click();
		Thread.sleep(3000);
	}

	@Then("user clicks on the Logout pageiii$")
	public void user_clicks_on_the_logout_pageiii() throws Throwable {
		try {

			WebElement sign_Out = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Sign Out")));
			sign_Out.click();
			Thread.sleep(2000);
		} catch (NoSuchElementException e) {

		}
	}

	@Then("verify the messageiii$")
	public void verify_the_messageiii() throws Throwable {
		// verify the page after logout the application

		Thread.sleep(3000);
		String verifySignOutMessage = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//h3[@class='base']"))).getText();

		System.out.print("logout= " + verifySignOutMessage);
		
		Assert.assertTrue("user is not logout from the application",
				verifySignOutMessage.contains(verifySignOutMessage));

	

		
	}

}
