package test;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNG extends ProjectSpecific {
	@BeforeTest
	public void excel() {
		excelfilename="ExcelAuto";
	}

	@Test(dataProvider="sendData")
	public void AddToCart(String User, String password, String fname, String sname, String pincode) throws InterruptedException  {

		driver.findElement(By.id("user-name")).sendKeys(User);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("login-button")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		Thread.sleep(500);
		driver.findElement(By.xpath("//button[contains(@id,'bike-light')]")).click();
		System.out.println("Added bike light added to cart");	
		driver.findElement(By.xpath("//button[contains(@id,'add-to-cart-sauce-labs-bolt-t-shirt')]")).click();
		System.out.println("T shirt added to cart");
		driver.findElement(By.xpath("//button[contains(@id,'add-to-cart-sauce-labs-backpack')]")).click();
		System.out.println("Backpack added to cart");
		driver.findElement(By.xpath("//div[@id='shopping_cart_container']")).click();
		String pageTitle=driver.findElement(By.xpath("//span[@class='title']")).getText();
		if(pageTitle.equals("Your Cart"))
		{
			System.out.println("Navigated to cart page successfully. Title checked");
		}
		driver.findElement(By.xpath("//button[contains(@id,'remove-sauce-labs-backpack')]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		WebElement Quantity=driver.findElement(By.xpath("//div[@id='shopping_cart_container']/a/span"));
		System.out.println("Total count before proceeding to payment is/are " + Quantity.getText() + " items");
		driver.findElement(By.id("checkout")).click();
		driver.findElement(By.name("firstName")).sendKeys(fname);
		Thread.sleep(1000);
		driver.findElement(By.name("lastName")).sendKeys(sname);
		driver.findElement(By.name("postalCode")).sendKeys(pincode);
		
		driver.findElement(By.id("continue")).click();
		driver.findElement(By.id("finish")).click();
		String status =driver.findElement(By.xpath("//span[@class='title']")).getText();
		System.out.println("Status of your order- "+ status);

	}
	


}
