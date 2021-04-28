package Clase3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class SpotifyWithCssSelectorTest {
    public static WebDriver getSpotifyDriver() {
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.spotify.com/uy/signup/");
        return driver;
    }

    @Test
    public static void spotifyByPlaceHolderTest() throws InterruptedException {
        WebDriver driver = getSpotifyDriver();
        //Thread.sleep(1000);
        WebElement email = driver.findElement(By.cssSelector("input[placeholder = 'Introduce tu correo electrónico.']"));
        email.sendKeys("test@test.com");
        WebElement emailRect = driver.findElement(By.cssSelector("input[placeholder = 'Vuelve a introducir tu correo electrónico.']"));
        emailRect.sendKeys("test@test.com");
        WebElement password = driver.findElement(By.cssSelector("input[placeholder = 'Crea una contraseña.']"));
        password.sendKeys("password.01");
        WebElement name = driver.findElement(By.cssSelector("input[placeholder = 'Introduce un nombre de perfil.']"));
        name.sendKeys("Yisel");
        WebElement day = driver.findElement(By.cssSelector("input[placeholder = 'DD']"));
        day.sendKeys("18");
        WebElement monthElement = driver.findElement(By.cssSelector("#month"));
        Select month = new Select(monthElement);
        month.selectByValue("06");
        WebElement year = driver.findElement(By.cssSelector("input[placeholder = 'AAAA']"));
        year.sendKeys("2000");
        WebElement genderFemale = driver.findElement(By.xpath("//*[@id=\"__next\"]/main/div[2]/div/form/fieldset/div/div[2]/label/span[2]"));
        if (genderFemale.isSelected() == false) {
            genderFemale.click();
        }
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[1]/main/div[2]/div/form/div[6]/div/label/span[1]")).click();
        driver.findElement(By.xpath("/html/body/div[1]/main/div[2]/div/form/div[7]/div/label/span[2]/span")).click();

    }

}
