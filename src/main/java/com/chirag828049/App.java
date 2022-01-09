package com.chirag828049;

import java.util.Scanner;
import java.util.Vector;

/**
 * Hello world!
 */
public final class App {

    private Vector<Manufacturer> manufacturerList;
    private Vector<Shop> shopList;
    private Vector<Product> productList;
    private Vector<DeliveryAgent> deliveryAgentList;
    private Vector<Customer> customerList;

    private App() {

        manufacturerList = new Vector<Manufacturer>();
        shopList = new Vector<Shop>();
        productList = new Vector<Product>();
        deliveryAgentList = new Vector<DeliveryAgent>();
        customerList = new Vector<Customer>();
    }

    /**
     * Says hello to the world.
     * 
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {

        // Don't create any more scanner objects. Use this everywhere.
        Scanner sc = new Scanner(System.in);

        System.out.println("WELCOME TO MEDIKO SOLUTIONS.");
        System.out.println("Here is a list of roles you can assume. please choose one from the list below.\n\n\n");

        int choice = 0;

        do {

            System.out.println("1. Manufacturer");
            System.out.println("2. Product");
            System.out.println("3. Shop/Warehouse");
            System.out.println("4. Delivery Agent");
            System.out.println("5. Customer");
            System.out.println(
                    "Enter a choice from 1-5. Enter 6 to exit from the program. Enter anything else to repeat the above message.\n\n");

            try {

                choice = sc.nextInt();
            } catch (Exception e) {

                sc.nextLine();
                choice = 0;
                System.out.println("Invalid choice.\n");
            }
        } while (choice != 6);

        System.out.println("\nHave a nice day. See you again.");
        sc.close();
    }
}
