package StructuralDesignPatterns.DecoratorPattern;

interface Coffee{
    String getDescription();
    double cost();

}
class SimpleCoffee implements Coffee{

    @Override
    public String getDescription() {
        return "Simple Coffee";
    }

    @Override
    public double cost() {
        return 2.0;
    }
    
}
class CoffeDecorator implements Coffee{
    Coffee coffee;
    CoffeDecorator(Coffee coffee){
        this.coffee=coffee;
    }
    @Override
    public String getDescription() {
        return this.coffee.getDescription();
    }
    @Override
    public double cost() {
        return this.coffee.cost();
    }

}
class WithBadamMilk extends CoffeDecorator{
    WithBadamMilk(Coffee coffee){
        super(coffee);
    }
    public String getDescription() {
        return coffee.getDescription()+"with Badam";
    }

    public double cost(){
        return cost()+5.0;
    }
}
public class DecoratorPattern {
    public static void main(String[] args) {
        CoffeDecorator coffee= new WithBadamMilk(new SimpleCoffee());
        System.out.println(coffee.getDescription());;
    }
}
