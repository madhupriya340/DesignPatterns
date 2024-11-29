package StructuralDesignPatterns.AdapterPattern;

interface WeightMachine{
    public double getWeightInPound();
}
class WeightMachineForBabies implements WeightMachine{

    @Override
    public double getWeightInPound() {
       return 28;
    }
    
}
interface WeightMachineAdapter{
    public double getWeightinKg();
}
class WeightMachineAdapterImp implements WeightMachineAdapter{
    WeightMachine weightMachine;
     WeightMachineAdapterImp(WeightMachine weightMachine){
        this.weightMachine=weightMachine;
    }
    @Override
    public double getWeightinKg() {
       double weight=weightMachine.getWeightInPound();
       return weight*45;
    }

}
public class AdapterPattern {
    public static void main(String[] args) {
        WeightMachineAdapter w= new WeightMachineAdapterImp(new WeightMachineForBabies());
        System.out.println(w.getWeightinKg());
    }
}
