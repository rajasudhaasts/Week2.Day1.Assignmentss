package week3.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateLead {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		//driver.close();
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		WebElement logout = driver.findElement(By.className("decorativeSubmit"));
		String attribute = logout.getAttribute("value");
		System.out.println(attribute);
		if(attribute.equals("Logout"))
				{
				System.out.println("successfully logged in");
				}
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("Test Company");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Rajasudha");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("A");
		
		//First name (local)
		driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("LocalA");

		//Department
		driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("Java");

		//Description
		driver.findElement(By.id("createLeadForm_description")).sendKeys("Selenium Java Class");

		//Email
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("merciyal@gmail.com");

		//State/province
		WebElement State= driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
		Select select1=new Select(State);
		select1.selectByVisibleText("Alaska");
		
		driver.findElement(By.className("smallSubmit")).click();
		
		driver.findElement(By.linkText("Duplicate Lead")).click();{
		driver.findElement(By.id("createLeadForm_companyName")).clear();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("Test Company2");
		driver.findElement(By.id("createLeadForm_firstName")).clear();
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("RajasudhaA");
		driver.findElement(By.className("smallSubmit")).click();
			
		//Verify the view Lead Page Title
		String title = driver.getTitle();
		if(title.contains("View Lead")) {
			System.out.println("View Lead Page");
			
	}

	}
}


	}


