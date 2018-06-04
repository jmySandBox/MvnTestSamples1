package org.mvnSelenium;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

import java.util.List;
import java.util.Random;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TestRunner {

	private Chrome_Sample chrome = new Chrome_Sample();

	@Test
	public void chromeCalls() {
		assertThat(chrome.srchQuery(), containsString("Famous"));
		System.out.println("TEST GOAL: Searching for " + chrome.srchQuery() + " in " + chrome.URL());
	}

	@Test
	public void chromeLaunch() {
		System.setProperty("webdriver.chrome.driver", "D:\\Drivers\\chromedriver_win32\\chromedriver.exe");

		WebDriver web = new ChromeDriver();
		System.out.println("Launching Browser");

		web.get("http://google.com");
		System.out.println("Accessing Website");

		web.findElement(By.id("lst-ib")).sendKeys(chrome.srchQuery());
		System.out.println("Search String Entered");

		web.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[3]/center/input[1]")).click();
		System.out.println("Search Button Clicked");

		String title = chrome.srchQuery() + " - Google Search";
		if (web.getTitle().equals(title)) {
			System.out.println("Regex Successful");

			web.close();
			System.out.println("Closing Browser");
		}

	}

	@Test
	public void ddlCalls() {
		System.out.println("TEST GOAL: Select Random Value from DropDownList");

		System.setProperty("webdriver.chrome.driver", "D:\\Drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");

		// Select ddlSelect = new
		Select ddlSelect = new Select(driver.findElement(By.xpath("//*[@id=\"searchDropdownBox\"]")));

		// Get Count of all values in ddl
		int optionTot = ddlSelect.getOptions().size();

		// create list for all options available
		List<WebElement> ddlList = ddlSelect.getOptions();

		// Print all the values
		for (int i = 0; i < optionTot; i++) {
			System.out.println(ddlList.get(i).getText());
		}

		// Select Random Value
		Random rand = new Random();
		int randomElement = rand.nextInt(optionTot);
		if (randomElement >= 1 || randomElement < optionTot) {
			System.out.println("Selecting Index " + randomElement);
			ddlSelect.selectByIndex(randomElement);
		}
		driver.close();
	}
}
