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

        // STEP 1: Switch to the iframe first
        WebElement iframe = driver.findElement(By.className("demo-frame"));
        driver.switchTo().frame(iframe);

        // STEP 2: Open the date picker
        WebElement dateField = driver.findElement(By.id("datepicker"));
        dateField.click();

        Thread.sleep(1000); // small wait for calendar to be visible

        // STEP 3: Go to next month
        WebElement nextButton = driver.findElement(By.xpath("//a[@title='Next']"));
        nextButton.click();

        Thread.sleep(1000); // wait for next month to load

        // STEP 4: Select date "22"
        List<WebElement> allDates = driver.findElements(By.xpath("//a[@class='ui-state-default']"));
        for (WebElement date : allDates) {
            if (date.getText().equals("22")) {
                date.click();
                break;
            }
        }

        // STEP 5: Print selected date
        System.out.println("Selected Date: " + dateField.getAttribute("value"));

        driver.quit();
    }
}
