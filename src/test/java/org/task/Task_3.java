package org.task;
//no i will update
//hi everyone
//new update
//yes yes
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task_3 {
	public static void main(String[] args) throws AWTException, InterruptedException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the choice:");
		int n = sc.nextInt();
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("https://www.google.co.in/");
		WebElement searchText = driver.findElement(By.name("q"));
		searchText.sendKeys("Iphone");
		List<WebElement> listOfItems = driver.findElements(By.xpath("//li[@class='sbct PZPZlf sbre']"));
		Robot r = new Robot();	
		for(int j=0;j<=n;j++) {
		       r.keyPress(KeyEvent.VK_DOWN);
		       r.keyRelease(KeyEvent.VK_DOWN);
		       Thread.sleep(1000);
		}
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		
		String title = driver.getTitle();
		
		String url = driver.getCurrentUrl();
		
		if(title.contentEquals("iphone 16 pro max - Google Search") && url.contains("q=iphone+16+pro+max&sca_esv")){
			System.out.println("redirect to the correct page");
		}
		else {
			System.out.println("Not redirected to the correct page");
		}	
		
	}
}
