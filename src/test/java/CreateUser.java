import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import sun.jvm.hotspot.utilities.Assert;

public class CreateUser extends BaseTest{
    @Test
    public void CreateUserTest() throws Exception {

            driver.get(baseUrl);
            driver.findElement(By.id("email")).click();
            driver.findElement(By.id("email")).clear();
            driver.findElement(By.id("email")).sendKeys("carlos.torres@prodigy.net.mx");
            driver.findElement(By.id("password")).clear();
            driver.findElement(By.id("password")).sendKeys("Abcd1234");
            driver.findElement(By.id("password")).click();
            driver.findElement(By.cssSelector("input[value='Iniciar sesión']")).click();
//        driver.findElement(By.linkText("Adminstrador")).click();
//        driver.findElement(By.linkText("Usuarios|")).click();
            driver.get("http://qa.walook.com.mx:81/usuarios");
            driver.findElement(By.linkText("Agregar usuario")).click();
            driver.findElement(By.cssSelector("input[placeholder='Escriba el nombre']")).clear();
            driver.findElement(By.cssSelector("input[placeholder='Escriba el nombre']")).sendKeys("xxx");
            driver.findElement(By.id("apellido-paterno")).clear();
            driver.findElement(By.id("apellido-paterno")).sendKeys("Rejon");
            driver.findElement(By.id("apellido-materno")).clear();
            driver.findElement(By.id("apellido-materno")).sendKeys("eduardo");
            driver.findElement(By.cssSelector("input[placeholder='Ingrese su correo electrónico']")).clear();
            driver.findElement(By.cssSelector("input[placeholder='Ingrese su correo electrónico']")).sendKeys("eduard0@hotmail.com");
            driver.findElement(By.id("aplicador")).click();
            driver.findElement(By.xpath("//*[@id='btn-add-user']")).click();
            driver.findElement(By.xpath("/html/body/div[4]/div/div[4]/div/button"));


        Thread.sleep(5000);


    }




}
