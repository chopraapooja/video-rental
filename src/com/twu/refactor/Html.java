package com.twu.refactor;

import java.util.ArrayList;

/**
 * Created by poojar on 3/18/2015.
 */
public class Html {
    String name;
    ArrayList<Html> childs ;
    String innerText;
    Html(String name) {
        this.name = name;
        this.childs = new ArrayList<Html>();
        this.innerText = "";
    }
    static Html createTag(String name) {
        return new Html(name);
    }
    Html tag(String name) {
        Html child = new Html(name);
        this.childs.add(child);
        return child;
    }
    void innerText(String innerText) {
        this.innerText = innerText;
    }
    @Override
    public String toString() {
        if(childs.size() > 0 ){
            String innerHtml = "<"+name+">"+innerText;
            for(Html child : childs) {
                innerHtml += child.toString();
            }
            return innerHtml += "</"+name+">";
        }
        else
            return "<"+name+">"+innerText+"</"+name+">";
    }
    public static void main(String[] args) {
        Html html= Html.createTag("html");
        Html table = html.tag("table");
        Html row1 = table.tag("tr");
        Html row2 = table.tag("tr");
        Html td11 = row1.tag("td"), td12 = row1.tag("td");
        Html td21 = row2.tag("td"), td22 = row2.tag("td");
        td11.innerText("Bustor Keton");
        td12.innerText("dhoom");
        td21.innerText("3.4");
        td22.innerText("10.98");
        System.out.println(html);
    }
}
