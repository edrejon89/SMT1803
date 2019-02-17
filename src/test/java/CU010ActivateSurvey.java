import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CU010ActivateSurvey extends BaseTest{
    CU003InicioSesion is = new CU003InicioSesion();

//    public List  getSwitchState(){
//        List<WebElement> switchToActivateOn = new ArrayList<>(driver.findElements(By.cssSelector("i[class='fa fa-light fa-toggle-on fa-2x']")));
//
//        return switchToActivateOn ;
//    }

    public void activateSurvey(){

        List<WebElement> switchOn = new ArrayList<>(driver.findElements(By.cssSelector("i[class='fa fa-toggle-on fa-2x']")));
        List<WebElement> switchOff = new ArrayList<>(driver.findElements(By.cssSelector("i[class='fa fa-light fa-toggle-off fa-2x']")));
        System.out.println("Apagados "+ switchOff.size());
        System.out.println("Encendidos " + switchOn.size());

        if(!switchOff.isEmpty() || !switchOn.isEmpty()){

            if (!switchOn.isEmpty()){
                switchOn.get((int) (Math.random() * (switchOn.size() - 0)) + 0).click();
                if (driver.findElement(By.id("form-activar-encuesta")).isDisplayed()){
                    WebElement changeState = driver.findElement(By.cssSelector("button[class='btn btn-primary']"));
                    changeState.click();
                    System.out.println("Se desactivo la encuesta");
                }


            }



            if (!switchOff.isEmpty()){
                switchOff.get((int) (Math.random() * (switchOff.size() - 0)) + 0).click();
                if (driver.findElement(By.id("form-activar-encuesta")).isDisplayed()){
                    WebElement changeState = driver.findElement(By.cssSelector("button[class='btn btn-primary']"));
                    changeState.click();
                    System.out.println("Se activo la encuesta");
                }else if (driver.findElement(By.id("modal-sin-pregunta")).isDisplayed()){
                    WebElement sPreguntas = driver.findElement(By.cssSelector("button[class='btn btn-default']"));
                    sPreguntas.click();
                    System.out.println("La encuesta no cuenta con preguntas");


                }
            }



        }



        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.getMessage();
        }


    };



    @Test
    public void CU010ActivateSurveyTest() throws Exception {
        System.out.println((int)Math.random()*(5-1)+1);
//        ingresarCustomer();
//        is.testInicioSesion("erejon@walook.com.mx","Abcd1234");
//        activateSurvey();
//        Thread.sleep(3000);

    }
}
