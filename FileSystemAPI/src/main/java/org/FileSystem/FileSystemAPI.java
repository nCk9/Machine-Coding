package org.FileSystem;

public class FileSystemAPI {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        FileSystem fs = new FileSystem();

        fs.mkdir("/home/user/docs");
        fs.mkdir("/var/logs");

        fs.cd("/home");
        System.out.println(fs.pwd()); // /home

        fs.cd("user");
        System.out.println(fs.pwd()); // /home/user

        fs.cd("d.*"); // regex: matches "docs"
        System.out.println(fs.pwd()); // /home/user/docs

        fs.cd("..");
        System.out.println(fs.pwd()); // /home/user
    }
}