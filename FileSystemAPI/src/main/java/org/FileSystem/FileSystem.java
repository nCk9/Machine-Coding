package org.FileSystem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

public class FileSystem {
    private final Directory root;
    private Directory currentDir;

    public FileSystem(){
        this.root = new Directory("/", null);
        this.currentDir = root;
    }

    //mkdir command
    public void mkdir(String path) {
        Directory dir = traverseAndCreate(path);
        System.out.println("Directory created: " + getPath(dir));
    }

    // cd command (supports regex)
    public void cd (String path) {
        Directory newDir = traverseWithRegex(path);
        if (newDir != null) {
            currentDir = newDir;
            System.out.println("Changed directory to: " + pwd());
        } else {
            System.out.println("cd: no matching directory for path: " + path);
        }
    }

    // pwd command
    public String pwd() {
        return getPath(currentDir);
    }

    //internal helper methods
    private Directory traverseAndCreate(String path){
        String[] parts = path.split("/");
        Directory node = path.startsWith("/") ? root : currentDir;

        for(String p: parts){
            if(p.isEmpty() || p.equals(".")) continue;
            if(p.equals("..")){
                node = node.getParent() == null ? node : node.getParent();
            }else{
                node = node.getOrCreateChild(p);
            }
        }
        return node;
    }

    private Directory traverseWithRegex(String path) {
        String[] parts = path.split("/");
        Directory node = path.startsWith("/") ? root : currentDir;

        for (String p : parts) {
            if (p.isEmpty() || p.equals(".")) continue;
            if (p.equals("..")) {
                node = node.getParent() != null ? node.getParent() : node;
            } else {
                // Regex-based matching
                Pattern pattern = Pattern.compile(p);
                Optional<Directory> match = node.getChildren().values()
                        .stream()
                        .filter(child -> pattern.matcher(child.getName()).matches())
                        .findFirst();
                if (match.isPresent()) {
                    node = match.get();
                } else {
                    return null;
                }
            }
        }
        return node;
    }

    private String getPath(Directory dir) {
        if (dir == root) return "/";
        List<String> path = new ArrayList<>();
        while (dir != null && dir != root) {
            path.add(dir.getName());
            dir = dir.getParent();
        }
        Collections.reverse(path);
        return "/" + String.join("/", path);
    }

}
