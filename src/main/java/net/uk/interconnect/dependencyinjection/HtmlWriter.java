package net.uk.interconnect.dependencyinjection;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;

public class HtmlWriter {

    // We've seen this before too. This class will take in a collection of urlInfos and create a
    // snippet. A snippet starts with a greeting and then has a bulleted list of
    // urls with their summaries. Each url has the heading which was set by the user when they edited the tree

    public static void writeToHTML(String htmlFileName, Collection<UrlInfo> summaries){
        BufferedWriter htmlWriter = null;
        try {
            File htmlFile = new File(htmlFileName);
            if(htmlFile.exists()){
                htmlFile.delete();
            }
            htmlFile.createNewFile();
            htmlWriter = new BufferedWriter(new FileWriter(htmlFile));
            htmlWriter.write("<html><body>Hi,<br/><br/>"
                        + "Here are some interesting snippets <br/><ul/> ");
            for (UrlInfo urlInfo:summaries) {
                String body = "<li><b><a href=\""+urlInfo.getUrl()+"\"target=\"blank\" a>"+
                        urlInfo.getHeadline()+"</a></b>:"+
                        urlInfo.getSummary()+"</li>";
                htmlWriter.write("<br/>"+body);
            }
            htmlWriter.write("</ul></br></body></html>");
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try{
                htmlWriter.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }




}
