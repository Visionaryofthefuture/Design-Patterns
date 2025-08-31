package StrategyPattern;


interface paymentStrategy{
    void makePayment(float amount);
}

class CreditCard implements paymentStrategy{
    private int pin_num;
    public CreditCard(int pin_num){
        this.pin_num = pin_num;
    }

    @Override
    public void makePayment(float amount){
        System.out.println("Making a transaction of : "+amount);
    }
}
public class PaymentService {
    private final paymentStrategy strategy;

    public PaymentService(paymentStrategy strategy){
        this.strategy = strategy;
    }
    public void pay(float amount){
        this.strategy.makePayment(amount);
    }

}
