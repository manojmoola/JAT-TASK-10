package SeleniumTasks;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Guvi {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.guvi.in/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//a[contains(text(),'Sign up')]")).click();
		driver.findElement(By.id("name")).sendKeys("manojkumarmula");
		driver.findElement(By.id("email")).sendKeys("manojmula9@gmail.com");
		driver.findElement(By.id("password")).sendKeys("Mula@878");
		driver.findElement(By.id("mobileNumber")).sendKeys("9182962269");
		WebElement SignUp=driver.findElement(By.id("signup-btn"));
		SignUp.click();
		 // Wait for either success message or error message after signup
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            // Example: Wait until dashboard link or profile element appears
            WebElement dashboard = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(),'Courses')]")));
            System.out.println("Signup completed successfully! User redirected to dashboard.");
        } catch (Exception e) {
            System.out.println("Signup failed or email may already exist.");
        }
        Thread.sleep(2000);
		driver.get("https://www.guvi.in/");
		driver.findElement(By.id("login-btn")).click();
		driver.findElement(By.id("email")).sendKeys("manojmula9@gmail.com");
		driver.findElement(By.id("password")).sendKeys("Mula@878");
		driver.findElement(By.id("login-btn")).click();
		Thread.sleep(2000);
		 String titleAfterLogin = driver.getTitle();
	        System.out.println("Title after Login: " + titleAfterLogin);

	        if (titleAfterLogin.contains("GUVI")) {
	            System.out.println("Login Successful!");
	        } else {
	            System.out.println("Login Failed!");
	        }

	       driver.quit();
		

	}

}
