package org.FileSystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Directory {
    private final String name;
    private final Directory parent;
    private final Map<String, Directory> children = new HashMap<>();

    Directory(String name_, Directory parent_){
        this.name = name_;
        this.parent = parent_;
    }

    public Directory getOrCreateChild(String childName){
        if(!children.containsKey(childName))
            children.put(childName, new Directory(childName, this));
        return children.get(childName);
    }

    public String getName(){
        return name;
    }
    public Directory getParent(){
        return parent;
    }
    public Map<String, Directory> getChildren(){
        return children;
    }
    public Directory getChild(String childName){
        return children.get(childName);
    }

}
