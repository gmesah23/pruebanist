package seleniumgluecode;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.junit.Assert;

import java.io.File;
import java.io.IOException;
public class Validapdf {
    public static void validateTextInPDF(String pdfFilePath, String expectedText) {
        try {
            PDDocument document = PDDocument.load(new File(pdfFilePath));
            PDFTextStripper pdfTextStripper = new PDFTextStripper();
            String actualText = pdfTextStripper.getText(document);
            document.close();
            Assert.assertTrue("PDF text validation failed. Expected: " + expectedText + ", Actual: " + actualText,
                    actualText.contains(expectedText));
        } catch (IOException e) {
            e.printStackTrace();
            Assert.fail("Failed to validate PDF text. Error: " + e.getMessage());
        }
    }
}



