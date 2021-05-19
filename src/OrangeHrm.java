import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class OrangeHrm {
    WebDriver driver;

    @Before
    public void browser() {

        String baseUrl = "https://opensource-demo.orangehrmlive.com/";
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get(baseUrl);
    }

    @Test
    public void verifyTextLohInPanel() {
        driver.findElement(By.xpath("//input[@name='txtUsername']")).sendKeys("Admin");
        driver.findElement(By.xpath("//input[@name='txtPassword']")).sendKeys("admin123");
        driver.findElement(By.xpath("//input[@name='Submit']")).click();
        driver.findElement(By.xpath("//a[@id='welcome']")).click();
        String expectErrorMessage = "Welcome Paul";

        WebElement errorMessage = driver.findElement(By.xpath("//a[@id='welcome']"));
        String actualErrorMessage = errorMessage.getText();//This is actual error message from web site
        Assert.assertEquals("Error message not display", expectErrorMessage, actualErrorMessage);
        driver.findElement(By.xpath("//a[@href='/index.php/auth/logout']")).click();

        String expectText = "LOGIN Panel";
        WebElement text = driver.findElement(By.xpath("//div[@id='logInPanelHeading']"));
        String actualText = text.getText();//This is actual error message from web site
        Assert.assertEquals("Error message not display",expectText , actualText);


    }

}
