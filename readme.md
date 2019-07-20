A simple web crawler that locates a user-selected element on a web site with frequently changing information.
Returns the elements xPath

The executable jar may be downloaded from here:
https://drive.google.com/drive/folders/1iZ2FBxBIGRPtw8pTREOSn69B_GlqSTAM?usp=sharing

Params needed
<platform> - the chosen language/platform; i.e. java<br />
<program_path> - path to the executable app;<br />
<input_origin_file_path> - origin sample path to find the element with attribute id  and collect all the required information;<br />
<input_other_sample_file_path> - path to diff-case HTML file to search a similar element;<br />
<id_to_find> - id of an elements we want to find<br />

Example of command:
 java -cp /Users/yanaslukhai/Workspace/webcrawler/target/web-crawler-1.0-SNAPSHOT-jar-with-dependencies.jar
 controllers.Controller<br />
 ./samples/sample-0-origin.html<br />
 ./samples/sample-4-the-mash.html<br />
 make-everything-ok-button<br />

Example of possible xPath result( For each node we will receive node name and node class):<br />
Found element (Node = "a", class= "btn btn-success")<br />
        <-(Node = "div", class= "panel-footer")<br />
        <-(Node = "div", class= "panel panel-default")<br />
        <-(Node = "div", class= "col-lg-8")<br />
        <-(Node = "div", class= "row")<br />
        <-(Node = "div", class= "")<br />
        <-(Node = "div", class= "")<br />
        <-(Node = "body", class= "")<br />
        <-(Node = "html", class= "")<br />
        <-#document



