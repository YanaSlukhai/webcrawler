package services;

import exceptions.EtalonElementNotFoundException;
import exceptions.InvalidInputParametersException;
import model.HtmlElement;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

public class OriginPageAnalyserImpl implements OriginPageAnalyser {
    private static String CHARSET_NAME = "utf8";

    @Override
    public HtmlElement findHtmlElementById(File htmlFile, String elementId) {
        try {
            Document doc = Jsoup.parse(
                    htmlFile,
                    CHARSET_NAME,
                    htmlFile.getAbsolutePath());

            Element neededElement = doc.getElementById(elementId);
            HtmlElement etalonHtmlElement = null;

            if (neededElement != null) {
                etalonHtmlElement = new HtmlElement(neededElement.id(),
                        neededElement.className(),
                        neededElement.attr("title"),
                        neededElement.html());

                System.out.println(etalonHtmlElement.toString());
                return etalonHtmlElement;
            } else
                throw new EtalonElementNotFoundException("No etalon element found");

        } catch (IOException e) {
            throw new InvalidInputParametersException(e);
        }
    }
}
