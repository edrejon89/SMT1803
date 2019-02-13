import com.github.javafaker.Faker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import sun.jvm.hotspot.utilities.Assert;

import java.sql.Driver;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class CU051CatalogoUsuarios extends BaseTest{
    //Creating test data
    String mail = "erejon@walook.com.mx";
    Locale locale =  new Locale("ES","MX");
    Faker faker = new Faker(locale);


    public void createUser(){
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
        List <WebElement> permisos = new ArrayList<>(driver.findElements(By.className("form-check-input")));
        permisos.get(new Random().nextInt(permisos.size())).click();
        driver.findElement(By.xpath("//*[@id='btn-add-user']")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[class='swal-button swal-button--confirm']"))).click();
    }


    public void deleteUser()throws InterruptedException{
        driver.findElement(By.linkText("Administrador")).click();
        driver.findElement(By.linkText("Usuarios|")).click();
        List<WebElement> user = new ArrayList<>(driver.findElements(By.cssSelector("i[title='Eliminar usuario']")));
//        System.out.println(user.size());
        user.get(user.size()-1).click();
        driver.findElement(By.cssSelector("button[class='btn btn-danger']")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("button[class='swal-button swal-button--confirm']")).click();
        Thread.sleep(3000);


    }












    @Test
    public void CU051CatalogoUsuariosTest() throws Exception {
        CU003InicioSesion is = new CU003InicioSesion();
        ingresarCustomer();
        is.testInicioSesion("erejon@walook.com.mx","Abcd1234");
        createUser();
        deleteUser();

    }




}
