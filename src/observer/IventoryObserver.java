package observer;

public class IventoryObserver implements OrderObserver {

    @Override
    public void update (String message) {
        System.out.println("Actualizando inventario...");
    }
}
