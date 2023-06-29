package seleniumgluecode;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;

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
        WebElement downloadLink = driver.findElement(By.linkText("Descargar PDF"));
        downloadLink.click();
       }

    @Then("^valida el contrato$")
    public void valida_el_contrato( String pdfFilePath) throws Throwable
    {
        PDDocument document = PDDocument.load(new File(pdfFilePath));
            PDFTextStripper pdfTextStripper = new PDFTextStripper();
        String actualText = pdfTextStripper.getText(document);
        document.close();

    }

}
