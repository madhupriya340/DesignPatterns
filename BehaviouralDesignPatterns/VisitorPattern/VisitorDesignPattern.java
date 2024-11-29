package BehaviouralDesignPatterns.VisitorPattern;

interface RoomElement{
    public void accept(Visitor visitor);
}
class SingleRoom implements RoomElement{
    public int roomPrice=0;
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
    
}
class DoubleRoom implements RoomElement{
    public int roomPrice=0;
    @Override
    public void accept(Visitor visitor) {
        
    }
    
}
interface Visitor{
    public void visit(SingleRoom singleRoom);
    public void visit(DoubleRoom doubleRoom);
}
class RoomPricingVisitor implements Visitor{

    @Override
    public void visit(SingleRoom singleRoom) {
        System.out.println("Pricing computation logic of single room");
        singleRoom.roomPrice=1000;
    }

    @Override
    public void visit(DoubleRoom doubleRoom) {
        System.out.println("Pricing computation logic of double room");
        doubleRoom.roomPrice=2000;
    }
    
}
class RoomMaintenanceVisitor implements Visitor{

    @Override
    public void visit(SingleRoom singleRoom) {
        System.out.println("Performing maintenance logic of single room");
    }

    @Override
    public void visit(DoubleRoom doubleRoom) {
        System.out.println("Performing maintenance logic of double room");
    }
    
}
public class VisitorDesignPattern {
    public static void main(String[] args) {
        RoomElement roomElement= new SingleRoom();
        Visitor visitor= new RoomPricingVisitor();
        roomElement.accept(visitor);
        System.out.println(((SingleRoom)roomElement).roomPrice);

    }
}
