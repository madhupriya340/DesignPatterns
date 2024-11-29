package CreationalDesignPatterns.PrototypePattern;

interface Shape{
    Shape clone();
    void draw();
}

class Circle implements Shape{
    private String color;
    public Circle(String color){
    this.color=color;
    }
    
    public Shape clone(){
            return new Circle(this.color);
        }
    public void draw(){
        System.out.println("Drawing a "+color+" Circle");
    }

} 

class PrototypePattern{
    public static void main(String[] args){
        Shape circleShape= new Circle("blue");
        Shape clonedShape= circleShape.clone();
        clonedShape.draw();
    }

}