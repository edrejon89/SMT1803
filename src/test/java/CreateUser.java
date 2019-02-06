import com.github.javafaker.Faker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import sun.jvm.hotspot.utilities.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class CreateUser extends BaseTest{
    String mail = "erejon@walook.com.mx";
    Locale locale =  new Locale("ES","MX");
    Faker faker = new Faker(locale);

    @Test
    public void CreateUserTest() throws Exception {
            driver.get(baseUrl);
            driver.findElement(By.id("email")).click();
            driver.findElement(By.id("email")).clear();
            driver.findElement(By.id("email")).sendKeys(mail);
            driver.findElement(By.id("email")).sendKeys("");
            driver.findElement(By.id("password")).clear();
            driver.findElement(By.id("password")).sendKeys("Abcd1234");
            driver.findElement(By.id("password")).click();
            driver.findElement(By.cssSelector("input[value='Iniciar sesión']")).click();
            driver.findElement(By.linkText("Administrador")).click();
            driver.findElement(By.linkText("Usuarios|")).click();
//            driver.get("http://qa.walook.com.mx:81/usuarios");
            driver.findElement(By.linkText("Agregar usuario")).click();

            List<WebElement> nombres = new ArrayList(driver.findElements(By.id("nombre")));
            nombres.get(1).sendKeys("eduardo");

            driver.findElement(By.id("apellido-paterno")).sendKeys("Rejon");
            driver.findElement(By.id("apellido-materno")).sendKeys("Castillo");
            driver.findElement(By.cssSelector("input[placeholder='Ingrese su correo electrónico']")).clear();
            mail = faker.internet().emailAddress();

            driver.findElement(By.cssSelector("input[placeholder='Ingrese su correo electrónico']")).sendKeys(mail);
            driver.findElement(By.id("aplicador")).click();
            driver.findElement(By.xpath("//*[@id='btn-add-user']")).click();
            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[class='swal-button swal-button--confirm']"))).click();


    }




}
