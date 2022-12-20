package org.base;

import java.awt.AWTException;
import java.awt.List;
import java.awt.Robot;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;
	public static WebDriver chromeBrowser() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		 return driver;
		 
	}

	public static WebDriver edgeBrowser() {
	WebDriverManager.edgedriver().setup();
	  return driver=new EdgeDriver();
	  }
	
	
	public static void urlLaunch(String url){
		driver.get(url);
		driver.manage().window().maximize();
		
	}
	
	public static void implicitlyWait(long a, TimeUnit b) {
		driver.manage().timeouts().implicitlyWait(a, b);
	}
	
	public static void sendkeys(WebElement e,String value) {
		e.sendKeys(value);
		

	}
	
	public static void click(WebElement e) {
		e.click();
		}
	
	public static String getCurrentUrl() {
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;

	}
	
	public static String getTitle() {
		String title = driver.getTitle();
		return title;
		
		}
	
	public static void close() {
		driver.close();

	}
	
	public static String getAttribute(WebElement e) {
		 String attribute = e.getAttribute("value");
		return attribute;
	}
	
	public static void quit() {
		driver.quit();
	}
		
	
	
	public static String getText(WebElement e){
		String text = e.getText();
		return text;
		}
	
	
	
	public static void moveToElement(WebElement e) {
		Actions a=new Actions(driver);
		a.moveToElement(e).perform();

	}
	
	public static void dragAndDrop(WebElement src, WebElement tar) {
		Actions a=new Actions(driver);
		a.dragAndDrop(src, tar);
		
	}
	
	public static void contextClick() {
	  Actions a=new Actions(driver);
	  a.contextClick();

	}
	
	public static void doubleClick() {
		Actions a=new Actions(driver);
		a.doubleClick();

	}
	
	public static void keyRelease(int e) throws AWTException {
		Robot r=new Robot();
		r.keyRelease(e);
		}
	
	
	public static void keyPress(int e) throws AWTException {
		Robot r=new Robot();
		r.keyPress(e);

	}
	
	public static void accept() {
		
		Alert a=driver.switchTo().alert();
		a.accept();
		
	}
	public static void disMiss() {
		Alert a=driver.switchTo().alert();
		a.dismiss();
		
	}
	
	public static  void selectByIndex(WebElement e, int a) {
		Select s=new Select(e);
		s.selectByIndex(a);
		
	}
	
	public static void selectByValue(WebElement e,String x) {
		Select s=new Select(e);
		s.selectByValue(x);
		
	}
	
	public static void selectByVisibleText(WebElement e,String x) {
		Select s=new Select(e);
		s.selectByVisibleText(x);
		
	}
	
	public static void getOptions(WebElement e) {
		Select s=new Select(e);
		s.getOptions();
		}
		
	
	public static Object ScreenShot(WebElement e) {
		TakesScreenshot ts=(TakesScreenshot)driver;
		Object screenshotAs = ts.getScreenshotAs((OutputType) e);
		return screenshotAs;
	}

	
	public static void windowHandle() {
		String parentId = driver.getWindowHandle();

	}
	
	public static String allWindowHandles() {
		Set<String> allWindowId = driver.getWindowHandles();
		ArrayList<String> li = new ArrayList<String>(allWindowId);
		driver.switchTo().window(li.get(1));
		return null;
	}
		
		
	public static void navigateTo(String url) {
		driver.navigate().to(url);
	}
		
	public static void Sleep(long a) throws InterruptedException {
		Thread.sleep(a);
	}
	
	public static String readExcel(String filename,String Sheet,int row, int c) throws IOException {
		File f=new File("C:\\Users\\Puvitha\\eclipse-workspace\\Maven_Project_Nov10\\src\\test\\resources\\Excel\\"+filename+".xlsx");
		FileInputStream fs=new FileInputStream(f);
		Workbook w=new XSSFWorkbook(fs);
		Sheet s = w.getSheet(Sheet);
		Row r = s.getRow(row);
		Cell cell = r.getCell(c);
		int type = cell.getCellType();
		String value=null;
	
		if(type==1) {
			   value = cell.getStringCellValue();
			  
			  
		  }
		  else {
			  if(DateUtil.isCellDateFormatted(cell)) {
				  Date datecellvalue = cell.getDateCellValue();
				  SimpleDateFormat sd=new SimpleDateFormat();
				   value = sd.format(datecellvalue);
				 
			  }
			  
			  else {
				  double numericCellValue = cell.getNumericCellValue();
				  long num=(long)numericCellValue;
				   value = String.valueOf(num);  
			  }
	}
		return value;
}
	
}



	



	
	
	
	

	


