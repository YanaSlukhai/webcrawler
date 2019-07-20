package services;

import exceptions.InvalidInputParametersException;
import model.HtmlElement;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class DiffCasePageAnalyserImpl implements DiffCasePageAnalyser {

    private static String CHARSET_NAME = "utf8";

    @Override
    public HashSet<HtmlElement> findEtalonLikeElements(File htmlFile, HtmlElement etalonHtmlElement) {
        String cssTitleQuery = "div[class=\"panel panel-default\"] a[title=\"" + etalonHtmlElement.getElementTitle() + "\"]";
        String cssClassQuery = "div[class=\"panel panel-default\"] a[class=\"" + etalonHtmlElement.getElementClass() + "\"]";
        //improve later to parse "button" nodes too not only "a"...

        Elements sameClassElements = findElementsByQuery(htmlFile, cssClassQuery);
        Elements sameTitleElements = findElementsByQuery(htmlFile, cssTitleQuery);
        HashSet<HtmlElement> resultElements = new HashSet<>();

        addElementsAsHtmlElementsToHashSet(sameClassElements, resultElements);
        addElementsAsHtmlElementsToHashSet(sameTitleElements, resultElements);
        return resultElements;

    }

    private void addElementsAsHtmlElementsToHashSet(Elements elements, HashSet<HtmlElement> resultElements) {
        elements
                .iterator()
                .forEachRemaining(button ->
                        resultElements.add(
                                new HtmlElement(button.id(),
                                        button.className(),
                                        button.attr("title"),
                                        getPath(button))));
    }


    private static Elements findElementsByQuery(File htmlFile, String cssQuery) {
        try {
            Document doc = Jsoup.parse(
                    htmlFile,
                    CHARSET_NAME,
                    htmlFile.getAbsolutePath());

            return doc.select(cssQuery);

        } catch (IOException e) {
            throw new InvalidInputParametersException(e);
        }
    }

    private String getPath(Element e) {
        StringJoiner joiner = new StringJoiner("\n\t<-");
        if (e.parent() == null)
            joiner.add(e.nodeName());
        else
            joiner.add("(Node = \"" + e.nodeName() + "\", class= \"" + e.className() + "\")").add(getPath(e.parent()));
        return joiner.toString();

    }
}
