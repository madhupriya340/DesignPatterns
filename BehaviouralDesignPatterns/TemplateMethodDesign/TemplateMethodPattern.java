package BehaviouralDesignPatterns.TemplateMethodDesign;

abstract class BewarageMaker{
    public final void makeBewarage(){
        boilWater();
        brew();
        pourInCup();
        addCondiments();
    }
    public void boilWater(){
        System.out.println("Boiling Water");
    }
    public void pourInCup(){
        System.out.println("Poured into cup");
    }
    abstract void brew();
    abstract void addCondiments();
}
class TeaMaker extends BewarageMaker{

    @Override
    void brew() {
        System.out.println("Steeping the tea");
    }

    @Override
    void addCondiments() {
        System.out.println("Adding lemon");
    }
    
} 
public class TemplateMethodPattern {
    public static void main(String[] args) {
        System.out.println("Making Bewarages");
        BewarageMaker tea= new TeaMaker();
        tea.makeBewarage();
    }
}
