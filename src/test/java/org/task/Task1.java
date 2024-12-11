package org.task;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.annotation.concurrent.ThreadSafe;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class Task1 {
	
	static List<WebElement> listOfProduct;
	
	public static void data(int row,int cell) throws IOException {
		File f = new File("E:\\Eclipse\\AllTask\\ExcelData\\Data.xlsx");
		Workbook w = new XSSFWorkbook();
		Sheet s = w.createSheet("Datas");
		Row r = s.createRow(row);
		Cell c = r.createCell(cell);
		c.setCellValue("mani");
		FileOutputStream fo = new FileOutputStream(f);
		w.write(fo);
	}
	
	public static void element(WebDriver driver) throws IOException {
	    for(int i=0,j=0;i<listOfProduct.size();i++) {
	    	String text = listOfProduct.get(i).getText();
	    	data(i,j);
	    }
	}
	
	public static void main(String[] args) throws InterruptedException, IOException {
		
		
		
		
		/*WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.flipkart.com/?s_kwcid=AL!739!3!582822043580!b!!g!!flipkart&gclsrc=aw.ds&&semcmpid=sem_8024046704_brand_exe_buyers_goog&gad_source=1&gclid=CjwKCAiA3Na5BhAZEiwAzrfagN_jrFdLs5HfZjMpvPhIkUsi08Uy8CI5se3DWRPOwVr0AH3o7ugA_BoCIxkQAvD_BwE");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		
		WebElement searchProduct = driver.findElement(By.xpath("//input[@type='text']"));
		
		searchProduct.sendKeys("Iphone",Keys.ENTER);   //1
		
		listOfProduct = driver.findElements(By.xpath("//div[contains(@class,'KzDlHZ')]"));
		
		int num = listOfProduct.size() + 5;
		
		int totalList = num - listOfProduct.size();
		
	    for(int i=1;i<=totalList;i++) {
	    	System.out.println("Page No:"+i);
	    	element(driver);
	    	driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click(); 
	    	Thread.sleep(1000);
	    	listOfProduct = driver.findElements(By.xpath("//div[contains(@class,'KzDlHZ')]"));
	    }
	    
	    
	    
	    
	    */
	    
	    
	
	
	
	}

}
