import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class sendSurveyByMail extends BaseTest{
    InicioSesion is = new InicioSesion();

    public void filtroEncuesta(String filtro, int tfiltro){
        List<WebElement> formControl= new ArrayList(driver.findElements(By.className("form-control")));
        formControl.get(tfiltro).sendKeys(filtro);
        driver.findElement(By.cssSelector("button[class='btn btn-search btn-light']")).click();
        List<WebElement> td = new ArrayList(driver.findElements(By.tagName("td")));
        String tdElement = td.get(0).getText();
        Assertions.assertEquals("Cinepolis",tdElement);
    }




    @Test
    public void sendSurverByMail() throws InterruptedException{
        driver.get(baseUrl);
        is.testInicioSesion("erejon@walook.com.mx","Abcd1234");
        filtroEncuesta("Cinepolis", 0);
        WebElement sendMail = driver.findElement(By.cssSelector("i[class='fa fa-light fa-envelope fa-2x']"));
        sendMail.click();

        Thread.sleep(5000);

    }
}
