import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class CU011DuplicateSurvey extends BaseTest{
    Locale locale = new Locale("es","mx");
    Faker faker = new Faker(locale);
    Random r = new Random();

    public void duplicateSurvey() throws InterruptedException{

        for (int i =0; i<2;i++) {
            List <WebElement> duplicateButtons = new ArrayList(driver.findElements(By.cssSelector("i[class='fa fa-light fa-copy fa-2x']")));
            duplicateButtons.get(0).click();
            driver.findElement(By.id("txtCloneNombre")).sendKeys(faker.lorem().word()+r.nextInt());
            if (i ==0){

                WebElement btnClone = driver.findElement(By.cssSelector("button[class='btn btn-secondary']"));
                btnClone.click();

            }else{

                WebElement btnClone = driver.findElement(By.cssSelector("button[class='btn btn-primary']"));
                btnClone.click();

            }
        }




    }



    @Test
    public void CU011DuplicateSurveyTest() throws Exception{
        ingresarCustomer();
        CU003InicioSesion is = new CU003InicioSesion();
        is.testInicioSesion("erejon@walook.com.mx","Abcd1234");
        duplicateSurvey();
        Thread.sleep(5000);

    }



}
