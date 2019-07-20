package services;

import model.HtmlElement;

import java.io.File;
import java.util.HashSet;

public interface DiffCasePageAnalyser {
    HashSet<HtmlElement> findEtalonLikeElements(File htmlFile, HtmlElement etalonHtmlElement);
}
