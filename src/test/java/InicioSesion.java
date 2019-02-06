
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
//import org.junit.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import sun.jvm.hotspot.utilities.Assert;


public class InicioSesion extends BaseTest{


    @Test
    public void testInicioSesion() throws Exception {
        driver.get(baseUrl);
        driver.findElement(By.id("email")).click();
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys("erejon@walook.com.mx");
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("Rejon150");
        driver.findElement(By.id("password")).click();
        driver.findElement(By.cssSelector("input[value='Iniciar sesión']")).click();
        //String badMail=driver.findElement(By.cssSelector("p[color='color: #ff0000']")).getText();
        //Assertions.assertEquals("Nombre de usuario o contraseña no válidos",badMail,"El elemento existe");
        driver.findElement(By.id("email")).click();
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys("benjamin.pina@gmail.com");
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("Abcd1234");
        driver.findElement(By.id("password")).click();
        driver.findElement(By.cssSelector("input[value='Iniciar sesion']")).click();
        driver.findElement(By.linkText("Usuario")).click();
        driver.findElement(By.linkText("Cerrar sesión")).click();
        driver.findElement(By.linkText("Recuperar contraseña")).click();
        driver.findElement(By.id("correo")).sendKeys("erejon@walook.com.mx");
        driver.findElement(By.cssSelector("input[value='Enviar correo de recuperación']")).click();
        Thread.sleep(5000);
    }

    public void testInicioSesion(String mail, String pass){
        driver.findElement(By.id("email")).click();
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys(mail);
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys(pass);
        driver.findElement(By.id("password")).click();
        driver.findElement(By.cssSelector("input[value='Iniciar sesión']")).click();
    }


}
