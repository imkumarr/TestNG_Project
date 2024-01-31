package com.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.excelData.Excel_read;
public class TestNg {
	WebDriver driver;
	
	//WebDriverWait wait = new WebDriverWait(driver, 10);
	
	
	@BeforeMethod
	public void setUp() {
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\eclipse-workspace\\TestNG_Project\\target\\WebDriver\\chromedriver.exe");
	 this.driver = new ChromeDriver();
	driver.manage().window().maximize();
   // driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	driver.get("http://www.isiri.co/hrm/"); 
	driver.findElement(By.id("txtUsername")).sendKeys("kumar");
	driver.findElement(By.id("txtPassword")).sendKeys("iSiriTech!23");
	driver.findElement(By.id("btnLogin")).click();
	driver.findElement(By.id("menu_pim_viewPimModule")).click();	
	driver.findElement(By.id("menu_pim_addEmployee")).click();
	
	}
	
	
    @Test(dataProvider = "excelData", dataProviderClass = Excel_read.class)
    public void yourTestMethod(String fistName, String middleName, String lastName, String EmpId,
            String ph, String Otherid, String DLic, String MStu, String National) {
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement F1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("firstName")));
		
		F1.sendKeys(fistName);
		WebElement M2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("middleName")));
		
		M2.sendKeys(middleName);
		
		driver.findElement(By.name("lastName")).sendKeys(lastName);
		driver.findElement(By.name("employeeId")).clear();
		driver.findElement(By.name("employeeId")).sendKeys(EmpId);
		driver.findElement(By.xpath("//input[@id='photofile']")).sendKeys(ph);

		
		driver.findElement(By.id("btnSave")).click();
		
		
		driver.findElement(By.id("menu_pim_viewPimModule")).click();
		driver.findElement(By.id("empsearch_id")).clear();
		driver.findElement(By.id("empsearch_id")).sendKeys(EmpId);
		driver.findElement(By.name("_search")).click();

		driver.findElement(By.linkText(EmpId)).click();
		
		driver.findElement(By.id("btnSave")).click();
		
		
		
		
		driver.findElement(By.id("personal_txtOtherID")).sendKeys(Otherid);
		driver.findElement(By.name("personal[txtLicenNo]")).sendKeys(DLic);
		WebElement ExpLicdate = driver.findElement(By.name("personal[txtLicExpDate]"));
		ExpLicdate.clear();
		ExpLicdate.sendKeys("12-11-2024");
		ExpLicdate.click();
		
//		List<WebElement> radio=driver.findElements(By.xpath("//body/div[@id='wrapper']/div[@id='content']/div[@id='employee-details']/div[@id='pdMainContainer']/div[2]/form[1]/fieldset[1]/ol[3]/li[1]/ul[1]"));
//		for(int i=0;i<radio.size();i++) {
//			
//			WebElement local_radio= radio.get(i);
//			
//			String value=local_radio.getAttribute("id");
//			
//			if(value.equalsIgnoreCase("Female")) {
//				local_radio.click();
//			}
//		}
		
		
		WebElement w = driver.findElement(By.id("personal_cmbMarital"));
		Select select=new Select(w);
		select.selectByVisibleText(MStu);
		
		//driver.findElement(By.xpath("//option[contains(text(),'Single')]")).click();
		
		
		WebElement w2 = driver.findElement(By.name("personal[cmbNation]"));
		Select sel=new Select(w2);
		sel.selectByVisibleText(National);
		
//		WebElement DateOfBirth = driver.findElement(By.id("personal_DOB"));
//		DateOfBirth.clear();
//		DateOfBirth.sendKeys("1999-08-14");
//		DateOfBirth.click();
		
//		WebElement ExpLicdate = driver.findElement(By.name("personal[txtLicExpDate]"));
//		ExpLicdate.clear();
//		ExpLicdate.sendKeys("2024-01-20");
//		ExpLicdate.click();
		

		
		
		driver.findElement(By.id("btnSave")).click();
		
		
		
		
		driver.findElement(By.id("menu_pim_viewPimModule")).click();
		WebElement search = driver.findElement(By.id("empsearch_id"));
		search.clear();
		search.sendKeys(EmpId);
		driver.findElement(By.name("_search")).click();
	
		driver.findElement(By.id("ohrmList_chkSelectAll")).click();

		
		
		 Set<String> parentHandle = driver.getWindowHandles();
		 driver.findElement(By.id("btnDelete")).click();
		 Set<String> handles = driver.getWindowHandles();
		 //String[] handles = null;
		for(String handle: handles) {
			if(!handle.equals(parentHandle)) {
				driver.switchTo().window(handle);
			
			 driver.findElement(By.id("dialogDeleteBtn")).click();
			
		 }
		}
		

	}	
	@AfterMethod
	public void tearDown() {
	    // Quit WebDriver if it's not null
	    if (this.driver != null) {
	        this.driver.quit();
	    }
	}
}
