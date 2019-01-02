
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
//import org.junit.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class InicioSesion extends BaseTest{


    @Test
    public void testInicioSesion() throws Exception {
        driver.get(baseUrl);
        driver.findElement(By.id("nombre")).click();
        driver.findElement(By.id("nombre")).clear();
        driver.findElement(By.id("nombre")).sendKeys("erejon@walook.com.mx");
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='*Contraseña'])[1]/following::input[1]")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='*Contraseña'])[1]/following::input[1]")).clear();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='*Contraseña'])[1]/following::input[1]")).sendKeys("Rejon150");
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='*Contraseña'])[1]/following::input[2]")).click();
        driver.findElement(By.linkText("Inicio")).click();
        driver.findElement(By.id("nombre")).click();
        driver.findElement(By.id("nombre")).clear();
        driver.findElement(By.id("nombre")).sendKeys("erejon");
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='*Contraseña'])[1]/following::div[5]")).click();
        driver.findElement(By.linkText("Recuperar Contraseña")).click();
        driver.findElement(By.id("correo")).click();
        driver.findElement(By.id("correo")).clear();
        driver.findElement(By.id("correo")).sendKeys("erejon@walook.com.mx");
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='*Correo'])[1]/following::input[2]")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Customer Pulse'])[1]/following::div[1]")).click();
    }


}
