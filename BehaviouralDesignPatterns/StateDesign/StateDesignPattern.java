package BehaviouralDesignPatterns.StateDesign;
interface VendingMachineState{
    void handleRequest();
}
class ReadyState implements VendingMachineState{
    public void handleRequest(){
        System.out.println("ready state");
    }
}

class ProductSelectedState implements VendingMachineState{
    public void handleRequest(){
        System.out.println("product selected state");
    }
}

class VendingMachineContext{
    private VendingMachineState state;
    public void setState(VendingMachineState state){
        this.state=state;
    }
    public void request(){
        state.handleRequest();
    }
}

public class StateDesignPattern {
    public static void main(String[] args) {
        VendingMachineContext vm= new VendingMachineContext();
        vm.setState(new ReadyState());
        vm.request();
    }    
}
