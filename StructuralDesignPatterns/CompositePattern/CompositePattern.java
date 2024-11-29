package StructuralDesignPatterns.CompositePattern;

import java.util.ArrayList;
import java.util.List;

interface FileSystem{
    void ls();
}
class File implements FileSystem{
    String fileName;
    File(String fileName){
        this.fileName=fileName;
    }
    @Override
    public void ls() {
        System.out.println("File Name"+fileName);
    }
    
}
class Directory implements FileSystem{
    String directoryName;
    List<FileSystem> fileSystem;
    Directory(String name){
        this.directoryName=name;
        fileSystem= new ArrayList<>();
    }
    public void add(FileSystem file){
        fileSystem.add(file);
    }
    public void ls(){
        System.out.println("Directory name"+directoryName);
        for(FileSystem fileSystem: fileSystem){
            fileSystem.ls();
        }
    }
}
public class CompositePattern {
    public static void main(String[] args) {
        Directory dr= new Directory("Movie");
        FileSystem fl= new File("movie1");
        dr.add(fl);
        dr.ls();
    }
}
