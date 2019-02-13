import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class CU005RecoverPassword extends BaseTest{
    @Test
    public void recoverPasswordTest(){
        ingresarCustomer();
        WebElement language = driver.findElement(By.cssSelector("button[class='btn btn-language dropdown-toggle']"));
        language.click();
        List<WebElement> languages = new ArrayList(driver.findElements(By.cssSelector("a[class='dropdown-item dropdown-item-idioma']")));
        languages.get(0).click();
        WebElement recoverLink = driver.findElement(By.linkText("Recuperar contraseña"));
        recoverLink.click();
        WebElement inputMail = driver.findElement(By.id("correo"));
        inputMail.sendKeys("erejon@walook.com.mx");
        WebElement sendRequest = driver.findElement(By.cssSelector("input[value='Enviar correo de recuperación']"));
        sendRequest.click();
        String resendPass = driver.findElement(By.linkText("Reenvío de correo")).getText();
        Assertions.assertEquals("Reenvío de correo",resendPass,"Es correcto");






        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


}
