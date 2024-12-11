package org.task;

import java.awt.Desktop.Action;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
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
import org.openqa.selenium.interactions.Actions;

public class Task2 {
static List<WebElement> listOfProduct;
static List<String>l; 

static List<WebElement> listOfPrices ;
static List <String> p;

static List<String> sno ;

static Workbook w;
static File f;

static int m;

	public static void writeProductList(WebDriver driver) throws IOException {
		f = new File("E:\\Eclipse\\AllTask\\Excel\\Product.xlsx");
		w = new XSSFWorkbook();
		Sheet s = w.createSheet("nick");

		for(int i=0;i<m+1;i++) {
			Row r = s.createRow(i);
			for(int j=0;j<3;j++) {
				if(j==0) {
		           r.createCell(j).setCellValue(sno.get(i));
				}
				else if(j==1) {
					r.createCell(j).setCellValue(l.get(i));
				}
				else if(j==2) {
					r.createCell(j).setCellValue(p.get(i));
				}
		    }
		}
		
			
		}
	
	
	
public static void main(String[] args) throws InterruptedException, IOException {
	    
	   
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.flipkart.com/?s_kwcid=AL!739!3!582822043580!b!!g!!flipkart&gclsrc=aw.ds&&semcmpid=sem_8024046704_brand_exe_buyers_goog&gad_source=1&gclid=CjwKCAiA3Na5BhAZEiwAzrfagN_jrFdLs5HfZjMpvPhIkUsi08Uy8CI5se3DWRPOwVr0AH3o7ugA_BoCIxkQAvD_BwE");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		
		WebElement searchProduct = driver.findElement(By.xpath("//input[@type='text']"));
		
		searchProduct.sendKeys("Iphone",Keys.ENTER);   //1
		
		//products
		listOfProduct = driver.findElements(By.xpath("//div[contains(@class,'KzDlHZ')]"));
		l = new ArrayList<String>();
		for(int i=0;i<listOfProduct.size()+1;i++) {
			if(i==0) {
				l.add(i, "Products");
			}
			else{
				l.add(i, listOfProduct.get(i-1).getText());
				}
		}
		
		//price
	   listOfPrices = driver.findElements(By.xpath("//div[@class='Nx9bqj _4b5DiR']"));
	   p = new ArrayList<String>();
	   for(int j=0;j<listOfPrices.size()+1;j++) {
		if(j==0) {
			p.add(j,"Prices");
		}
		else {
			p.add(j,listOfPrices.get(j-1).getText());
		}
	}
	   
	   //serial no
	   sno = new ArrayList<String>();
	   for(int k=0;k<listOfPrices.size()+1;k++) {
		   if(k==0) {
			   sno.add("S.No");
		   }
		   else {
			   sno.add(k, String.valueOf(k));
		   }
	   }
	   
	   WebElement nextBtn = driver.findElement(By.xpath("//span[text()='Next']"));
	   int d=1;
	    for(int i=1;i<=5;i++) {
	    	m = d * listOfProduct.size();
	    	writeProductList(driver);
	    	Actions a = new Actions(driver);
	    	a.click(nextBtn).perform();
	    	Thread.sleep(1000);
	    	listOfPrices = driver.findElements(By.xpath("//div[@class='Nx9bqj _4b5DiR']"));
	    }
	    FileOutputStream fo = new FileOutputStream(f);
		w.write(fo);
	    
	  driver.quit() ;  

	}

}
