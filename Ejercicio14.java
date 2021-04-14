import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class Ejercicio14 {
    @Test
    public static void netflixTest(){
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        WebDriver driver;
        driver = new ChromeDriver();
        driver.get("https://www.netflix.com/uy/");
        List<WebElement> listaH1s = driver.findElements(By.tagName("h1"));
        List<WebElement> listaH2s = driver.findElements(By.tagName("h2"));
        System.out.println("Elementos H1: ");
        for (WebElement elementosH1: listaH1s){
            System.out.println(elementosH1.getText());
        }

        System.out.println("******************* ");
        System.out.println("Elementos H2: ");
        for (WebElement elementosH2: listaH2s){
            System.out.println(elementosH2.getText());
        }

        driver.navigate().refresh();

        System.out.println("******************* ");
        List<WebElement> listaButton = driver.findElements(By.tagName("button"));
        System.out.println("Botones de la página: ");
        for (WebElement buttons: listaButton){
            System.out.println(buttons.getText());
        }

        System.out.println("******************* ");
        List<WebElement> listaDivs = driver.findElements(By.tagName("div"));
        System.out.println("La cantidad de elementos div de la página es: " + listaDivs.size());

        System.out.println("Título de la página: " + driver.getTitle());

        List<WebElement> listaLinks = driver.findElements(By.tagName("a"));
        System.out.println("La cantidad de Links de la página es: " + listaLinks.size());

    }
}
