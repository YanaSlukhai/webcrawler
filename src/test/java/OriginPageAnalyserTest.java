import model.HtmlElement;
import org.junit.Test;

import static org.junit.Assert.*;

import services.OriginPageAnalyser;
import services.OriginPageAnalyserImpl;

import java.io.File;
import java.util.Optional;

public class OriginPageAnalyserTest {

    OriginPageAnalyser analyser = new OriginPageAnalyserImpl();

    @Test
    public void findButtonAttributesByIdTest() {
        // so providing InputStream through classpath resources is not a case
        String resourcePath = "./samples/sample-0-origin.html";
        String targetElementId = "make-everything-ok-button";
        HtmlElement expectedButton = new HtmlElement("make-everything-ok-button",
                "btn btn-success",
                "Make-Button",
                "Make everything OK");

        System.out.println(expectedButton.toString());
        HtmlElement foundElement = analyser.findHtmlElementById(new File(resourcePath), targetElementId);
        assertEquals(expectedButton, foundElement);
    }


}
