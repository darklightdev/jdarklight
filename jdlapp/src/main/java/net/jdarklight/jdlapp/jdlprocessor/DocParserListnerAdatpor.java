package net.jdarklight.jdlapp.jdlprocessor;

import org.jsoup.nodes.Element;

public abstract class DocParserListnerAdatpor implements DocParserListner{
    public int beforeParsing(int EVENT_ID, Element element) {
        return DocParserListner.HANDLE;
    }

    public void afterParsing(int EVENT_ID, Element element) {

    }
}
