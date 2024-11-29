package CreationalDesignPatterns.FactoryPattern;

interface Shape{
    void computeArea();
}

class Circle implements Shape{

    @Override
    public void computeArea() {
        System.out.println("Circle Area Implemented");
    }

}
class Rectangle implements Shape{

    @Override
    public void computeArea() {
        System.out.println("Rectangle Area Implemented");
    }

}
class Square implements Shape{

    @Override
    public void computeArea() {
        System.out.println("Square Area Implemented");
    }

}
class ShapeFactory{
    public Shape getShapeInstance(String name){
        if(name.equals("circle")){
            return new Circle();
        }
        else if (name.equals("rectangle")) {
            return new Rectangle();
        }
        else{
            return new Square();
        }
    }
}
public class FactoryPattern {
    public static void main(String[] args) {
        ShapeFactory fac= new ShapeFactory();
        Shape shape=fac.getShapeInstance("circle");
        System.out.println(shape);
    }
}
