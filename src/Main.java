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

        System.out.println("===== TIENDA VIRTUAL =====");
        System.out.println("--------------------------");

        Product laptop= new Product("Laptop", 3500);
        Product mouse= new Product("Mouse", 100);
        Product teclado= new Product("Teclado", 120.0);

        Cart cart = new Cart();
        cart.addProduct(laptop);
        cart.addProduct(mouse);
        cart.addProduct(teclado);

        System.out.println("\nPRODUCTOS EN CARRITO:");

        for (Product product: cart.getProducts()) {
            System.out.println(product.getName() + " - S/ " + product.getPrice());
        }

        System.out.println("--------------------------");

        OrderService orderService = new OrderService();

        orderService.setDiscountStrategy(new PercentageDiscountStrategy(10));

        System.out.println("Descuento aplicado: 10%");

        ExternalPayPalService payPalService = new ExternalPayPalService();

        PaymentProcessor paymentProcessor = new PayPalAdapter(payPalService);

        orderService.setPaymentProcessor(paymentProcessor);

        orderService.addObserver(new EmailNotificationObserver());

        orderService.addObserver(new IventoryObserver());

        orderService.addObserver(new AdminNotificationObserver());

        System.out.println("\n----- PROCESANDO COMPRA -----");

        orderService.completeOrder(cart);

        System.out.println("\n===== COMPRA FINALIZADA =====");
    }
}