package com.twu.refactor;

import java.util.ArrayList;

/**
 * Created by poojar on 3/18/2015.
 */
public class Html {
    private String tagName;
    private ArrayList<Html> children;
    private String innerText;
    public Html(String tagName) {
        this.tagName = tagName;
        this.children = new ArrayList<Html>();
        this.innerText = "";
    }
    public static Html createTag(String name) {
        return new Html(name);
    }
    public Html tag(String name) {
        Html child = new Html(name);
        this.children.add(child);
        return child;
    }
    public Html innerText(String innerText) {
        this.innerText = innerText;
        return this;
    }
    @Override
    public String toString() {
         return "<"+ tagName +">"+innerText+getChildren()+"</"+ tagName +">";
    }

    private String getChildren() {
        String children = "";
        for(Html child : this.children) { children += child.toString(); }
        return children;
    }
}
