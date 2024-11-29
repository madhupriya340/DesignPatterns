package BehaviouralDesignPatterns.MementoPattern;
import java.util.ArrayList;
import java.util.List;

class ConfigurationOriginator{
    int height;
    int width;
    ConfigurationOriginator(int height, int width){
        this.height=height;
        this.width=width;
    }
    public void setHeight(int height){
        this.height=height;
    }
    public void setWidth(int width){
        this.width=width;
    }
    public ConfigurationMemento createMemento(){
        return new ConfigurationMemento(this.height,this.width);
    }
    public void restoreMemento(ConfigurationMemento mementotoRestore){
        this.height=mementotoRestore.height;
        this.width=mementotoRestore.width;

    }
}
class ConfigurationMemento{
    int height;
    int width;
    ConfigurationMemento(int height,int width){
        this.height=height;
        this.width=width;
    }
    int getHeight(){
        return this.height;
    }
    int getWidth(){
        return this.width;
    }
}
class ConfigurationCareTaker{
    List<ConfigurationMemento> history= new ArrayList<>();
    public void addMemento(ConfigurationMemento memento){
        history.add(memento);
    }
    public ConfigurationMemento undo(){
        if(!history.isEmpty()){
            int size=history.size()-1;
            ConfigurationMemento lastmemo= history.get(size);
            history.remove(lastmemo);
            return lastmemo;
        }
        return null;
    }
}
public class MementoDesignPattern {
    public static void main(String[] args) {
        ConfigurationCareTaker c1= new ConfigurationCareTaker();
        ConfigurationOriginator o1= new ConfigurationOriginator(10,11);
        ConfigurationMemento m1=o1.createMemento();
        c1.addMemento(m1);
    }
}
