package com.chirag828049;

import java.util.Scanner;
import java.util.Vector;

/**
 * Hello world!
 */
public final class App {

    private static Vector<Manufacturer> manufacturerList = new Vector<Manufacturer>();
    private static Vector<Shop> shopList = new Vector<Shop>();
    private static Vector<Product> productList = new Vector<Product>();
    private static Vector<DeliveryAgent> deliveryAgentList = new Vector<DeliveryAgent>();
    private static Vector<Customer> customerList = new Vector<Customer>();

    private App() {
    }

    private static void addManufacturer(Scanner sc) {

        System.out.println("Enter ID and Name of manufacturer to add");
        try {

            sc.nextLine();
            System.out.print("ID : ");
            int ID = Integer.parseInt(sc.nextLine());
            System.out.print("Name : ");
            String name = sc.nextLine();

            boolean isPresent = false;
            for (Manufacturer temp : manufacturerList) {

                if (temp.getID() == ID) {
                    System.out.println("Manufacturer with this ID is already present. Not Added.");
                    isPresent = true;
                    break;
                }
            }

            if (!isPresent) {

                boolean isAdded = manufacturerList.add(new Manufacturer(ID, name));
                if (isAdded)
                    System.out.println("Successfully added manufacturer.");
                else
                    System.out.println("Error saving manufacturer. Please try again");
            }

        } catch (Exception e) {

            System.out.println("Some error occured. Please try again");
        }
    }

    private static void printManufacturers() {

        System.out.println("Printing list of Entities.");
        manufacturerList.forEach((manufacturer) -> {
            System.out.println(manufacturer.getID() + " " + manufacturer.getName());
        });
    }

    private static void deleteManufacturer(Scanner sc) {

        printManufacturers();
        System.out.println("\nEnter a Manufacturer ID to delete it.");
        try {

            sc.nextLine();
            System.out.print("ID : ");
            int ID = Integer.parseInt(sc.nextLine());
            boolean isFound = false;
            int index = -1;

            for (Manufacturer temp : manufacturerList) {

                index++;
                if (temp.getID() == ID) {
                    System.out.println("Deleting " + temp.getID() + " " + temp.getName());
                    isFound = true;
                    break;
                }
            }

            if (isFound) {
                Manufacturer tempManufacturer = manufacturerList.get(index);
                tempManufacturer.deleteManufacturer();
                manufacturerList.remove(index);
            } else
                System.out.println("Manufacturer ID not found. Please try again.");

        } catch (Exception e) {

            System.out.println("Some error occured. Please try again");
        }
    }

    private static void printProductsOfManufacturer(Scanner sc) {

        printManufacturers();
        System.out.println("\nEnter a Manufacturer ID to print all its products.");
        try {

            sc.nextLine();
            System.out.print("ID : ");
            int ID = Integer.parseInt(sc.nextLine());
            boolean isFound = false;
            int index = -1;

            for (Manufacturer temp : manufacturerList) {

                index++;
                if (temp.getID() == ID) {
                    System.out.println("Deleting " + temp.getID() + " " + temp.getName());
                    isFound = true;
                    break;
                }
            }

            if (isFound) {
                Manufacturer tempManufacturer = manufacturerList.get(index);
                Vector<Product> tempProductList = tempManufacturer.getAllProductsList();
                System.out.println("\nPrinting all products of " + tempManufacturer.getName());
                for (Product product : tempProductList) {
                    System.out.println(product.getID() + " " + product.getName());
                }
            } else
                System.out.println("Manufacturer ID not found. Please try again.");

        } catch (Exception e) {

            System.out.println("Some error occured. Please try again");
        }
    }

    private static void manufacturerPanel(Scanner sc) {

        int choice = 0;
        System.out.println("\nWelcome to Manufacturer panel");

        do {
            System.out.println("\nChoose from the below options.");
            System.out.println("1. Add a manufacturer");
            System.out.println("2. Delete a manufacturer");
            System.out.println("3. Print all manufacturers");
            System.out.println("4. Print all products of a manufacturer");
            System.out.println("Enter a choice between 1-4. Enter 5 to go back to main menu.\n\n");

            try {

                choice = sc.nextInt();
            } catch (Exception e) {

                sc.nextLine();
                choice = 0;
                System.out.println("Invalid choice.\n");
            }

            switch (choice) {

                case 1:
                    // Add a manufacturer.
                    addManufacturer(sc);
                    break;

                case 2:
                    // Delete a manufacturer
                    deleteManufacturer(sc);
                    break;

                case 3:
                    // Print all manufacturers.
                    printManufacturers();
                    break;

                case 4:
                    // Print all products of a manufacturer.
                    printProductsOfManufacturer(sc);
                    break;

                default:
                    break;
            }
        } while (choice != 5);

        System.out.println("Exiting Manufacturer panel.\n");
    }

    private static void shopPanel(Scanner sc) {

        System.out.println("\nWelcome to Shop panel");
    }

    private static void productPanel(Scanner sc) {

        System.out.println("\nWelcome to Product panel");
    }

    private static void deliveryAgentPanel(Scanner sc) {

        System.out.println("\nWelcome to Delivery Agent panel");
    }

    private static void customerPanel(Scanner sc) {

        System.out.println("\nWelcome to Customer panel");
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

            switch (choice) {
                case 1:
                    manufacturerPanel(sc);
                    break;
                case 2:
                    productPanel(sc);
                    break;
                case 3:
                    shopPanel(sc);
                    break;
                case 4:
                    deliveryAgentPanel(sc);
                    break;
                case 5:
                    customerPanel(sc);
                    break;
                default:
                    break;
            }
        } while (choice != 6);

        System.out.println("\nHave a nice day. See you again.");
        sc.close();
    }
}
