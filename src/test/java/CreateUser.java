import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class CreateUser extends BaseTest{
    @Test
    public void CreateUserTest() throws Exception {
        driver.get(baseUrl);
        driver.findElement(By.id("email")).click();
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys("erejon@walook.com.mx");
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("Abcd1234");
        driver.findElement(By.id("password")).click();
        driver.findElement(By.cssSelector("input[value='Iniciar sesión']")).click();
        driver.findElement(By.linkText("Adminstrador")).click();
        driver.findElement(By.linkText("Usuarios|")).click();
        driver.findElement(By.linkText("Agregar usuario")).click();





        driver.findElement(By.id("nombre")).sendKeys("Eduardo");
        Thread.sleep(5000);

    }
}
