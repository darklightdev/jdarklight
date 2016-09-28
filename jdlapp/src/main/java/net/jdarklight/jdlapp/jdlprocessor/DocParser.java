package net.jdarklight.jdlapp.jdlprocessor;

import org.jsoup.nodes.Element;

public class DocParser {
    public final static int PARSING_START=11;
    public final static int PARSING_END=12;
    public final static int BEFORE_PARSING_ITEM=13;
    public final static int AFTER_PARSING_ITEM=14;
    public final static int BEFORE_PARSING_PROP=15;
    public final static int AFTER_PARSING_PROP=16;

    private ItemNode rootItemNode;

    private DocParserListner parserListner=null;
    public DocParser(){
        this.parserListner=DocParserListnerFactory.defaultDocParserListner();
    }

    public void parse(final Element document, DocParserListner parserListner){
        this.parserListner=parserListner;
        rootItemNode=new ItemNode(document);
        parseChild(0, rootItemNode, rootItemNode, document);
    }

    private void parseChild(final int deep, final ItemNode root, final ItemNode node, final Element element){
        if(parserListner==null || DocParserListner.HANDLE==parserListner.beforeParsing(BEFORE_PARSING_ITEM, element)) {
            for(Element child:element.children()){
                if("link".equals(child.tagName()) || "meta".equals(child.tagName()) || child.hasAttr("itemscop") || child.hasAttr("itemtype")  || child.hasAttr("itemprop")){
                    ItemNode item=new ItemNode(child);
                    if(child.ownText()!=null && child.ownText().length()>0)item.appendText(child.ownText());
                    node.appendChild(item);
                    parseChild(deep+1, root, item, child);
                }else {
                    parseChild(deep, root, node, child);
                }
            }
        }
        parserListner.afterParsing(AFTER_PARSING_ITEM, element);
    }

    public ItemNode getRootItemNode(){
        return rootItemNode;
    }

}
