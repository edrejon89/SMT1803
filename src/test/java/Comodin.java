import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.util.Locale;
import java.util.Random;

public class Comodin extends BaseTest {
    InicioSesion is = new InicioSesion();
    Locale locale = new Locale("ES","MX");
    Faker faker = new Faker(locale);
    String survey;
    int cantEncuesta;

    public void crearEncuestas(int surveys) throws InterruptedException{
        for (int i=0;i<surveys;i++ ) {
            survey = faker.chuckNorris().fact();
            driver.findElement(By.cssSelector("a[class='btn btn-GrisC d-inline-flex']")).click();
            driver.findElement(By.id("nombre")).sendKeys(survey);
            driver.findElement(By.id("btnGuardarEncuesta")).click();
            Thread.sleep(3000);

            driver.findElement(By.cssSelector("button[class='swal-button swal-button--default']")).click();
            Thread.sleep(3000);

            driver.findElement(By.id("btnGuardarEncuesta")).click();
        }
    }

    public void eliminarEncuesta(int surveys) throws InterruptedException{
        for (int i=0;i<surveys;i++ ) {
            driver.findElement(By.cssSelector("i[class='fa fa-light fa-trash fa-2x']")).click();
            Thread.sleep(2000);
            driver.findElement(By.cssSelector("button[class='btn btn-danger']")).click();
            Thread.sleep(2000);
        }

    }


    @Test
    public void comodinTest()throws InterruptedException{
        driver.get(baseUrl);
        is.testInicioSesion("erejon@walook.com.mx","Abcd1234");
        Random r = new Random();
        cantEncuesta = (int)r.nextInt(5-1)+1;
        System.out.println(cantEncuesta);
        crearEncuestas(cantEncuesta);
        eliminarEncuesta(cantEncuesta);







    }
}
