package TestNGPractice;

import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class ProjectSpecificMethods {
	public RemoteWebDriver driver;
	@Parameters({"url","browser"})
	@BeforeMethod
	public void openBrowser(String url, String browser) {
		switch(browser) {
		case "chrome":
			ChromeOptions options = new ChromeOptions();
	        options.addArguments("--remote-allow-origins=*");
	         driver = new ChromeDriver(options);
			
			break;
		case "edge":
			driver=new EdgeDriver();
			break;
			default:
				break;
		}
		//ChromeOptions options= new ChromeOptions();
		//options.addArguments("--remote-allow-origins");
		//driver=new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}
}