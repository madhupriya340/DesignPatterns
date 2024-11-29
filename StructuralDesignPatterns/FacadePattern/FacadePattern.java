package StructuralDesignPatterns.FacadePattern;
class Product{
    String name;
    double price;
    int productId;
    Product(String name, double price, int productId){
        this.name=name;
        this.price=price;
        this.productId=productId;
    }
}
class ProductDao{
    public Product geProduct(int productId){
        return new Product("box",200,1);
    }
} 
class Invoice{
    public void generateInvoice(){

    }
}
class SendNotification{
    public void sendNotification(){

    }
}
class Payment{
    public boolean makePayment(){
        return true;
    }
}
class OrderFacade{
    ProductDao productDao;
    Payment payment;
    SendNotification sendNotification;
    Invoice invoice;
    OrderFacade(ProductDao productDao,Payment payment,Invoice invoice,SendNotification sendNotification){
        this.productDao=productDao;
        this.payment=payment;
        this.invoice=invoice;
        this.sendNotification=sendNotification;
    }
    public void createOrder(){
        // Product product= productDao.geProduct(1);
        payment.makePayment();
        invoice.generateInvoice();
        sendNotification.sendNotification();
        
    }
}
public class FacadePattern {
    public static void main(String[] args) {
        OrderFacade orderFacade= new OrderFacade(new ProductDao(), new Payment(), new Invoice(), new SendNotification());
        orderFacade.createOrder();
    }
}
