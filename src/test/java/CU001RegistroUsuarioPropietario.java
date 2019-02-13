import com.devskiller.jfairy.Fairy;
import com.devskiller.jfairy.producer.person.Person;
import com.github.javafaker.Faker;
import com.github.javafaker.PhoneNumber;
import fabricator.Contact;
import fabricator.Fabricator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import sun.jvm.hotspot.utilities.Assert;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class CU001RegistroUsuarioPropietario extends BaseTest{
//    Contact contact = Fabricator.contact();
//    Fairy fairy = Fairy.create();
//    Person person = fairy.person();
    //Generating test data
    Locale locale = new Locale("es", "MX");
    Faker faker = new Faker(locale);
    String  firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String secondLastName = faker.name().lastName();
    String mobilePhone = faker.phoneNumber().cellPhone();
    String position = faker.company().profession();
    String company = faker.company().name();
    String phone = faker.phoneNumber().phoneNumber();
    String email = faker.internet().emailAddress();
    String password = "Abcd1234";
   // JavascriptExecutor js = (JavascriptExecutor) driver;


    //Functions to clean properties
    public String phoneClean (String input){
        //input = Normalizer.normalize(input, Normalizer.Form.NFD);
        input =  input.replace("x","").replace("(","")
                .replace(")","").replace(".","")
                .replace(" ","").replace("-","");
        String phoneCleaned = input;
        return phoneCleaned;
    }

    public String companyClean(String input){
        input = input.replace(",","")
                .replace("-","")
                .replace(".","");
        String companyCleaned = input;
        return companyCleaned;

    }

    public String mailCleaner(String input) {
        input =  Normalizer.normalize(input, Normalizer.Form.NFD);
        input= input.replaceAll("\\p{M}", "");
        String mailCleaned = input.replaceAll(" ","");

        return mailCleaned;
    }
    //Classes' methods
    public void registrarUsuario(){
//        email = "erejon@walook.com.mx" ;
        InicioSesion is = new InicioSesion();

        for (int i=0;i<2;i++) {
            try {
                //Process to validate cancel button
                driver.findElement(By.cssSelector("a[class='col-sm-10 btn btn-GrisC border float-right']")).click();
                driver.findElement(By.linkText("Cancelar")).click();
                String tituloLogin =  driver.findElement(By.cssSelector("h1[class='text-simetrical titulo']")).getText();
                Assertions.assertEquals("Customer Pulse",tituloLogin,"Botón cancelar funciona correctamente");
               //Start method to create an account
                driver.findElement(By.cssSelector("a[class='col-sm-10 btn btn-GrisC border float-right']")).click();
                driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='*'])[14]/following::button[1]")).click();
                driver.findElement(By.id("nombres")).click();
                driver.findElement(By.id("nombres")).clear();
                driver.findElement(By.id("nombres")).sendKeys(firstName);
                driver.findElement(By.id("apellidop")).clear();
                driver.findElement(By.id("apellidop")).sendKeys(lastName);
                driver.findElement(By.id("apellidom")).clear();
                driver.findElement(By.id("apellidom")).sendKeys(secondLastName);
                List<WebElement> genero = new ArrayList(driver.findElements(By.name("genero")));
                Random r = new Random();
                genero.get(r.nextInt(3)).click();
                driver.findElement(By.id("celular")).clear();
                driver.findElement(By.id("celular")).sendKeys(phoneClean(mobilePhone));
                driver.findElement(By.id("puestoempresarial")).clear();
                driver.findElement(By.id("puestoempresarial")).sendKeys(position);
                driver.findElement(By.id("corporativo")).clear();
                driver.findElement(By.id("corporativo")).sendKeys(companyClean(company));
                driver.findElement(By.id("telempresa")).clear();
                driver.findElement(By.id("telempresa")).sendKeys(phoneClean(phone));
                //js.executeScript("window.scrollBy(0,1000)");
                driver.findElement(By.id("industria")).click();
                new Select(driver.findElement(By.id("industria"))).selectByVisibleText("Desarrollo de Software");
                driver.findElement(By.id("pais")).click();
                new Select(driver.findElement(By.id("pais"))).selectByVisibleText("México");
                driver.findElement(By.id("estadomx")).click();
                new Select(driver.findElement(By.id("estadomx"))).selectByVisibleText("Yucatán");
                driver.findElement(By.id("ciudad")).click();
                driver.findElement(By.id("ciudad")).clear();
                driver.findElement(By.id("ciudad")).sendKeys("Merida");
                driver.findElement(By.id("correo")).click();
                driver.findElement(By.id("correo")).clear();
                driver.findElement(By.id("correo")).sendKeys(mailCleaner(email.replace("@","")));
                Thread.sleep(3000);
                driver.findElement(By.id("contrasenia")).clear();
                driver.findElement(By.id("contrasenia")).sendKeys(password);
                driver.findElement(By.id("confirmar_contrasenia")).clear();
                driver.findElement(By.id("confirmar_contrasenia")).sendKeys(password);
                driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='*'])[14]/following::button[1]")).click();
                driver.findElement(By.id("correo")).clear();
                driver.findElement(By.id("correo")).sendKeys(mailCleaner(email));
                driver.findElement(By.id("confirmar_contrasenia")).clear();
                driver.findElement(By.id("confirmar_contrasenia")).sendKeys(password.replace("A","a"));
                driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='*'])[14]/following::button[1]")).click();
                driver.findElement(By.id("confirmar_contrasenia")).clear();
                driver.findElement(By.id("confirmar_contrasenia")).sendKeys(password);

                if (i==0) {
                    driver.findElement(By.cssSelector("a[class='btn btn-dark']")).click();
                    is.testInicioSesion(mailCleaner(email),password);
                    String errorUser = driver.findElement(By.cssSelector("p[style='color: #ff0000']")).getText();
                    Assertions.assertEquals("Nombre de usuario o contraseña no válidos",errorUser,"Se muestra el mensaje");
                }else {
                    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='*'])[14]/following::button[1]")).click();
                    driver.findElement(By.linkText("Aceptar")).click();
                    is.testInicioSesion(mailCleaner(email),password);
                    String misEncuestas = driver.findElement(By.tagName("h1")).getText();

                    Assertions.assertEquals("Mis encuestas",misEncuestas,"No se ingreso corrctamente");


                }
            }catch (Exception e){
                Assertions.fail(e.getMessage());
            }
        }
    }









    //Test Execution
    @Test
    public void testAltaUsuario() throws Exception {
        ingresarCustomer();
        registrarUsuario();
        System.out.println(email);
        System.out.println(company);

    }


}

