package net.jdarklight.jdlapp.jdlprocessor;

import org.jsoup.nodes.Element;

/**
 * Created by user pc on 27/09/2016.
 */
public class DocParserListnerTest implements DocParserListner {
    private int nodeCount=0;
    public int beforeParsing(int EVENT_ID, Element element) {
        nodeCount++;
        return DocParserListner.HANDLE;
    }

    public void afterParsing(int EVENT_ID, Element element) {

    }
}
