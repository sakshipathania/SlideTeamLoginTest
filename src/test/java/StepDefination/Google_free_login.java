package StepDefination;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import Setupclass.BaseClass;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;

public class Google_free_login extends BaseClass {

	@Given("User is home pageiiv$")
	public void user_is_home_pageiiv() throws Throwable {
		BaseClass.ClearGoggleCache();
		BaseClass.ClearBrowserCache();
		driver.get(AppURL);
		log.info("It's opening the website URL");
		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(4000, TimeUnit.MILLISECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		BaseClass.ClearBrowserCache();
	}

	@Then("user click on the Free PPts under free stuffiiv$")
	public void user_click_on_the_free_p_pts_under_free_stuffiiv() {
		try {
			WebElement free_Stuff = wait.until(ExpectedConditions.elementToBeClickable(
					By.xpath("//li[@class='menu-item has-sub-class']//a[@title = 'Free Stuff']")));
			Actions action = new Actions(driver);
			action.moveToElement(free_Stuff).perform();
			WebElement free_ppt = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title='Free Samples']")));
			action.moveToElement(free_ppt).click().perform();
		} catch (NoSuchElementException e) {

		}

	}

	@Then("User try to download the free pptsiiv$")
	public void user_try_to_download_the_free_pptsiiv() throws Throwable {

		try {
			Thread.sleep(2000);
			WebElement select_ppt = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title='Diverging Process Arrow Chart 4 Steps Cycle Diagram Free PowerPoint Templates']")));
			Thread.sleep(2000);
			js.executeScript("arguments[0].scrollIntoView();", select_ppt);
			select_ppt.click();
			WebElement download_ppt = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='clicking']")));
			js.executeScript("arguments[0].scrollIntoView();", download_ppt);
			download_ppt.click();
			Thread.sleep(3000);
		} catch (NoSuchElementException e) {

		}
	}

	@Then("user is on home page page and click on google buttoniiv$")
	public void user_is_on_home_page_page_and_click_on_google_buttoniiv() throws Throwable {
		// Click on Sign in with Google Account
		//Thread.sleep(3000);
		WebElement Sign_in_with_google = wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Sign in with Google')]")));
		Thread.sleep(2000);
		Sign_in_with_google.click();
	}

	@Then("user Enters the free username and passwordiiv$")
	public void user_Enters_the_free_username_and_passwordiiv() throws Throwable {
		try {

			if (!driver.findElements(By.xpath("//div[@class='BHzsHc']")).isEmpty()) {
				WebElement another_btn = BaseClass.elementToBeClickable(By.xpath("//div[text()='Use another account']"));
				another_btn.click();
			}

			WebElement gmail_email = BaseClass.elementToBeClickable(By.xpath("//*[@id='identifierId']"));
			gmail_email.sendKeys("parul.pahwa@slidetech.in");
			WebElement next_1 = driver.findElement(By.cssSelector("#identifierNext > div > button > span"));
			next_1.click();
			
			
			Thread.sleep(2000);
			WebElement gmail_pass = wait.until(ExpectedConditions
					.elementToBeClickable(By.cssSelector("#password > div.aCsJod.oJeWuf > div > div.Xb9hP > input")));
			gmail_pass.sendKeys("parulpahwa@11");

			WebElement next_2 = driver.findElement(By.cssSelector("#passwordNext > div > button > span"));
			next_2.click();
			Thread.sleep(4000);
		} catch (NoSuchElementException e) {

		}
	}

	@Then("user downloads the free PPTiiv$")
	public void user_downloads_the_free_pptiiv() throws Throwable {
		try {
			//driver.get("https://www.slideteam.net/free-download-diverging-process-arrow-chart-4-steps-cycle-diagram-powerpoint-slides.html");
			WebElement download_ppt = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='clicking']")));
			js.executeScript("arguments[0].scrollIntoView();", download_ppt);
			download_ppt.click();
			Thread.sleep(2000);
			if (!driver.findElements(By.xpath("//a[@class='mfp-close roundlink']")).isEmpty()) {
				WebElement close_popup = wait
						.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='mfp-close roundlink']")));

				close_popup.click();
			}
		} catch (NoSuchElementException e) {

		}
	}

	@Then("user clicks on the Logout pageiiv$")
	public void user_clicks_on_the_logout_pageiiv() throws Throwable {
		try {
			Thread.sleep(3000);
			WebElement sign_Out = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Sign Out")));
			sign_Out.click();
		} catch (NoSuchElementException e) {

		}
	}

	@Then("verify the messageiiv$")
	public void verify_the_messageiiv() throws Throwable {
		// verify the page after logout the application
		Thread.sleep(3000);
		String verifySignOutMessage = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//h3[@class='base']"))).getText();

		System.out.print("logout= " + verifySignOutMessage);
		
		Assert.assertTrue("user is not logout from the application",
				verifySignOutMessage.contains(verifySignOutMessage));

		
	
		
	}
}
