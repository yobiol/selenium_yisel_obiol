package Básico.Examen;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.w3c.dom.html.HTMLBaseElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class InterviewQuestionSiteTest {
    public WebDriver driver;

    @BeforeMethod
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://allstq.com/most-popular-testng-interview-questions/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void landingPageTest() throws InterruptedException {
        String textoPantalla = driver.findElement(By.tagName("h1")).getText();
        System.out.println(textoPantalla);

        List<WebElement> listaTitulos = driver.findElements(By.tagName("h3"));
        System.out.println(" **** Preguntas del sitio ****");
        for (int i =1; i<=6; i++){
            if (!listaTitulos.get(i).getText().trim().equals("")) {
                System.out.println(listaTitulos.get(i).getText());
            }
        }

        String title = driver.getTitle();
        String titleExpected = "Most popular TestNG interview questions - Software Testing Questions";
        Assert.assertEquals(title, titleExpected, "Se esperaba el título: " + driver.getTitle());
        Assert.assertTrue(title.contains("Software Testing Questions"));

        String currentUrl = driver.getCurrentUrl();
        String url = "https://allstq.com/most-popular-testng-interview-questions/";
        Assert.assertEquals(currentUrl, url, "Se esperaba la url: " + driver.getCurrentUrl());
        Assert.assertTrue(currentUrl.contains("most-popular-testng-interview-questions"));

        boolean encuentraTextoSelenium = false;
        boolean encuentraTextoJava = false;
        List<WebElement> menu = driver.findElements(By.className("menu-link"));
        Thread.sleep(3000);
        for (WebElement opciones: menu){
            if (opciones.getText().contains("Selenium") ){
                encuentraTextoSelenium = true;}
            else if (opciones.getText().contains("Java")){
                encuentraTextoJava = true;
            }
        }
        Assert.assertTrue(encuentraTextoSelenium, "No se encontró el texto Selenium" );
        Assert.assertTrue(encuentraTextoJava, "No se encontró el texto Java");
        closeDriver();
    }

    @Test
    public void closeDriver(){
        driver.close();
    }

}
