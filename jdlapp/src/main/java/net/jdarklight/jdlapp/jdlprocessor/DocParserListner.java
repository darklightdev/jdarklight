package net.jdarklight.jdlapp.jdlprocessor;

import org.jsoup.nodes.Element;

public interface DocParserListner {
    public final static int HANDLE=10;
    public final static int CONTINUE=11;
    public final static int BREAK=11;
    int beforeParsing(final int EVENT_ID, final Element element);
    void afterParsing(final int EVENT_ID, final Element element);
}
