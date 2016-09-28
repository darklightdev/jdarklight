package net.jdarklight.jdlapp.jdlprocessor;

import org.jsoup.nodes.Element;

public class DocParserListnerFactory {
    public static DocParserListnerAdatpor defaultDocParserListner(){
        return new DocParserListnerAdatpor() {
            @Override
            public int beforeParsing(int EVENT_ID, Element element) {
                //System.out.println(EVENT_ID+": "+element.nodeName()+" "+element.attributes());
                return super.beforeParsing(EVENT_ID, element);
            }

            @Override
            public void afterParsing(int EVENT_ID, Element element) {
                //System.out.println(EVENT_ID+": "+element.nodeName());
            }
        };
    }
}
