package adapter;

public class YapePaymentProcessor {

    @Override
    public void pay (double amount) {
        System.out.println("Pago realizado con Yape: S/ " + amount);
    }
}
