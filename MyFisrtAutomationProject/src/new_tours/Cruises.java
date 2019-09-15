package new_tours;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import chromeDriver.Driver;

public class Cruises {

	public static void main(String[] args) {
		
		
		ChromeDriver driver = Driver.getChromeDriver();
		
		
		driver.get("http://newtours.demoaut.com/");
		
        sleep(2);
        
        driver.findElement(By.xpath("(//a)[5]")).click();
        
        sleep(3);
        
        String actualTitle = driver.getTitle();
        String actualURL = driver.getCurrentUrl();
        
        if ( actualTitle.equals("Cruises: Mercury Tours") ) {
            System.out.println("Title check: pass");
        } else {
            System.out.println("Title check: fail");
        }
        
        if ( actualURL.contains("http://newtours.demoaut.com/mercurycruise.php") ) {
            System.out.println("URL check: pass");
        } else {
            System.out.println("URL check: fail! Actual URL: " + actualURL);
        }
        
        sleep(5);
        driver.quit();
    }
    
    public static void sleep ( int seconds ) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

	}


