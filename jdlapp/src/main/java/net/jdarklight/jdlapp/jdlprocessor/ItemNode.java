package net.jdarklight.jdlapp.jdlprocessor;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.List;

public class ItemNode extends Element{
    private ItemNodes childItems=new ItemNodes();

    public ItemNode(Element element){
        super(element.tag(), element.baseUri(), element.attributes());
    }

    public void addChildItem(ItemNode item){
        this.childItems.addItem(item);
    }
}
