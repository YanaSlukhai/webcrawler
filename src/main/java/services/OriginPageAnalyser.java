package services;

import model.HtmlElement;

import java.io.File;

public interface OriginPageAnalyser {
    HtmlElement findHtmlElementById(File htmlFile, String id);

}
