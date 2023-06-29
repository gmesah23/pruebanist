package seleniumgluecode;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test {
    private ChromeDriver driver;


    @Given("^El usuario quiere validar el contrato$")
    public void el_usuario_quiere_validar_el_contrato() throws Throwable {
        System.setProperty("webdriver.chrome.driver","src/test/resources/driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.bancolombia.com/personas/productos-servicios/inversiones/inversion-virtual");
        driver.manage().window().maximize();

    }

    @When("^va a  documentos$")
    public void va_a_documentos() throws Throwable
    {
            Thread.sleep(3000);
        WebElement documents = driver.findElement(By.cssSelector(".nav:nth-child(4)>a"));
        documents.click();
        Thread.sleep(3000);
        WebElement link  =driver.findElement(By.linkText("Reglamento Inversión Virtual Bancolombia"));
        link.click();

       }

    @Then("^valida el contrato$")
    public void valida_el_contrato( ) throws Throwable
    {


        // Obtener el identificador de la ventana actual
        String currentWindow = driver.getWindowHandle();

        // Cambiar el control a la última ventana abierta
        for (String windowHandle : driver.getWindowHandles()) {
            driver.switchTo().window(windowHandle);
        }

        // Obtener el contenido de la página en la nueva ventana
        String pageSource = driver.getPageSource();

        // Realizar la validación de la palabra "Reglamento de Inversión" en el contenido
        if (pageSource.contains("Bancolombia")) {
            System.out.println("La palabra 'Reglamento de Inversión' se encuentra en la página.");
        } else {
            System.out.println("La palabra 'Reglamento de Inversión' no se encuentra en la página.");
        }

        // Cambiar el control de vuelta a la ventana original
        driver.switchTo().window(currentWindow);

        // Cerrar el navegador
        //driver.quit();

    }

}
