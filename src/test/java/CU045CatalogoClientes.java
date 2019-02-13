import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class CU045CatalogoClientes extends BaseTest{

    protected CU003InicioSesion is = new CU003InicioSesion();


    public void moduloClientes(){
        WebElement navAdmin = driver.findElement(By.linkText("Administrador"));
        navAdmin.click();
        WebElement navUsuarios = driver.findElement(By.linkText("CU045CatalogoClientes |"));
        navUsuarios.click();
    }

    public void filtroCliente(String filtro, int tfiltro){
        List<WebElement> formControl= new ArrayList(driver.findElements(By.className("form-control")));
        formControl.get(tfiltro).sendKeys(filtro);
        List<WebElement> td = new ArrayList(driver.findElements(By.tagName("td")));
        String tdElement = td.get(0).getText();
        Assertions.assertEquals("Segura y Segura SRL",tdElement);
    }



    @Test
    public void clientesTest(){
        ingresarCustomer();
        is.testInicioSesion("erejon@walook.com.mx","Abcd1234");
        moduloClientes();
        filtroCliente("Segura y Segura SRL",0);



    }
}
