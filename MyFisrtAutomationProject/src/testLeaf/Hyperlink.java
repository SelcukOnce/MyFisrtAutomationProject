package testLeaf;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import chromeDriver.Driver;
import common.Common;

public class Hyperlink {

	public static void main(String[] args) {
        WebDriver driver = Driver.getDriver("chrome");
        driver.get("http://testleaf.herokuapp.com/pages/Link.html");
        
        Common.sleep(2);
        driver.findElement(By.xpath("(//a[text()='Go to Home Page'])[2]")).click();
        
        Common.sleep(3);
        driver.quit();
    }

}
