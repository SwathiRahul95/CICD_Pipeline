package test;

import java.io.IOException;
import java.io.Reader;
import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

public class ProjectSpecific {
	ChromeDriver driver = new ChromeDriver();
	public String excelfilename;

	@Parameters({"url"})
	@BeforeMethod
	public void LaunchBrowser(String url) {
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		System.out.println("Logged in successfully");
	}
	
	@AfterMethod
	public void closeBroser() {
		driver.quit();
	}
	@DataProvider
	public String[][] sendData() throws IOException {
		String[][] data = ReadExcelData.getData(excelfilename);
return data;	
}
}
