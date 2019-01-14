import com.github.javafaker.Faker;
import com.github.javafaker.PhoneNumber;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;

public class AltaUsuario extends BaseTest{
    //Generating test data
    Faker faker = new Faker();
    String  firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String secondLastName = faker.name().lastName();
    String mobilePhone = faker.phoneNumber().cellPhone().replace("-","");
    String position = faker.company().profession();
    String company = faker.company().name().replace(",","");
    String phone = faker.phoneNumber().phoneNumber().replace("-","");
    String email = faker.internet().emailAddress();
    String password = "Abcd1234";
    //Test Execution
   // JavascriptExecutor js = (JavascriptExecutor) driver;
    @Test
    public void testAltaUsuario() throws Exception {
        phone = phone.replace("x","");
        phone =  phone.replace("(","");
        phone = phone.replace(")","");
        phone = phone.replace(".","");

        mobilePhone = mobilePhone.replace("x","");
        mobilePhone =  mobilePhone.replace("(","");
        mobilePhone = mobilePhone.replace(")","");
        mobilePhone = mobilePhone.replace(".","");

        company = company.replace("-","");

        driver.get(baseUrl);
        try {
            driver.findElement(By.linkText("Registro")).click();
            driver.findElement(By.id("nombres")).click();
            driver.findElement(By.id("nombres")).clear();
            driver.findElement(By.id("nombres")).sendKeys(firstName);
            driver.findElement(By.id("apellidop")).clear();
            driver.findElement(By.id("apellidop")).sendKeys(lastName);
            driver.findElement(By.id("apellidom")).clear();
            driver.findElement(By.id("apellidom")).sendKeys(secondLastName);
            driver.findElement(By.name("genero")).click();
            driver.findElement(By.id("celular")).clear();
            driver.findElement(By.id("celular")).sendKeys(mobilePhone);
            driver.findElement(By.id("puestoempresarial")).clear();
            driver.findElement(By.id("puestoempresarial")).sendKeys(position);
            driver.findElement(By.id("corporativo")).clear();
            driver.findElement(By.id("corporativo")).sendKeys(company);
            driver.findElement(By.id("telempresa")).clear();
            driver.findElement(By.id("telempresa")).sendKeys(phone.replace("x",""));
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
            driver.findElement(By.id("correo")).sendKeys(email);
            driver.findElement(By.id("contrasenia")).clear();
            driver.findElement(By.id("contrasenia")).sendKeys(password);
            driver.findElement(By.id("confirmar_contrasenia")).clear();
            driver.findElement(By.id("confirmar_contrasenia")).sendKeys(password);
            driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='*'])[14]/following::button[1]")).click();
            driver.findElement(By.linkText("Aceptar")).click();
        }catch (Exception e){
            Assertions.fail(e.getMessage());
        }
    }
}

