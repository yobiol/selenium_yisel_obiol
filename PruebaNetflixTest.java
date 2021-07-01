package Básico.Examen;

import Básico.ExamenSimulacion.DataProviderTest;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;
import java.util.SplittableRandom;
import java.util.concurrent.TimeUnit;

public class PruebaNetflixTest {
    public WebDriver driver;

    @BeforeMethod
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.netflix.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void iniciarSesionPageTest(){
        String titulo = driver.getTitle();
        System.out.println("Título actual: " + titulo);
        WebElement iniciarSesion = driver.findElement(By.xpath("//a[@href='/login']"));
        iniciarSesion.click();
        titulo = driver.getTitle();
        System.out.println("Título nuevo: " + titulo);
        Assert.assertEquals(titulo, "Netflix", "Se esperaba otro título");

        WebElement textoIniciarSesion = driver.findElement(By.tagName("h1"));
        Assert.assertTrue(textoIniciarSesion.getText().contains("Sign In"));

        WebElement facebookTest = driver.findElement(By.xpath("//*[@class='fb-login']"));
        String facebookTestExpected = "Login with Facebook";
        Assert.assertEquals(facebookTest.getText(), facebookTestExpected, "Se esperaba el texto: " + facebookTestExpected);
        closeDriver();
    }

    @Test
    public void fakeEmailTest()throws InterruptedException {
        Faker faker = new Faker();
        WebElement email = driver.findElement(By.name("email"));
        email.sendKeys(faker.internet().emailAddress());
        WebElement startButton = driver.findElement(By.xpath("//*[@data-uia='our-story-cta-hero_fuji']"));
        startButton.click();
        Thread.sleep(2000);
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("signup"));
        closeDriver();
    }

    @Test(dataProvider = "email", dataProviderClass = DataProviderExam.class)
    public void dataProviderEmailTest(String anEmail){
        WebElement email = driver.findElement(By.name("email"));
        email.sendKeys(anEmail);
        WebElement startButton = driver.findElement(By.xpath("//*[@data-uia='our-story-cta-hero_fuji']"));
        startButton.click();
        closeDriver();
    }

    @Test
    @Parameters({"tagName"})
    public void printTagsTest(@Optional("h2") String aTagName ){
        System.out.println("Se van a impimir todos los " + aTagName);
        List<WebElement> tagElementList = driver.findElements(By.tagName(aTagName));
        for (WebElement elemento: tagElementList){
            System.out.println("--> " + elemento.getText());
        }
        Assert.assertEquals(tagElementList.size(),6, "Se esperaban 6 elementos con el tagName " + aTagName);
        closeDriver();
    }

    @Test
    public void closeDriver(){
        driver.close();
    }
}
