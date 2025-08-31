package StrategyPattern;


public class PaymentMethodMain  {


    public static void main(String[] args){
    PaymentService paymentGateway = new PaymentService(new CreditCard(1234));
    paymentGateway.pay(1234);
    }

}
