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

    // METHODS RELATED TO MANUFACTURER

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

        System.out.println("\nPrinting list of Manufacturers.");
        manufacturerList.forEach((manufacturer) -> {
            System.out.println(manufacturer.getID() + " " + manufacturer.getName());
        });
    }

    private static int getManufacturerIndex(Scanner sc) {

        printManufacturers();
        System.out.println("\nEnter a Manufacturer ID to select it.");
        try {

            sc.nextLine();
            System.out.print("ID : ");
            int ID = Integer.parseInt(sc.nextLine());
            boolean isFound = false;
            int index = -1;

            for (Manufacturer temp : manufacturerList) {

                index++;
                if (temp.getID() == ID) {
                    System.out.println("Selected " + temp.getID() + " " + temp.getName());
                    isFound = true;
                    break;
                }
            }

            if (isFound) {
                return index;
            } else
                System.out.println("Manufacturer ID not found. Please try again.");

        } catch (Exception e) {

            System.out.println("Some error occured. Please try again");
            return -1;
        }

        return -1;
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

    // METHODS RELATED TO SHOP

    private static void addShop(Scanner sc) {

        System.out.println("Enter ID, Name and zipcode of shop to add");
        try {

            sc.nextLine();
            System.out.print("ID : ");
            int ID = Integer.parseInt(sc.nextLine());
            System.out.print("Name : ");
            String name = sc.nextLine();
            System.out.print("ZipCode : ");
            int zipcode = Integer.parseInt(sc.nextLine());

            boolean isPresent = false;
            for (Shop temp : shopList) {

                if (temp.getID() == ID) {
                    System.out.println("Shop with this ID is already present. Not Added.");
                    isPresent = true;
                    break;
                }
            }

            if (!isPresent) {

                boolean isAdded = shopList.add(new Shop(ID, name, zipcode));
                if (isAdded)
                    System.out.println("Successfully added shop.");
                else
                    System.out.println("Error saving shop. Please try again");
            }

        } catch (Exception e) {

            System.out.println("Some error occured. Please try again");
        }
    }

    private static void printShops() {

        System.out.println("\nPrinting list of Shops.");
        shopList.forEach((shop) -> {
            System.out.println(shop.getID() + " " + shop.getName() + " " + shop.getZipCode());
        });
    }

    private static void deleteShop(Scanner sc) {

        printShops();
        System.out.println("\nEnter a Shop ID to delete it.");
        try {

            sc.nextLine();
            System.out.print("ID : ");
            int ID = Integer.parseInt(sc.nextLine());
            boolean isFound = false;
            int index = -1;

            for (Shop temp : shopList) {

                index++;
                if (temp.getID() == ID) {
                    System.out.println("Deleting " + temp.getID() + " " + temp.getName());
                    isFound = true;
                    break;
                }
            }

            if (isFound) {
                shopList.remove(index);
            } else
                System.out.println("Shop ID not found. Please try again.");

        } catch (Exception e) {

            System.out.println("Some error occured. Please try again");
        }
    }

    private static void printProductsOfShop(Scanner sc) {

        printShops();
        System.out.println("\nEnter a Shop ID to print all its products with quantity available.");
        try {

            sc.nextLine();
            System.out.print("ID : ");
            int ID = Integer.parseInt(sc.nextLine());
            boolean isFound = false;
            int index = -1;

            for (Shop temp : shopList) {

                index++;
                if (temp.getID() == ID) {
                    System.out.println("\nFound " + temp.getID() + " " + temp.getName());
                    isFound = true;
                    break;
                }
            }

            if (isFound) {
                shopList.get(index).printAllProducts();
            } else
                System.out.println("Shop ID not found. Please try again.");

        } catch (Exception e) {

            System.out.println("Some error occured. Please try again");
        }
    }

    private static void shopPanel(Scanner sc) {

        int choice = 0;
        System.out.println("\nWelcome to Shop panel");

        do {
            System.out.println("\nChoose from the below options.");
            System.out.println("1. Add a shop");
            System.out.println("2. Delete a shop");
            System.out.println("3. Print all shops");
            System.out.println("4. Print all products of a shop with their quantity");
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
                    // Add a Shop.
                    addShop(sc);
                    break;

                case 2:
                    // Delete a shop
                    deleteShop(sc);
                    break;

                case 3:
                    // Print all shops.
                    printShops();
                    break;

                case 4:
                    // Print all products available in a shop.
                    printProductsOfShop(sc);
                    break;

                default:
                    break;
            }
        } while (choice != 5);

        System.out.println("Exiting Shop panel.\n");
    }

    // METHODS RELATED TO PRODUCT

    private static void addProduct(Scanner sc) {

        System.out.println("Enter ID and Name of product to add");
        try {

            sc.nextLine();
            System.out.print("ID : ");
            int ID = Integer.parseInt(sc.nextLine());
            System.out.print("Name : ");
            String name = sc.nextLine();

            boolean isPresent = false;
            for (Product temp : productList) {

                if (temp.getID() == ID) {
                    System.out.println("Product with this ID is already present. Not Added.");
                    isPresent = true;
                    break;
                }
            }

            if (!isPresent) {

                // select a manufacturer for this product
                int manufacturerIndex = -1;
                do {

                    manufacturerIndex = getManufacturerIndex(sc);
                } while (manufacturerIndex != -1);

                boolean isAdded = productList.add(new Product(ID, name, manufacturerList.get(manufacturerIndex)));
                if (isAdded)
                    System.out.println("Successfully added product.");
                else
                    System.out.println("Error saving product. Please try again");
            }

        } catch (Exception e) {

            System.out.println("Some error occured. Please try again");
        }
    }

    private static void printProducts() {

        System.out.println("\nPrinting list of Products.");
        productList.forEach((product) -> {
            System.out.println(product.getID() + " " + product.getName() + " " + product.getManufacturer().getName());
        });
    }

    private static void deleteProduct(Scanner sc) {

        printProducts();
        System.out.println("\nEnter a Product ID to delete it.");
        try {

            sc.nextLine();
            System.out.print("ID : ");
            int ID = Integer.parseInt(sc.nextLine());
            boolean isFound = false;
            int index = -1;

            for (Product temp : productList) {

                index++;
                if (temp.getID() == ID) {
                    System.out.println("Deleting " + temp.getID() + " " + temp.getName());
                    isFound = true;
                    break;
                }
            }

            if (isFound) {
                productList.get(index).getManufacturer().deleteProduct(productList.get(index));
                for (Shop shop : shopList) {
                    shop.deleteProduct(productList.get(index));
                }
                productList.remove(index);
            } else
                System.out.println("Shop ID not found. Please try again.");

        } catch (Exception e) {

            System.out.println("Some error occured. Please try again");
        }
    }

    private static void productPanel(Scanner sc) {

        int choice = 0;
        System.out.println("\nWelcome to Product panel");

        do {
            System.out.println("\nChoose from the below options.");
            System.out.println("1. Add a product");
            System.out.println("2. Delete a product");
            System.out.println("3. Print all products");
            System.out.println("Enter a choice between 1-3. Enter 4 to go back to main menu.\n\n");

            try {

                choice = sc.nextInt();
            } catch (Exception e) {

                sc.nextLine();
                choice = 0;
                System.out.println("Invalid choice.\n");
            }

            switch (choice) {

                case 1:
                    // Add a product.
                    addProduct(sc);
                    break;

                case 2:
                    // Delete a product.
                    deleteProduct(sc);
                    break;

                case 3:
                    // Print all products.
                    printProducts();
                    break;

                default:
                    break;
            }
        } while (choice != 4);

        System.out.println("Exiting Product panel.\n");
    }

    // METHODS RELATED TO DELIVERY AGENT

    private static void deliveryAgentPanel(Scanner sc) {

        System.out.println("\nWelcome to Delivery Agent panel");
    }

    // METHODS RELATED TO CUSTOMER

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
