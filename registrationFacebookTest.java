package Clase2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class registrationFacebookTest {
    public static WebDriver getFacebookDriver(){
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.facebook.com/");
        return driver;
    }

    @Test
    public static void fullRegistrationTest()  throws InterruptedException{
        WebDriver driver = getFacebookDriver();
        driver.findElement(By.linkText("Create New Account")).click();

        Thread.sleep(1000);
        driver.findElement(By.name("firstname")).sendKeys("John");
        driver.findElement(By.name("lastname")).sendKeys("Smith");
        driver.findElement(By.name("reg_email__")).sendKeys("5555555");
        driver.findElement(By.name("reg_passwd__")).sendKeys("123456789");

        WebElement elementoMeses = driver.findElement(By.name("birthday_month"));
        Select meses = new Select(elementoMeses);
        meses.selectByVisibleText("Jun");

        WebElement elementoDias = driver.findElement(By.name("birthday_day"));
        Select dias = new Select(elementoDias);
        dias.selectByIndex(26);

        WebElement elementoAño = driver.findElement(By.name("birthday_year"));
        Select año = new Select(elementoAño);
        año.selectByVisibleText("1980");

        List<WebElement> listaSexo = driver.findElements(By.name("sex"));
        Assert.assertEquals(listaSexo.size(), 3);
        WebElement mascSexo = listaSexo.get(1);
        mascSexo.click();

        Thread.sleep(5000);
        driver.close();

    }
}
