import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
public class Simulation {
    public static void main(String[] args) throws Exception {
        
        BlockingQueue<Order> ordersToKitchen = new LinkedBlockingQueue<>();
        BlockingQueue<Order> readyOrders = new LinkedBlockingQueue<>();

        Kitchen kitchenWorker = new Kitchen(ordersToKitchen, readyOrders);
        Thread kitchenThread = new Thread(kitchenWorker);

        Waiter waiter1 = new Waiter("Alexander", readyOrders);
        Thread t1 = new Thread(waiter1);

        Waiter waiter2 = new Waiter("Elizabeth", readyOrders);
        Thread t2 = new Thread(waiter2);

        kitchenThread.start();
        t1.start();
        t2.start();
        for (int i = 1; i <= 6; i++) {
            Order newOrder = new Order(i, "Meal-" + i, 10 + i);
            
            System.out.println("New order placed: " + newOrder);
            
            ordersToKitchen.put(newOrder);

            Thread.sleep(1500);
        }
        Thread.sleep(20000);
        System.out.println("Restaurant is closing now.");
        System.exit(0);
    }
}