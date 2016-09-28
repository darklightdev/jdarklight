package net.jdarklight.jdlapp.jdlprocessor;

import junit.framework.Assert;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

public class DocParserTest {
    private static Element element4test001;
    private static DocParser docParserInstance;
    private static DocParserListnerTest docParserListnerTestInstance;

    @BeforeClass
    public static void init() throws IOException, URISyntaxException {
        docParserInstance =new DocParser();
        docParserListnerTestInstance=new DocParserListnerTest();
        //URL url=DocParser.class.getResource("/html/page_20160921_001.html");
        URL url=DocParser.class.getResource("/html/page_20160927_001.html");// https://juguettos.com/productos/juego-de-badminton?taxon_id=26
        element4test001= Jsoup.parse(new File(url.toURI()),"UTF-8");
    }

    @Test
    public void parse(){
        docParserInstance.parse(element4test001, docParserListnerTestInstance);
        ItemNode rootDocument= docParserInstance.getRootItemNode();

        Assert.assertTrue(true);
    }
}
