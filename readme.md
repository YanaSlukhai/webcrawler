A simple web crawler that locates a user-selected element on a web site with frequently changing information.
Returns the elements xPath

The executable jar may be downloaded from here:
https://drive.google.com/drive/folders/1iZ2FBxBIGRPtw8pTREOSn69B_GlqSTAM?usp=sharing

Params needed
<platform> - the chosen language/platform; i.e. java
<program_path> - path to the executable app;
<input_origin_file_path> - origin sample path to find the element with attribute id="make-everything-ok-button" and collect all the required information;
<input_other_sample_file_path> - path to diff-case HTML file to search a similar element;
<id_to_find> - id of an elements we want to find

Example of command:
 java -cp /Users/yanaslukhai/Workspace/webcrawler/target/web-crawler-1.0-SNAPSHOT-jar-with-dependencies.jar
 controllers.Controller
 ./samples/sample-0-origin.html
 ./samples/sample-4-the-mash.html
 make-everything-ok-button

Example of possible xPath result( For each node we will receive node name and node class):
Found element (Node = "a", class= "btn btn-success")
        <-(Node = "div", class= "panel-footer")
        <-(Node = "div", class= "panel panel-default")
        <-(Node = "div", class= "col-lg-8")
        <-(Node = "div", class= "row")
        <-(Node = "div", class= "")
        <-(Node = "div", class= "")
        <-(Node = "body", class= "")
        <-(Node = "html", class= "")
        <-#document



