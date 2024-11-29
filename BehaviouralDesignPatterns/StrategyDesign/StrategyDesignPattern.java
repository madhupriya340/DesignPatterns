package BehaviouralDesignPatterns.StrategyDesign;

interface PayStrategy{
	void pay(int amount);
} 
class CreditCardStrategy implements PayStrategy{
	public void pay(int amount){
		System.out.println("Credit card amount payed "+amount);
	}
}
class UpiStrategy implements PayStrategy{
	public void pay(int amount){
		System.out.println(" Upi amount payed "+amount);
	}
}
class CashStrategy implements PayStrategy{
	public void pay(int amount){
		System.out.println(" Cash amount payed "+amount);
	}
}

class PaymentService{
	PayStrategy obj;
	PaymentService(PayStrategy obj){
		this.obj=obj;
	}
	public void pay(int amount){
		obj.pay(amount);
	}

}


public class StrategyDesignPattern {
    public static void main(String[] args) {
        PaymentService ps= new PaymentService(new CashStrategy ());
		ps.pay(100);
    }
}
