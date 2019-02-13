import com.github.javafaker.Faker;
import com.sun.xml.internal.rngom.parse.host.Base;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class CU012CreacionEncuesta extends BaseTest {
    Locale locale = new Locale("es_MX");
    Faker faker = new Faker(locale);
    CU003InicioSesion is = new CU003InicioSesion();
    protected String survey = faker.name().title();

    //Methods
    public void crearEncuestas(int surveys) throws InterruptedException{
        for (int i=0;i<surveys;i++ ) {
            survey = faker.chuckNorris().fact();
            driver.findElement(By.cssSelector("a[class='btn btn-GrisC d-inline-flex']")).click();
            driver.findElement(By.id("nombre")).sendKeys(survey);
            driver.findElement(By.id("btnGuardarEncuesta")).click();
            Thread.sleep(3000);

            driver.findElement(By.cssSelector("button[class='swal-button swal-button--default']")).click();
            Thread.sleep(3000);

            driver.findElement(By.id("btnGuardarEncuesta")).click();
        }
    }


    public void eliminarEncuesta(int surveys) throws InterruptedException{
        for (int i=0;i<surveys;i++ ) {
            driver.findElement(By.cssSelector("i[class='fa fa-light fa-trash fa-2x']")).click();
            Thread.sleep(2000);
            driver.findElement(By.cssSelector("button[class='btn btn-danger']")).click();
            Thread.sleep(2000);
        }

    }






    public void encuestaFallida()throws InterruptedException{
//        Creando nombre de la encuesta
        survey = faker.company().name() + (int)Math.random();
//        Creando la encuesta
        driver.findElement(By.cssSelector("a[class='btn btn-GrisC d-inline-flex']")).click();
        driver.findElement(By.id("nombre")).sendKeys(survey);
        driver.findElement(By.id("btnGuardarEncuesta")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("button[class='swal-button swal-button--default']")).click();
        Thread.sleep(3000);
//        Creando las preguntas

        for (int i = 0;i<5 ; i++) {
            driver.findElement(By.id("pregunta")).click();
            List<WebElement> pregunta = new ArrayList(driver.findElements(By.tagName("option")));
            Random r = new Random();
            int option = r.nextInt(5-1)+1;
            System.out.println(option);
            pregunta.get(option).click();
            driver.findElement(By.cssSelector("a[class='btn btn-Morado btn-responsive form-control-lg btn_agregar_tipo']")).click();
            switch (option){

                case 1:
                    driver.findElement(By.xpath("//*[@id='formGuardarCheckbox']/div[2]/div[2]/input")).sendKeys(faker.name().firstName()+r.nextInt());
                    driver.findElement(By.id("input_check_respuesta")).sendKeys(faker.lorem().word()+r.nextInt());
                    driver.findElement(By.id("input_check_valor")).sendKeys("50");
                    driver.findElement(By.id("btn_agregar_respuesta_checkbox")).click();
                    driver.findElement(By.id("input_check_respuesta")).sendKeys(faker.lorem().word()+r.nextInt());
                    driver.findElement(By.id("input_check_valor")).sendKeys("50");
                    driver.findElement(By.id("btn_agregar_respuesta_checkbox")).click();
                    driver.findElement(By.id("btn_guardar_formulario_modalCheckbox")).click();
                    break;
                case 2:
                    driver.findElement(By.xpath("//*[@id='formGuardarEstrella']/div[2]/div[2]/input")).sendKeys(faker.name().firstName()+r.nextInt());
                    driver.findElement(By.id("input_respuesta_estrella")).sendKeys(faker.lorem().word()+r.nextInt());
                    driver.findElement(By.id("config_escala")).sendKeys("5");
                    driver.findElement(By.id("config_valor")).sendKeys("50");
                    WebElement guardar = driver.findElement(By.id("btn_agregar_respuesta_estrella"));
                    guardar.click();
                    driver.findElement(By.id("input_respuesta_estrella")).sendKeys(faker.lorem().word()+r.nextInt());
                    driver.findElement(By.id("config_escala")).sendKeys("5");
                    driver.findElement(By.id("config_valor")).sendKeys("50");
                    if (r.nextBoolean()){
                        driver.findElement(By.id("config_rango_uno")).sendKeys("1");
                        driver.findElement(By.id("config_rango_dos")).sendKeys("2");
                    }
                    guardar.click();
                    Thread.sleep(5000);
                    driver.findElement(By.id("btn_guardar_formulario_modalEstrella")).click();

                    break;
                case 3:
                    driver.findElement(By.xpath("//*[@id='descpregunta']")).sendKeys(faker.name().firstName()+r.nextInt());
                    WebElement inputRespuesta = driver.findElement(By.id("input_radio_respuesta"));
                    WebElement inputValor = driver.findElement(By.id("input_radio_valor"));
                    WebElement btnRespuesta = driver.findElement(By.id("btn_agregar_respuesta_radio"));
                    WebElement btnGuardarRadio = driver.findElement(By.id("btn_guardar_formulario_modalRadio"));

                    for (int j=0;j<2;j++) {
                        inputRespuesta.sendKeys(faker.lorem().word()+r.nextInt());
                        inputValor.sendKeys("50");
                        btnRespuesta.click();
                    }
                    btnGuardarRadio.click();
                    break;
                case 4:
                    driver.findElement(By.xpath("//*[@id='formGuardarSelector']/div[2]/div[2]/input")).sendKeys(faker.name().firstName()+r.nextInt());
                    WebElement inputRespuestaSelector = driver.findElement(By.id("input_sel_respuesta"));
                    WebElement inputValorSelector = driver.findElement(By.id("input_sel_valor"));
                    WebElement btnRespuestaSelector = driver.findElement(By.id("btn_agregar_respuesta_selector"));
                    WebElement btnGuardarSelector = driver.findElement(By.id("btn_guardar_formulario_modalSelector"));

                    for (int j=0;j<2;j++) {
                        inputRespuestaSelector.sendKeys(faker.lorem().word()+r.nextInt());
                        inputValorSelector.sendKeys("50");
                        btnRespuestaSelector.click();
                    }
                    btnGuardarSelector.click();
                    break;
                case 5:
                    driver.findElement(By.name("descripcion")).sendKeys(faker.name().firstName()+r.nextInt());
                    driver.findElement(By.id("btn_guardar_formulario_modalTexto")).click();
                    break;
            }
            Thread.sleep(2000);





        }
//            Ingresando a la anidación de preguntas
        List<WebElement> tagsEncuesta = new ArrayList(driver.findElements(By.className("label-light")));
        tagsEncuesta.get(1).click();
        driver.findElement(By.id("btnArbol")).click();
        Thread.sleep(5000);
//        Recuperando respuestas para asignar preguntas
        List <WebElement> anidacionResp = new ArrayList(driver.findElements(By.className("anidacionResp")));
        System.out.println(anidacionResp.size());

    }



    //Test execution
    @Test
    public void CU012CreacionEncuestaTest() throws InterruptedException{
        driver.get(baseUrl);
        is.testInicioSesion("erejon@walook.com.mx","Abcd1234");
//        Random r = new Random();
//        cantEncuesta = r.nextInt(5-1)+1;
//        System.out.println(cantEncuesta);
//        crearEncuestas(cantEncuesta);
//        eliminarEncuesta(12);
        encuestaFallida();

    }
}