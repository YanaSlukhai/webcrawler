package controllers;

import model.HtmlElement;
import services.DiffCasePageAnalyser;
import services.DiffCasePageAnalyserImpl;
import services.OriginPageAnalyser;
import services.OriginPageAnalyserImpl;

import java.io.File;
import java.util.HashSet;

public class Controller {

    public static void main(String[] args) {
        OriginPageAnalyser originPageAnalyser = new OriginPageAnalyserImpl();
        DiffCasePageAnalyser diffCasePageAnalyser = new DiffCasePageAnalyserImpl();

        String resourcePath = args[0];
        //String resourcePath = "./samples/sample-0-origin.html";
        String diffPageResourcePath =  args[1];
        //String diffPageResourcePath =  "./samples/sample-1-evil-gemini.html";
        String targetElementId = "make-everything-ok-button";

        HtmlElement foundElement = originPageAnalyser.findHtmlElementById(new File(resourcePath), targetElementId);
        HashSet<HtmlElement> result = diffCasePageAnalyser.findEtalonLikeElements(new File(diffPageResourcePath), foundElement);
        for (HtmlElement elem : result)
            System.out.println("Found element " + elem.getElementXPath());


    }
}
