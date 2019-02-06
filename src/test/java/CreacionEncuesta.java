import com.github.javafaker.Faker;
import com.sun.xml.internal.rngom.parse.host.Base;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import java.util.Locale;

public class CreacionEncuesta extends BaseTest {
    Locale locale = new Locale("es_MX");
    Faker faker = new Faker(locale);
    InicioSesion is = new InicioSesion();
    protected String survey = faker.name().title();

    @Test
    public void crearEncuestaTest() throws InterruptedException{
        driver.get(baseUrl);
        is.testInicioSesion("erejon@walook.com.mx", "Abcd1234");
        driver.findElement(By.cssSelector("a[class='btn btn-GrisC d-inline-flex']")).click();
        driver.findElement(By.id("nombre")).click();
        driver.findElement(By.id("nombre")).clear();
        driver.findElement(By.id("nombre")).sendKeys(survey);
        driver.findElement(By.id("btnGuardarEncuesta")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='¡Encuesta guardada correctamente!'])[1]/following::button[1]")).click();
        driver.findElement(By.id("pregunta")).click();
        new Select(driver.findElement(By.id("pregunta"))).selectByVisibleText("Texto");
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='*'])[2]/following::i[1]")).click();
        driver.findElement(By.name("descripcion")).click();
        driver.findElement(By.name("descripcion")).clear();
        driver.findElement(By.name("descripcion")).sendKeys("Cual es su nombre?");
        driver.findElement(By.id("btn_guardar_formulario_modalTexto")).click();
        driver.findElement(By.id("btnGuardarEncuesta")).click();
    }
}