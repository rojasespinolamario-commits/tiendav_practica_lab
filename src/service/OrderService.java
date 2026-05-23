package service;
import adapter.PaymentProcessor;
import model.Cart;
import observer.OrderObserver;
import strategy.DiscountStrategy;

import java.util.ArrayList;
import java.util.List;

public class OrderService {

    private DiscountStrategy discountStrategy;
    private PaymentProcessor paymentProcessor;

    private List<OrderObserver> observers;

    public OrderService() {
        observers = new ArrayList<>();
    }

    public void setDiscountStrategy(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }

    public void setPaymentProcessor(PaymentProcessor paymentProcessor) {
        this.paymentProcessor = paymentProcessor;
    }

    public void addObserver (OrderObserver observer) {
        observers.add(observer);
    }

    public double calculateFinalTotal(Cart cart) {
        double total = cart.calculateTotal();

        if (discountStrategy != null) {
            total = discountStrategy.applyDiscount(total);
        }
        return total;
    }

    public void processPayment(double total) {
        if (paymentProcessor != null) {
            paymentProcessor.pay(total);
        }
    }

    public void notifyObservers(String message) {
        for (OrderObserver observer : observers) {
            observer.update(message);
        }
    }
}
