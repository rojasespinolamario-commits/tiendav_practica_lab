import adapter.ExternalPayPalService;
import adapter.PayPalAdapter;
import adapter.PaymentProcessor;
import model.Cart;
import model.Product;
import observer.AdminNotificationObserver;
import observer.EmailNotificationObserver;
import observer.IventoryObserver;
import service.OrderService;
import strategy.PercentageDiscountStrategy;

public class Main {
    public static void main(String[] args) {

        Product laptop= new Product("Laptop", 3500);
        Product mouse= new Product("Mouse", 100);

        Cart cart = new Cart();
        cart.addProduct(laptop);
        cart.addProduct(mouse);

        OrderService orderService = new OrderService();
        orderService.setDiscountStrategy(new PercentageDiscountStrategy(10));

        ExternalPayPalService payPalService = new ExternalPayPalService();

        PaymentProcessor paymentProcessor = new PayPalAdapter(payPalService);

        orderService.setPaymentProcessor(paymentProcessor);

        orderService.addObserver(new EmailNotificationObserver());

        orderService.addObserver(new IventoryObserver());

        orderService.addObserver(new AdminNotificationObserver());

        orderService.completeOrder(cart);
    }
}