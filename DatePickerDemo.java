package SeleniumTasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class DatePickerDemo {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://jqueryui.com/datepicker/");
        WebElement iframe = driver.findElement(By.className("demo-frame"));
        driver.switchTo().frame(iframe);
        WebElement dateField = driver.findElement(By.id("datepicker"));
        dateField.click();
        Thread.sleep(1000);
        WebElement nextButton = driver.findElement(By.xpath("//a[@title='Next']"));
        nextButton.click();
        Thread.sleep(1000); 
        List<WebElement> allDates = driver.findElements(By.xpath("//a[@class='ui-state-default']"));
        for (WebElement date : allDates) {
            if (date.getText().equals("22")) {
                date.click();
                break;
            }
        }
        System.out.println("Selected Date: " + dateField.getAttribute("value"));
        driver.quit();
    }
}
