package aplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.OrderStatus;
public class App {
    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Enter client data:");
        System.out.println("Name:");
        String name = sc.nextLine();

        System.out.println("Email:");
        String email = sc.next();

        System.out.println("Birth date (DD/MM/YYYY): ");
        Date birthDate = sdf.parse(sc.next());

        Client client = new Client(name, email, birthDate);

        System.out.println("Enter order data:");
        System.out.print("Status: ");

        OrderStatus status = OrderStatus.valueOf(sc.next());

        Order order = new Order(new Date(),status, client);

        System.out.println("How many items to this order?");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++){
            System.out.println("Enter" + i+1 + "item data:");
            System.out.println("Product name:");
            sc.nextLine();
            String product_name = sc.nextLine();

            System.out.println("Product price: ");
            double product_price = sc.nextDouble();

            System.out.println("Quantity:");
            int product_quantity = sc.nextInt();

            Product product = new Product(product_name, product_price);

            OrderItem item = new OrderItem(product_quantity,product_price, product);

            order.addItem(item);

        }

        System.out.println();
        System.out.println(order);

        sc.close();

    }
}
