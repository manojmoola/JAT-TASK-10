package SeleniumTasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropDemo {
	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.get("https://jqueryui.com/droppable/");
		driver.manage().window().maximize();
		WebElement iframe=driver.findElement(By.className("demo-frame"));
		driver.switchTo().frame(iframe);
		WebElement Source = driver.findElement(By.id("draggable"));
		WebElement Target =driver.findElement(By.id("droppable"));
		Actions actions=new Actions(driver);
		actions.dragAndDrop(Source, Target).perform();
		String bgcolor = Target.getCssValue("background-color");
		System.out.println("Background-color = "+bgcolor);
		
		if(Target.getText().equals("Dropped!")) {
			System.out.println("Drag and drop successfull");
		}
		else {
			System.out.println("Drag and drop failed");
		}
		driver.quit();
		
	}

}
