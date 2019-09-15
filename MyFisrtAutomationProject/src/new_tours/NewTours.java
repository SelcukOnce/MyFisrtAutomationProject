package new_tours;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

/**
 * 
 * @author onces
 * id
* name
* className
* sccSelector
* tagName
* linkText
* partialLinkText
* xpath

@here selenium locators
 */
public class NewTours {
	
	/**
	 * 
	 * @param args
	 * @throws InterruptedException 
	 * 
	 */

	public static void main(String[] args) throws InterruptedException {
Scanner scanner = new Scanner (System.in);
		
		System.out.print("Please enter your first name: ");
		String fName = scanner.nextLine();
		System.out.print("Please enter your last name: ");
		String lName = scanner.nextLine();
		System.out.print("Please enter your phone number: ");
		String phone = scanner.nextLine();
		String email = generateEmail(fName, lName);
		System.out.print("Please enter your Address: ");
		String address1 = scanner.nextLine();
		System.out.print("Please enter your Adress 2: ");
		String address2 = scanner.nextLine();
		System.out.print("Please enter your City: ");
		String city = scanner.nextLine();
		System.out.print("Please enter your State: ");
		String state = scanner.nextLine();
		System.out.print("Please enter your Postal Code: ");
		String postalCode = scanner.nextLine();
		System.out.print("Please enter your Country: ");
		String country = scanner.nextLine();
		
		
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\onces\\Desktop\\Drivers\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		
		
		driver.get("http://newtours.demoaut.com/");
		
//		driver.findElement(By.name("userName")).sendKeys("mercury");
//		driver.findElement(By.name("password")).sendKeys("mercury");
//		driver.findElement(By.name("login")).click();
		
		driver.findElement(By.linkText("REGISTER")).click();
		driver.findElement(By.name("firstName")).sendKeys(fName);
		driver.findElement(By.name("lastName")).sendKeys(lName);
		driver.findElement(By.name("phone")).sendKeys(phone);
		driver.findElement(By.name("userName")).sendKeys(email);
		
		driver.findElement(By.name("address1")).sendKeys(address1);
		driver.findElement(By.name("address2")).sendKeys(address2);
		driver.findElement(By.name("city")).sendKeys(city);
		driver.findElement(By.name("state")).sendKeys(state);
		driver.findElement(By.name("postalCode")).sendKeys(postalCode);
		WebElement countryDropDown =driver.findElement(By.name("country"));
		
		
		Select select = new Select(countryDropDown);
		select.selectByVisibleText(country.toUpperCase());
		
		String userName = generateUserName(fName, lName);
		 
		driver.findElement(By.name("email")).sendKeys(userName);
		
		String password = generatePassword(fName, lName);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.name("confirmPassword")).sendKeys(password);
		driver.findElement(By.name("register")).click();

	
		Thread.sleep(2000);
		String actualConfirmationText = driver.findElement(By.tagName("b")).getText();
		String expectedConfText = "Dear " + fName + " " + lName + ",";
		
		if (actualConfirmationText.equals(expectedConfText)) {
			//if (actualConfirmationText == expectedConfText) {
			System.out.println("You are registered at Mercury");
			}else {
				System.out.println("Sorry, something went wrong!!!");
			}
		
		String actualConfirmationText2 = driver.findElement(By.xpath("(//b)[2]")).getText();
		String expectedConfText2 = "Note: Your user name is " + userName + ".";
		
		if (actualConfirmationText2.equals(expectedConfText2)) {
			//if (actualConfirmationText2 == expectedConfText2) {
			System.out.println("You are registered at Mercury");
			}else {
				System.out.println("Sorry, something went wrong!!!");
			}
			Thread.sleep(2000);
		
		
		
		
		
		
	//	chromeDriver.quit();
		
	}
		private static String generateEmail( String fname, String lname) {
			
			StringBuilder stringBuilder = new StringBuilder();
			stringBuilder.append(fname).append(".").append(lname).append("@gmail.com");
			
			return stringBuilder.toString();
			
		}
	
		private static String generateUserName( String fname, String lname) {
			
			StringBuilder stringBuilder = new StringBuilder();
			stringBuilder.append(fname).append(".").append(lname);			
			return stringBuilder.toString().toLowerCase();
}
		
private static String generatePassword( String fname, String lname) {
			
			StringBuilder stringBuilder = new StringBuilder();
			stringBuilder.append(fname).append(".").append(lname).append(123);
			
			return stringBuilder.toString().toLowerCase();
}

}
